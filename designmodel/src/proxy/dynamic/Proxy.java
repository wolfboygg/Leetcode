package proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Objects;

public class Proxy {

    private TV tv;

    public Proxy(TV tv) {
        Objects.requireNonNull(tv);
        this.tv = tv;
    }

    public TV proxy() {
        return (TV) java.lang.reflect.Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{TV.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("asdfadsfasdf1111");
                method.invoke(tv, args);
                System.out.println("asdfadsfasdf2222");
                return null;
            }
        });
    }
}
