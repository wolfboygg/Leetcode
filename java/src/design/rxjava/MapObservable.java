package design.rxjava;

public class MapObservable<T, R> extends Onsubscribe<R> {

    Function1<T, R> func;
    Onsubscribe<T> onsubscribe;

    public MapObservable(Function1<T, R> func, Onsubscribe<T> onsubscribe) {
        this.func = func;
        this.onsubscribe = onsubscribe;
    }

    @Override
    public void call(Subscribe<R> subscribe) {
        onsubscribe.call(new MapObserver<T, R>(subscribe, func));
    }

    public class MapObserver<T, R> extends Subscribe<T> {
        private Subscribe<R> subscribe;
        Function1<T, R> mapper;

        public MapObserver(Subscribe<R> subscribe, Function1<T, R> mapper) {
            this.subscribe = subscribe;
            this.mapper = mapper;
        }


        @Override
        public void onNext(T t) {
            R result = mapper.call(t);
            subscribe.onNext(result);
        }

        @Override
        public void onComplete() {

        }
    }
}
