package marytts.mbrola

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class MbrolaPhone {

    String phone
    int duration
    TreeMap<Integer, Integer> frequencies = [:]

    @Override
    String toString() {
        def phoneStr = "$phone $duration"
        if (frequencies) {
            phoneStr += " ${frequencies.collect { percentage, frequency -> "($percentage,$frequency)" }.join()}"
        }
        phoneStr
    }
}
