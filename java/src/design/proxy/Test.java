package design.proxy;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args){
        UserServiceImpl userService = new UserServiceImpl();
//        ProxyUserService proxyUserService = new ProxyUserService(userService);
//        proxyUserService.select();
//        proxyUserService.insert();

        // 动态代理
        UserService proxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), new Class[]{UserService.class}, new MyProxyHandler(userService));
        proxy.select();
    }
}
