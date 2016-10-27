package marytts.mbrola

import marytts.server.MaryProperties
import org.testng.annotations.*

class MbrolaConfigTest {

    def config

    @BeforeClass
    void setUp() {
        config = new MbrolaConfig()
    }

    @Test
    void hasSynthesizerProperty() {
        def synthesizers = MaryProperties.synthesizerClasses()
        assert synthesizers.contains('marytts.mbrola.MbrolaSynthesizer')
    }

    @Test
    void isSynthesizerConfig() {
        assert config.isSynthesisConfig()
    }
}
