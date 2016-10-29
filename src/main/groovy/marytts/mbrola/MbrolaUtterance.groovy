package marytts.mbrola

class MbrolaUtterance {

    List<MbrolaPhone> phones

    MbrolaUtterance(MbrolaPhone... phones) {
        this.phones = phones
    }

    @Override
    String toString() {
        phones.collect { it.toString() }.join('\n')
    }
}
