package GaoQi;
/**
 * 对于反射，我对自己要求不是很高，知道有动态加载就好，到时候再学，心里先存个印象
 */

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
 写一个类ReflectUtil类, 类中写一个静态方法Object methodInvoker(String classMethod)
此方法为无参方法如：
	classMethod "java.lang.String.length()"
*/
public class ReflectUtil {

    public static Object methodInvoker(String classMethod) throws ClassNotFoundException,
            SecurityException,
            InstantiationException,
            IllegalAccessException,
            IllegalArgumentException,
            InvocationTargetException {
        // 获取最后一个"."出现的下标
        int lastDot = classMethod.lastIndexOf(".");
        // 获取子字符串从第0下标到最后一个"."出现的下标，这个字符串即为类的全限定名称
        String className = classMethod.substring(0, lastDot);
        // 获取子字符串，为方法的名称
        String methodName = classMethod.substring(lastDot + 1, classMethod.length() - 2);
        // 根据类名获取Class对象
        Class clazz = Class.forName(className);
        Method method = null;
        Class tmp = clazz;
        // 判断次方法是否存在
        while (tmp != null) {
            try {
                // 若存在，获取方法对象，以防是私有方法，使用getDeclaredMethod方法获取
                method = tmp.getDeclaredMethod(methodName);
                break;
            } catch (NoSuchMethodException e) {
                // 若不存在，在父类中获取此方法
                tmp = tmp.getSuperclass();
            }
        }
        Object object = clazz.newInstance();
        // 根据Class对象创建对象
        // 突破私有方法的禁锢性
        method.setAccessible(true);
        return method.invoke(object);
    }

    public static void main(String[] args) {
        try {
            Object object = methodInvoker("GaoQi.Homework9_5.test()");
            System.out.println(object);

            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
