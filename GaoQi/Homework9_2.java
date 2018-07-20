package GaoQi;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 使用HashSet和TreeSet存储多个商品信息，遍历并输出；其中商品属性：编号，名称，单价，出版社；
 * 要求向其中添加多个相同的商品，验证集合中元素的唯一性。
 * 提示：向HashSet中添加自定义类的对象信息，需要重写hashCode和equals( )
 * 向TreeSet中添加自定义类的对象信息，需要实现Comparable接口，指定比较规则
 */
public class Homework9_2 {
    public static void main(String[] args) {
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book(1, "<沉默的大多数>", 45.5, "清华出版社"));
        bookSet.add(new Book(1, "<沉默的大多数>", 45.5, "清华出版社"));
        bookSet.add(new Book(1, "<沉默的大多数>", 45.5, "清华出版社"));
        bookSet.add(new Book(1, "<沉默的大多数>", 45.5, "清华出版社"));

        for (Book book : bookSet
                ) {
            System.out.println(book);
        }

/**
 * 保证treeSet的正确性，需要实现comparable接口，
 */
        Set<Book> bookSet1 = new TreeSet<>();
        bookSet1.add(new Book(1, "<沉默的大多数>", 45.5, "清华出版社"));
        bookSet1.add(new Book(1, "<沉默的大多数>", 45.5, "清华出版社"));
        bookSet1.add(new Book(1, "<沉默的大多数>", 45.5, "清华出版社"));
        bookSet1.add(new Book(1, "<沉默的大多数>", 45.5, "清华出版社"));
        for (Book book : bookSet
                ) {
            System.out.println(book);
        }
    }
}

