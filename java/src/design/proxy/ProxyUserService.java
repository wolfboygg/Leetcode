package design.proxy;
public class ProxyUserService implements UserService{

    private UserService userService;

    public ProxyUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void select() {
        System.out.println("before");
        userService.select();
        System.out.println("after");
    }

    @Override
    public void insert() {
        System.out.println("before");
        userService.insert();
        System.out.println("after");
    }
}
