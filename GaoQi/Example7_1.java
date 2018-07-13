package GaoQi;
/**
 * 使用util中的arrays集合类中的方法
 */

import java.util.Arrays;

public class Example7_1 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3456, 32, 76, 24, 87, 23, 456, 764, 5, 7, 5463};
        System.out.println(Arrays.toString(a)); //使用toString
        Arrays.sort(a); // 使用sort
        System.out.println(Arrays.toString(a));
        Person[] people = {new Person("xuzhi", 24), new Person("miya", 18)};
        System.out.println(Arrays.toString(people)); //使用toString
        Arrays.sort(people); // 使用sort
        System.out.println(Arrays.toString(people));
    }
}

class Person implements Comparable {

    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    // 自定义comparable 实现按年龄排序
    @Override
    public int compareTo(Object o) {
        Person person = (Person) o;
        if (this.age < person.age) return -1;
        else if (this.age > person.age) return 1;
        else return 0;
    }
}