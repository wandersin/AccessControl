package vip.mrtree.access.annotation.rule;

import vip.mrtree.access.annotation.Rule;

import java.lang.annotation.*;

@Rule("max")
@Documented
@Target({ElementType.FIELD, ElementType.PACKAGE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Max {
    String value();
}
