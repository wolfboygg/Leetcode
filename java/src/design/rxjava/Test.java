package design.rxjava;
public class Test {
    public static void main(String[] args){
      Observable.create(new Onsubscribe<Integer>() {
          @Override
          public void call(Subscribe<Integer> subscribe) {
              subscribe.onNext(4);
          }
      }).subscribe(new Subscribe<Integer>() {
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
