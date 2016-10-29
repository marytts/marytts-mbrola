package marytts.mbrola

import groovy.util.logging.Log4j

import marytts.modules.InternalModule
import marytts.modules.synthesis.WaveformSynthesizer

import static marytts.mbrola.MbrolaDataType.MBROLA
import static marytts.datatypes.MaryDataType.AUDIO

@Log4j
class MbrolaSynthesis extends InternalModule {

    WaveformSynthesizer synthesizer

    MbrolaSynthesis() {
        this(Locale.US)
    }

    MbrolaSynthesis(Locale locale) {
        super(getClass().name, MBROLA, AUDIO, locale)
        synthesizer = new MbrolaSynthesizer()
        log.debug 'starting up MbrolaSynthesizer'
        synthesizer.startup()
        synthesizer.powerOnSelfTest()
        log.debug 'MbrolaSynthesizer ready'
    }
}
