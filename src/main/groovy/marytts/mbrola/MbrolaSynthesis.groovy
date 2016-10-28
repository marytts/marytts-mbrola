package marytts.mbrola

import marytts.modules.InternalModule

import static marytts.mbrola.MbrolaDataType.MBROLA
import static marytts.datatypes.MaryDataType.AUDIO

class MbrolaSynthesis extends InternalModule {

    MbrolaSynthesis() {
        this(Locale.US)
    }

    MbrolaSynthesis(Locale locale) {
        super(getClass().name, MBROLA, AUDIO, locale)
    }
}
