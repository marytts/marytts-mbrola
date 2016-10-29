package marytts.mbrola

import groovy.util.logging.Log4j

import marytts.exceptions.SynthesisException
import marytts.modules.synthesis.*

import org.w3c.dom.Element

import javax.sound.sampled.AudioInputStream

@Log4j
class MbrolaSynthesizer implements WaveformSynthesizer {

    File mbrola

    @Override
    void startup() throws Exception {
        mbrola = File.createTempFile('mbrola-', '.bin')
        mbrola.executable = true
        def binStream = getClass().getResourceAsStream('bin/mbrola-mac')
        mbrola << binStream.bytes
        log.debug "unpacked MBROLA binary to: $mbrola"
    }

    @Override
    void powerOnSelfTest() throws Error {
        def proc = "$mbrola".execute()
        proc.waitFor()
        def out = proc.inputStream.text
        log.debug "\n$out"
    }

    @Override
    AudioInputStream synthesize(List<Element> tokensAndBoundaries, Voice voice, String outputParams) throws SynthesisException {
        return null
    }
}
