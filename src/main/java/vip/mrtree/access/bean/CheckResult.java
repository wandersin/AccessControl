package vip.mrtree.access.bean;

import lombok.Getter;

public class CheckResult {
    @Getter
    private final boolean result;

    public CheckResult(boolean result) {
        this.result = result;
    }
}
