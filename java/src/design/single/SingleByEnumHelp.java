package design.single;
public enum SingleByEnumHelp {
    INSTANCE;

    private SingleByEnum sInstance;
    SingleByEnumHelp() {
        sInstance = new SingleByEnum();
    }

    public static SingleByEnum getInstance() {
        return INSTANCE.sInstance;
    }
}
