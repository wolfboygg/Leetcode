package rx_observer;

public class Subscriber<T> implements Observer<T> {

    private Subscriber subscriber;

    public Subscriber() {
    }

    protected Subscriber(Subscriber<?> subscriber) {
        this.subscriber = subscriber;
    }


    @Override
    public void onComplete() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void onNext(T t) {

    }
}
