package marytts.mbrola

import org.testng.annotations.Test

class MbrolaUtteranceTest {

    @Test
    void testToString() {
        def expected = '''|a 10
                          |b 20 (0,40)
                          |c 15
                          |d 5 (10,50)(80,75)
                          |'''.stripMargin().trim()
        def utterance = new MbrolaUtterance(
                new MbrolaPhone(phone: 'a', duration: 10),
                new MbrolaPhone(phone: 'b', duration: 20, frequencies: [0: 40]),
                new MbrolaPhone(phone: 'c', duration: 15),
                new MbrolaPhone(phone: 'd', duration: 5, frequencies: [80: 75, 10: 50]) // note the disorder
        )
        assert utterance.toString() == expected
    }
}
