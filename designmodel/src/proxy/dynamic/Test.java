package proxy.dynamic;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
//        File file = new File("./aa.class");
//        if (file.exists()) {
//            System.out.println("1111");
//            return;
//        }
//        System.out.println("222");

//        XMTV xmtv = new XMTV();
//        Proxy proxy = new Proxy(xmtv);
//        TV proxy1 = proxy.proxy();
//        proxy1.display();
//        byte[] proxyClassFile = ProxyGenerator.generateProxyClass(proxy.getClass().getName(), xmtv.getClass().getInterfaces());
//        FileOutputStream out = null;
//        try {
//            out = new FileOutputStream("./aa.class");
//            out.write(proxyClassFile);
//            out.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            out.close();
//        }
//        System.out.println(tableSizeFor(8));
//        int mRefreshRate = 16;
//        float frameDuration = 1000.0f / mRefreshRate;
//        float frameCount = TRANS_DURATION / frameDuration;
//        mFrameDeltaX = (int) Math.ceil(w / frameCount);
    }

    private static final int MAXIMUM_CAPACITY = 200;

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
