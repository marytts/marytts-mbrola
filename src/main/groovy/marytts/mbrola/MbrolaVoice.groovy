package marytts.mbrola

import marytts.exceptions.MaryConfigurationException
import marytts.modules.synthesis.*

class MbrolaVoice extends Voice {

    MbrolaVoice(String name, WaveformSynthesizer synthesizer) throws MaryConfigurationException {
        super(name, synthesizer)
    }
}
