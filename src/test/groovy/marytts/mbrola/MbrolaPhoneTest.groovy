package marytts.mbrola

import org.testng.annotations.*

class MbrolaPhoneTest {

    MbrolaPhone mbrolaPhone

    @BeforeMethod
    void setUpTest() {
        mbrolaPhone = new MbrolaPhone()
        mbrolaPhone.phone = 'abc'
        mbrolaPhone.duration = 123
    }

    @Test
    void testEquals() {
        def otherMbrolaPhone = new MbrolaPhone(phone: 'abc', duration: 123)
        assert this.mbrolaPhone == otherMbrolaPhone
    }

    @Test
    void testFrequencies() {
        assert mbrolaPhone.frequencies instanceof TreeMap
        assert mbrolaPhone.frequencies.isEmpty()
    }

    @Test
    void testToStringWithoutFrequencies() {
        assert mbrolaPhone.toString() == "abc 123"
    }

    @Test
    void testToStringWithFrequencies() {
        mbrolaPhone.frequencies << [20: 30, 0: 10, 40: 50] // note the disorder
        assert mbrolaPhone.toString() == "abc 123 (0,10)(20,30)(40,50)"
    }
}
