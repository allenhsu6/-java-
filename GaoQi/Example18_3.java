package GaoQi;

/**
 * 单例模式之懒汉模式
 */

public class Example18_3 {
    private static Example18_3 instance;

    private Example18_3() {
    }

    // 必须加上synchronized，解决并发可能创建多个对象的问题
    public static synchronized Example18_3 getInstance() {
        if (instance == null) instance = new Example18_3();
        return instance;
    }
}
