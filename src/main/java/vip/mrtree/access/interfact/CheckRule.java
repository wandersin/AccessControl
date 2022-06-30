package vip.mrtree.access.interfact;

import vip.mrtree.access.annotation.Rule;
import vip.mrtree.access.bean.CheckResult;

/**
 * 校验规则定义
 * <br>
 *
 * @author wangyunshu
 */
public interface CheckRule {

    /**
     * 校验是否满足条件
     * <br>
     * @author wangyunshu
     * @param obj 待校验的值
     * @param clazz 呆校验值的类型
     * @param rule 校验规则的字符串表达式
     * @return 校验结果
     */
    CheckResult check(Object obj, Class<?> clazz, String rule) throws Throwable;

    /**
     * 校验规则的名称
     * <br>
     * 通过名称匹配校验规则类
     * @author wangyunshu
     */
    default String name() {
        return this.getClass().getAnnotation(Rule.class).value();
    }
}
