package Characters;

public enum CharacterNames {
    NORMAN_WITHERS (NormanWithers.class),
    LILY_CHEN (LilyChen.class); /*
    MARK_HARRYGAN ("Mark Harrygan"),
    MINH_THI_PHAN ("Minh Thi Phan"),
    MANDY_THOMPSON ("Mandy Thompson"),
    JOE_DIAMOND ("Joe Diamond")*/

    private Class classobject;

    CharacterNames (Class name) {
        this.classobject = name;
    }

    public Class getClassobject() {
        return this.classobject;
    }
}
