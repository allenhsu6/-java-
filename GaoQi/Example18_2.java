package GaoQi;

/**
 * 单例模式之饿汉模式
 */
public class Example18_2 {
    // 类初始化后立即创建static对象
    private static Example18_2 instance = new Example18_2();

    // 构造器要私有化
    private Example18_2() {
    }

    // 方法不同步，效率高
    public static Example18_2 getInstance() {
        return instance;
    }
}
