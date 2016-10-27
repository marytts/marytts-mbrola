package marytts.mbrola

import marytts.config.SynthesisConfig
import marytts.exceptions.MaryConfigurationException

class MbrolaConfig extends SynthesisConfig {

    MbrolaConfig() {
        super(MbrolaConfig.class.getResourceAsStream('mbrola.config'))
    }
}
