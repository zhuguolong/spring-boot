package com.zhu.springboot.service.impl;

import com.zhu.springboot.service.MathService;
import org.springframework.stereotype.Service;

/**
 * @author zhugu
 * @version 1.0
 * @Date 2019/4/18 15:06
 */
@Service("mathService")
public class MathServiceImpl implements MathService {
    @Override
    public double add(double num1, double num2) {
        return num1 + num2;
    }

    @Override
    public double div(int num1, int num2) {
        return num1 / num2;
    }
}
