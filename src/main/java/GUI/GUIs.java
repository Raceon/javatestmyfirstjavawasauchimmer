package GUI;

public enum GUIs {

    Console (ConsoleGUI.class),
    Desktop (JavaFXGUI.class);

    private Class classobject;

    GUIs(Class name) {
        this.classobject = name;
    }

    public Class getClassobject() {
        return this.classobject;
    }
}
