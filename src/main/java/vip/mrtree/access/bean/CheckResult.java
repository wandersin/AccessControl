package vip.mrtree.access.bean;

import lombok.Getter;

@Getter
public class CheckResult {
    private boolean flag;

    private CheckResult() {

    }

    public static CheckResult success() {
        CheckResult rst = new CheckResult();
        rst.flag = true;
        return rst;
    }

    public static CheckResult failed() {
        CheckResult rst = new CheckResult();
        rst.flag = false;
        return rst;
    }

    public static CheckResult result(boolean flag) {
        return flag ? success() : failed();
    }
}
