package marytts.mbrola

import org.testng.annotations.Test

import static marytts.mbrola.MbrolaDataType.MBROLA

class MbrolaDataTypeTest {

    @Test
    void testTraits() {
        assert MBROLA.name() == 'MBROLA'
        assert MBROLA.isInputType()
        assert MBROLA.isOutputType()
        assert MBROLA.isTextType()
    }

}
