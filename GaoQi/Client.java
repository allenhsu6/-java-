package GaoQi;

/**
 * 责任链模式
 */

public class Client {
    public static void main(String[] args) {
        Leader a = new Director("小红");
        Leader b = new Manager("小慈");
        Leader c = new GeneralManager("志哥");

        LeaveRequest request = new LeaveRequest("小雨", 30, "老婆生孩子");

        a.nextLeader = b;
        b.nextLeader = c;
        System.out.println("提出请假：" + request);
        System.out.println("#########开始审批########");

        a.handleResquest(request);

    }
}

abstract class Leader {
    // protected修饰符确保子类可以访问
    protected String name;
    protected Leader nextLeader;

    public Leader(String name) {
        this.name = name;
    }

    // 设置下个领导
    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }

    // 抽象类的方法不能有方法体
    public abstract void handleResquest(LeaveRequest request);
}

class Director extends Leader {

    public Director(String name) {
        super(name);
    }

    @Override
    public void handleResquest(LeaveRequest request) {
        if (request.getLeaveDays() > 3) {
            System.out.println("主任：天数超过权限，请经理审批");
            this.nextLeader.handleResquest(request);
        } else {
            System.out.println("主任：" + this.name + " 审批通过");
        }
    }
}

class Manager extends Leader {

    public Manager(String name) {
        super(name);
    }

    @Override
    public void handleResquest(LeaveRequest request) {
        if (request.getLeaveDays() > 10) {
            System.out.println("经理：天数超过权限，请经理审批");
            this.nextLeader.handleResquest(request);
        } else {
            System.out.println("经理：" + this.name + " 审批通过");
        }
    }
}

class GeneralManager extends Leader {

    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void handleResquest(LeaveRequest request) {
        if (request.getLeaveDays() > 15) {
            System.out.println("总经理：" + request.getEmpName() + "同志，不想干了吗，请" + request.getLeaveDays() + "天假");
        } else {
            System.out.println(request.getReason() + "\n" + "主任：" + this.name + " 审批通过");
        }
    }
}


/**
 * 责任链模——LeaveRequest
 */
class LeaveRequest {
    private String empName;
    private int leaveDays;
    private String reason;

    public LeaveRequest(String empName, int leaveDays, String reason) {
        this.empName = empName;
        this.leaveDays = leaveDays;
        this.reason = reason;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(int leaveDays) {
        this.leaveDays = leaveDays;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "LeaveRequest{" +
                "empName='" + empName + '\'' +
                ", leaveDays=" + leaveDays +
                ", reason='" + reason + '\'' +
                '}';
    }
}
