package com.example.demo.designPatterns.strategy;

import com.example.demo.designPatterns.strategy.impl.OperationAddImpl;
import com.example.demo.designPatterns.strategy.impl.OperationMultiplyImpl;
import com.example.demo.designPatterns.strategy.impl.OperationSubtractImpl;

/**
 * @author: wuHao
 * @Date: 2020/5/7 15:58
 * @Description:
 */
public class StrategyPatternDemo {

    public static void main(String[] args) {
        Context context = new Context(new OperationAddImpl());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationSubtractImpl());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationMultiplyImpl());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }
}
