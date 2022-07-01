package vip.mrtree.access.annotation.rule;

import vip.mrtree.access.annotation.Rule;

import java.lang.annotation.*;

@Rule("NotEmpty")
@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotEmpty {

}
