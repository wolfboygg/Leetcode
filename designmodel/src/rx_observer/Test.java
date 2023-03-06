package rx_observer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
    public static void main(String[] args) {
//        Observable.create(new Observable.OnSubscriber() {
//            @Override
//            public void call(Subscriber subscriber) {
//                subscriber.onNext(555);
//            }
//        }).map(value -> value + "222").subscribe(new Subscriber<String>() {
//            @Override
//            public void onNext(String integer) {
//                super.onNext(integer);
//                System.out.println("hahahah:" + integer);
//            }
//        });

        HashMap<Person, String> map = new HashMap<>();
        for (int i = 0; i < 70; i++) {
            map.put(new Person(), "bbb" + i);
        }
        map.put(new Teacher(), "bbb");
        map.put(new Teacher(), "ccc");
        map.put(new Teacher(), "ddd");
        map.put(new Teacher(), "eee");
        map.put(new Teacher(), "ffff");
        map.put(new Teacher(), "ggg");
        map.put(new Teacher(), "hhh");
        map.put(new Teacher(), "jjj");
        map.put(new Teacher(), "kkk");

        Hashtable<Person, String> table = new Hashtable<>();
        Map<Person, String> syncMap = new ConcurrentHashMap<>();

//        Collections.synchronizedMap()

    }

    public static class Person {

    }

    public  static class Teacher extends Person {
        @Override
        public int hashCode() {
            return 1;
        }
    }

}
