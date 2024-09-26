package design.proxy;
public class UserServiceImpl implements UserService {
    @Override
    public void select() {
        System.out.println("用户选择");
    }

    @Override
    public void insert() {
        System.out.println("用户插入");
    }
}
