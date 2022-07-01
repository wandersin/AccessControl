package vip.mrtree.access.rule;

import vip.mrtree.access.annotation.Rule;
import vip.mrtree.access.bean.CheckResult;
import vip.mrtree.access.interfact.CheckRule;

/**
 * 非null校验
 * <br>
 * 可用于所有对象
 * 不可用于基本数据类型
 * @author wangyunshu
 */
@Rule("NotNull")
public class NotNull implements CheckRule {
    @Override
    public CheckResult check(Object obj, Class<?> clazz, String rule) {
        return CheckResult.result(obj != null);
    }
}
