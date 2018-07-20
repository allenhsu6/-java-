package GaoQi;

/**
 * 单例模式之静态内部类
 * 只维护一个对象
 */
public class Example18_1 {
    // 构造器要私有化
    private Example18_1() {
    }

    public static Example18_1 getInstance() {
        return SingleInstance.instance;
    }

    // 内部类的形式确保
    private static class SingleInstance {
        private static final Example18_1 instance = new Example18_1();
    }
}
