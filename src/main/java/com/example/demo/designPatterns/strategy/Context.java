package com.example.demo.designPatterns.strategy;

/**
 * @author: wuHao
 * @Date: 2020/5/7 15:57
 * @Description:
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}
