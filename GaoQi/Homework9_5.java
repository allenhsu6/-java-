package GaoQi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 实现list和map之间的数据转换 这些作业主要是让你熟悉这些容器的用法
 * 要练习，在自己亲手敲过一次之后，感觉是不一样的
 */
public class Homework9_5 {

    public static void main(String[] args) {
        Student stu1 = new Student(110, "小明", 98.0);
        Student stu2 = new Student(111, "大刚", 80.5);
        Student stu3 = new Student(112, "小白", 93.0);

        Map<Integer, Student> studentMap = new HashMap<>();
        studentMap.put(stu1.id, stu1);
        studentMap.put(stu2.id, stu2);
        studentMap.put(stu3.id, stu3);


        List<Student> studentList = new ArrayList<>();

        for (Student s : studentMap.values()
                ) {
            studentList.add(s);
        }
        System.out.println(studentList);
    }

    private void test() {
        System.out.println(new Student(33, "徐志", 100));
    }
}

class Student implements Comparable, Serializable {

    //private static final long serialVersionUID = 1L;
    int id;
    String name;
    double score;

    public Student(int id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Object o) {
        Student s = (Student) o;
        if (score > s.score) return 1;
        else if (score == s.score) return 0;
        else return -1;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}