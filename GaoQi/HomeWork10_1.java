package GaoQi;

/**
 * 实现字符串和字节数组之间的相互转换。如将字符串“北京尚学堂bjsxt”转换为字节数组，并将字节数组再转换回字符串。
 */
public class HomeWork10_1 {
    public static void main(String[] args) {
        String str = "北京尚学堂bjsxt";
        byte[] bytes = str.getBytes();
        String str2 = new String(bytes, 0, bytes.length);
        System.out.println(str2);
    }
}

