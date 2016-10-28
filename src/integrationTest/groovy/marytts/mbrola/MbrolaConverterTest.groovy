package marytts.mbrola

import marytts.modules.ModuleRegistry
import marytts.util.MaryRuntimeUtils

import org.testng.annotations.*

import static marytts.datatypes.MaryDataType.ACOUSTPARAMS
import static marytts.mbrola.MbrolaDataType.MBROLA

class MbrolaConverterTest {

    @BeforeClass
    void setUp() {
        MaryRuntimeUtils.ensureMaryStarted()
    }

    @Test
    void testModuleRegistered() {
        def modules = ModuleRegistry.allModules
        assert modules.find { it instanceof MbrolaConverter }
    }

    @Test
    void testModuleRequiredForProcessing() {
        def modules = ModuleRegistry.modulesRequiredForProcessing(ACOUSTPARAMS, MBROLA, Locale.US)
        assert modules.find { it instanceof MbrolaConverter }
    }
}
