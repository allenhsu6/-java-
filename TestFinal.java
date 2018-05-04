public class TestFinal {
    public static void main(String[] args) {
        try {
            System.out.println(2/0);
        }catch (ArithmeticException e){
            System.out.println("测试爆出异常");
            e.printStackTrace();
        }
    }
}

