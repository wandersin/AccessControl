package vip.mrtree.access.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import vip.mrtree.access.annotation.Rule;
import vip.mrtree.access.interfact.CheckRule;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Component
public class CheckRuleCollection {
    @Resource
    private ApplicationContext applicationContext;

    private Map<String, CheckRule> collection;

    @PostConstruct
    public void init() {
        Map<String, Object> temp = applicationContext.getBeansWithAnnotation(Rule.class);
        collection = new HashMap<>(temp.size());
        temp.forEach((key, value) -> {
            if (value instanceof CheckRule) {
                collection.put(((CheckRule) value).name(), (CheckRule) value);
            }
        });
    }

    public CheckRule getRule(String ruleName) {
        return collection.get(ruleName);
    }
}
