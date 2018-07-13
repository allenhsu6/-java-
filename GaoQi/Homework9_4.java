package GaoQi;

import java.util.*;

public class Homework9_4 {
    public static void main(String[] args) {
        /**
         * 对于遍历容器类，foreach语句是最简便有效的方法
         */

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(1, "<沉默的大多数>", 45.5, "清华出版社"));
        Iterator<Book> iterator = bookList.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println(book);
        }

        Map<Integer, Book> bookMap = new HashMap<>();
        bookMap.put(1, new Book(1, "<沉默的大多数>", 45.5, "清华出版社"));
        bookMap.put(2, new Book(2, "<计算机导论>", 99.9, "北航出版社"));

        Set<Integer> key = bookMap.keySet();
        Iterator<Integer> iterator1 = key.iterator();
        while (iterator1.hasNext()) {
            Integer id = iterator1.next();
            Book book = bookMap.get(id);
            System.out.println(book);
        }
    }
}

class Book implements Comparable {
    int no;
    String name;
    double price;
    String press;

    public Book(int no, String name, double price, String press) {
        this.no = no;
        this.name = name;
        this.price = price;
        this.press = press;
    }

    @Override
    public String toString() {
        return "Book{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", press='" + press + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return no == book.no &&
                Double.compare(book.price, price) == 0 &&
                Objects.equals(name, book.name) &&
                Objects.equals(press, book.press);
    }

    @Override
    public int hashCode() {

        return Objects.hash(no, name, price, press);
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) return 0;
        if (!(o instanceof Book)) return -1;
        Book book = (Book) o;
        if (no == book.no) return 1;
        else return -1;
    }
}