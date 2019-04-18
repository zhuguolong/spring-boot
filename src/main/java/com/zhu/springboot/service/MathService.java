package com.zhu.springboot.service;

/**
 * @author zhugu
 * @version 1.0
 * @Date 2019/4/18 15:06
 */
public interface MathService {
    /**
     * 加法
     * @param num1 被加数
     * @param num2 加数
     * @return 结果
     */
    double add(double num1, double num2);

    /**
     * 除法
     * @param num1 被除数
     * @param num2 除数
     * @return 商
     */
    double div(int num1, int num2);
}
