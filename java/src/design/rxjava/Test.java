package design.rxjava;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {


        class Person {}
        class Boy extends Person {}

//        List<? extends Person> list = new ArrayList<Object>();
//        list.add(new Boy());
//        Object object = list.get(0);

        List<? super Person> list2 = new ArrayList<Object>();
        list2.add(new Boy());
        list2.add(new Person());
        Object object1 = list2.get(0);


        Observable.create(new Onsubscribe<Integer>() {
            @Override
            public void call(Subscribe<Integer> subscribe) {
                subscribe.onNext(4);
            }
        })
                .map(integer -> integer + "hahah")
                .map(String -> Integer.valueOf(9))
                .subscribe(new Subscribe<Integer>() {
                    @Override
                    public void onNext(Integer o) {
                        System.out.println("value:" + o);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
