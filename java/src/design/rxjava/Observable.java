package design.rxjava;
public class Observable {
    private Onsubscribe onsubscribe;
    private Observable(Onsubscribe onsubscribe) {
        this.onsubscribe = onsubscribe;
    }

    public static Observable create(Onsubscribe onsubscribe) {
        return new Observable(onsubscribe);
    }

    public void subscribe(Subscribe subscribe) {
        onsubscribe.call(subscribe);
    }

}
