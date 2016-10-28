package marytts.mbrola

import marytts.modules.InternalModule

import static marytts.datatypes.MaryDataType.ACOUSTPARAMS
import static marytts.mbrola.MbrolaDataType.MBROLA

class MbrolaConverter extends InternalModule {

    MbrolaConverter() {
        this(Locale.US)
    }

    MbrolaConverter(Locale locale) {
        super('MbrolaConverter', ACOUSTPARAMS, MBROLA, locale)
    }
}
