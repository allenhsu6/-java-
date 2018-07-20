package GaoQi;

/**
 * 模板方法模式
 */
abstract class BankTemplateMethod {
    public void takeNumber() {
        System.out.println("排队取号");
    }

    abstract void transaction();

    public void evaluate() {
        System.out.println("反馈评分");
    }

    public void process() {
        takeNumber();
        transaction();
        evaluate();
    }
}

/**
 * 抽象类中有一个抽象方法
 */

public class Template {
    public static void main(String[] args) {
        // 第一种使用方法:匿名内部类
        BankTemplateMethod b = new class FinancialManagement extends BankTemplateMethod {

            @Override
            void transaction() {
                System.out.println("老子🈶五个亿，要理财");
            }
        }
        // 第二种方法，使用内部类
        BankTemplateMethod() {
            @Override
            void transaction () {
                System.out.println("我是来存钱的");
            }
        }
        b.process();
        System.out.println("--------");
        new FinancialManagement().process();
    }
}


