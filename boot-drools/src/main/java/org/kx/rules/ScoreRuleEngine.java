package org.kx.rules;

/**
 * create by sunkx on 2018/1/10
 */
public interface ScoreRuleEngine {
    /**
     * 初始化规则引擎
     */
    public void initEngine();

    /**
     * 刷新规则引擎中的规则
     */
    public void refreshEnginRule();

    /**
     * 执行规则引擎
     */
    public void executeRuleEngine(final ScoreDomain score);

}
