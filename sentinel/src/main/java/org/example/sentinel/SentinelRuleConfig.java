package org.example.sentinel;

import com.alibaba.csp.sentinel.slots.block.authority.AuthorityRule;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SentinelRuleConfig {

    public void initFlowRules() {
        // 创建流量规则

        List<FlowRule> flowRules = new ArrayList<>();

        // 创建 QPS 限流规则
        FlowRule flowRule = new FlowRule();
        flowRule.setResource("testResource");  // 资源名称，后续限流规则会基于该资源进行
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);  // 设置限流类型为 QPS
        flowRule.setCount(5);  // 设置每秒最大请求数为 5

        flowRules.add(flowRule);
        // 加载规则
        FlowRuleManager.loadRules(flowRules);
        // 创建权限规则
        AuthorityRule rule = new AuthorityRule();
        rule.setResource("testResource");
//        rule.setStrategy();  // 设置授权策略
        rule.setLimitApp("/test");  // 设置可以访问该资源的应用

        // 添加到规则库
        List<AuthorityRule> rules = new ArrayList<>();
        rules.add(rule);
        AuthorityRuleManager.loadRules(rules);  // 加载权限规则

    }
}