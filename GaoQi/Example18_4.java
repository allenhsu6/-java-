package GaoQi;

/**
 * 单例模式之枚举模式
 * 枚举天然防止反射和序列化漏洞
 * 总结： 需要延时加载：建议内部类模式； 不需要建议枚举类
 */
public enum Example18_4 {
    // 这个枚举元素本身就是单例对象
    Instance;

    // 调用代码
    public static void main(String[] args) {
        Example18_4 instance1 = Example18_4.Instance;
        Example18_4 instance2 = Example18_4.Instance;
        System.out.println(instance1 == instance2);
    }

    // 添加自己想要的操作
    public void operation() {

    }
}
