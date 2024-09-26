package design.single;
public class SingleByDoubleCheck {
    private static volatile SingleByDoubleCheck sInstance;

    private SingleByDoubleCheck() {}

    public static SingleByDoubleCheck getInstance() {
        if (sInstance == null) {
            synchronized (SingleByDoubleCheck.class) {
                if (sInstance == null) {
                    sInstance = new SingleByDoubleCheck();
                }
            }
        }
        return sInstance;
    }
    /**
     * 解释一下这里两个判断的最用
     * 第一个是为了再多线程的情况下如果判断在第二个线程来到时判断不为null直接返回
     * 第二个是当多线程通过第一层判断的时候，释放锁之后会不为null，第二个线程判断之后就不会在创建了
     * volatile关键字是否是必须的
     * 是不许的 volatile关键字的作用 保证内存的可见性 禁止指令重排序
     * 由于sIntance = new SingleByDoubleCheck()这个操作不是原子性的，分为三步
     * 1. 创建对象所需要的空间
     * 2.初始化对象
     * 3.sInstance指向对象的地址
     * 由于指令重排序，那么 2，3就有可能发生指令重排序。那么就会出现问题
     * 如果发生这个情况，假设第一层判断又正好有线程到来，那么就会判断不为空直接返回，但是此时对象并没有进行初始化
     * 就会出现问题。
     *
     */

}
