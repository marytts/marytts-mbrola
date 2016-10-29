package marytts.mbrola

import marytts.datatypes.MaryData
import marytts.modules.ModuleRegistry
import marytts.util.MaryRuntimeUtils
import marytts.util.dom.MaryDomUtils

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

    @Test
    void testProcess() {
        def input = getClass().getResourceAsStream('welcome.ACOUSTPARAMS')
        def inputDoc = MaryDomUtils.parseDocument(input)
        def inputData = new MaryData(ACOUSTPARAMS, Locale.US)
        inputData.document = inputDoc
        def module = new MbrolaConverter(Locale.US)
        def outputData = module.process(inputData)

        def actual = outputData.plainText
        def expected = getClass().getResourceAsStream('welcome.MBROLA').text
        assert actual == expected
    }
}
