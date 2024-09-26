package proxy.staticpro;

public class JXS implements Shop {

    private Shop proxy;

    public JXS(Shop proxy) {
        this.proxy = proxy;
    }

    @Override
    public void buy() {
        System.out.println("经销商处理");
        proxy.buy();
    }
}
