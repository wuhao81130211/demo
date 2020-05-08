package com.example.demo.designPatterns.strategy.impl;

import com.example.demo.designPatterns.strategy.Strategy;

/**
 * @author: wuHao
 * @Date: 2020/5/7 15:55
 * @Description:
 */
public class OperationSubtractImpl implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
       return num1 - num2;
    }
}
