package marytts.mbrola

import groovy.util.logging.Log4j

import marytts.datatypes.MaryData
import marytts.modules.InternalModule
import marytts.util.dom.MaryDomUtils

import static marytts.datatypes.MaryDataType.ACOUSTPARAMS
import static marytts.mbrola.MbrolaDataType.MBROLA

@Log4j
class MbrolaConverter extends InternalModule {

    MbrolaConverter() {
        this(Locale.US)
    }

    MbrolaConverter(Locale locale) {
        super('MbrolaConverter', ACOUSTPARAMS, MBROLA, locale)
    }

    @Override
    MaryData process(MaryData data) {
        def doc = data.getDocument()
        def xmlStr = MaryDomUtils.serializeToString(doc)
        log.debug "MaryXML input:\n$xmlStr"
        def xml = new XmlSlurper().parseText(xmlStr)

        def mbrolaPhones = []
        log.debug 'processing XML elements'
        xml.depthFirst().each { node ->
            switch (node.name()) {
                case 'ph':
                    log.debug "found ph${node.attributes()}"
                    def mbrolaPhone = new MbrolaPhone(phone: node.@p, duration: Integer.parseInt("${node.@d}"))
                    def f0 = "${node.@f0}"
                    if (f0) {
                        log.debug "parsing f0 attribute: $f0"
                        def values = f0.replaceAll(~/[,()]/, ' ').split().collect {
                            Integer.parseInt(it)
                        }
                        def map = values.collate(2).collectEntries()
                        mbrolaPhone.frequencies = map
                    }
                    log.debug "converted to MBROLA phone: $mbrolaPhone"
                    mbrolaPhones << mbrolaPhone
                    break
                case 'boundary':
                    log.debug "found boundary${node.attributes()}"
                    def mbrolaPhone = new MbrolaPhone(phone: '_', duration: Integer.parseInt("${node.@duration}"))
                    log.debug "converted to MBROLA phone: $mbrolaPhone"
                    mbrolaPhones << mbrolaPhone
                    break
                default:
                    break
            }
        }
        def mbrolaUtterance = new MbrolaUtterance(*mbrolaPhones)
        log.debug "MBROLA output:\n$mbrolaUtterance"

        data.plainText = mbrolaUtterance.toString()
        return data
    }
}
