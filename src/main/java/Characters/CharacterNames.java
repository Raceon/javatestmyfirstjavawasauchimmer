package Characters;

public enum CharacterNames {
    NORMAN_WITHERS (NormanWithers.class)
    /*LILY_CHEN ("Lily Chen"),
    MARK_HARRYGAN ("Mark Harrygan"),
    MINH_THI_PHAN ("Minh Thi Phan"),
    MANDY_THOMPSON ("Mandy Thompson"),
    JOE_DIAMOND ("Joe Diamond")*/;

    private Class name;

    CharacterNames (Class name) {
        this.name = name;
    }

    public Class getName () {
        return this.name;
    }
}
