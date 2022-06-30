package vip.mrtree.access.rule;

import vip.mrtree.access.annotation.Rule;
import vip.mrtree.access.bean.CheckResult;
import vip.mrtree.access.interfact.CheckRule;

@Rule("max")
public class Max implements CheckRule {
    @Override
    public CheckResult check(Object obj, Class<?> clazz, String rule) throws Throwable {
        return null;
    }
}
