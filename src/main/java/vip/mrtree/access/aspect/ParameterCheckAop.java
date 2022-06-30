package vip.mrtree.access.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import vip.mrtree.access.annotation.ParameterCheck;
import vip.mrtree.access.annotation.Rule;
import vip.mrtree.access.bean.CheckResult;
import vip.mrtree.access.bean.CheckRuleCollection;
import vip.mrtree.access.interfact.CheckRule;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

@Aspect
@Component
public class ParameterCheckAop {
    @Resource
    private CheckRuleCollection collection;

    @Around("@annotation(parameterCheck)")
    public Object check(ProceedingJoinPoint point, ParameterCheck parameterCheck) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Method method = point.getTarget().getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
        Parameter[] parameters = method.getParameters();
        Object[] args = point.getArgs();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        for (int i = 0; i < parameterAnnotations.length; i++) {
            Annotation[] parameterAnnotation = parameterAnnotations[i];
            for (Annotation annotation : parameterAnnotation) {
                Rule temp = annotation.annotationType().getAnnotation(Rule.class);
                if (temp != null) {
                    // 是自己定义的注解
                    CheckRule rule = collection.getRule(temp.value());
                    String str = null;
                    try {
                        Field field = annotation.annotationType().getField("value");
                        str = (String) field.get(annotation);
                    } catch (NoSuchFieldException e) {
                        // 不需要额外的表达式
                    }
                    CheckResult check = rule.check(args[i], parameters[i].getType(), str);
                    if (!check.isResult()) {
                        // 校验未通过
                        throw new RuntimeException("框架校验未通过");
                    }
                }
            }
        }
        return point.proceed();
    }
}
