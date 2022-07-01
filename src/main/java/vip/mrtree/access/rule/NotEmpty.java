package vip.mrtree.access.rule;

import vip.mrtree.access.annotation.Rule;
import vip.mrtree.access.bean.CheckResult;
import vip.mrtree.access.interfact.CheckRule;
import vip.mrtree.utils.CollectionUtils;
import vip.mrtree.utils.MapUtils;
import vip.mrtree.utils.StringUtils;

import java.util.Collection;
import java.util.Map;

/**
 * 非空校验
 * <br>
 *
 * @author wangyunshu
 */
@Rule("NotEmpty")
public class NotEmpty implements CheckRule {
    @Override
    public CheckResult check(Object obj, Class<?> clazz, String rule) {
        if (obj == null) {
            return CheckResult.failed();
        }
        if (obj instanceof Map) {
            return CheckResult.result(MapUtils.isNotEmpty((Map<?, ?>) obj));
        }
        if (obj instanceof Collection) {
            return CheckResult.result(CollectionUtils.isNotEmpty((Collection<?>) obj));
        }
        if (obj instanceof CharSequence) {
            return CheckResult.result(StringUtils.isNotEmpty((CharSequence) obj));
        }
        return CheckResult.success();
    }
}
