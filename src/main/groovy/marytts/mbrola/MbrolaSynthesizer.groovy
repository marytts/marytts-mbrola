package marytts.mbrola

import marytts.exceptions.SynthesisException
import marytts.modules.synthesis.*

import org.w3c.dom.Element

import javax.sound.sampled.AudioInputStream

class MbrolaSynthesizer implements WaveformSynthesizer {

    @Override
    void startup() throws Exception {

    }

    @Override
    void powerOnSelfTest() throws Error {

    }

    @Override
    AudioInputStream synthesize(List<Element> tokensAndBoundaries, Voice voice, String outputParams) throws SynthesisException {
        return null
    }
}
