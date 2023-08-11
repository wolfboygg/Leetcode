package design.single;
public class SingleByE {
    private static SingleByE sInstance = new SingleByE();

    private SingleByE() {}

    public static SingleByE getInstance() {
        return sInstance;
    }


}
