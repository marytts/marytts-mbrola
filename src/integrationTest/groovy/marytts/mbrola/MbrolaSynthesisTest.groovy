package marytts.mbrola

import marytts.modules.ModuleRegistry
import marytts.util.MaryRuntimeUtils

import org.testng.annotations.*

import static marytts.mbrola.MbrolaDataType.MBROLA
import static marytts.datatypes.MaryDataType.AUDIO

class MbrolaSynthesisTest {

    @BeforeClass
    void setUp() {
        MaryRuntimeUtils.ensureMaryStarted()
    }

    @Test
    void testModuleRegistered() {
        def modules = ModuleRegistry.allModules
        assert modules.find { it instanceof MbrolaSynthesis }
    }

    @Test
    void testModuleRequiredForProcessing() {
        def modules = ModuleRegistry.modulesRequiredForProcessing(MBROLA, AUDIO, Locale.US)
        assert modules.find { it instanceof MbrolaSynthesis }
    }
}
