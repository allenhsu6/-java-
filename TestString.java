public class TestString {
    public static void main(String[] args) {
        Integer i = new Integer("1234");
        Double d = new Double("12.345");
        int j = i.intValue() + d.intValue();
        float f = i.floatValue() + d.floatValue();
        System.out.println(j + f);
        double pi = Double.parseDouble("3.1415");
        double r = Double.valueOf("2.44");
        System.out.println(pi*r*r);
        try{
            int k = Integer.parseInt("1.25");
        }catch (NumberFormatException e){
            System.out.println(e.fillInStackTrace());
        }
        System.out.println(Integer.toBinaryString(123));//转换为2进制
        System.out.println(Integer.toHexString(123)+"H");//16进制
        System.out.println(Integer.toOctalString(123)+"O");//8进制
    }
}
