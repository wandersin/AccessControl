package vip.mrtree.access.rule;

import vip.mrtree.access.annotation.Rule;
import vip.mrtree.access.bean.CheckResult;
import vip.mrtree.access.interfact.CheckRule;
import vip.mrtree.utils.NumberUtils;

@Rule("MinNum")
public class MinNum implements CheckRule {
    @Override
    public CheckResult check(Object obj, Class<?> clazz, String rule) {
        if (NumberUtils.isNotNumber(obj) || NumberUtils.isNotNumber(rule)) {
            return CheckResult.failed();
        }
        double num = Double.parseDouble(obj.toString());
        double max = Double.parseDouble(rule);
        return CheckResult.result(num >= max);
    }
}
