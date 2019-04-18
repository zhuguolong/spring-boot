package com.zhu.springboot.contorller;

import com.zhu.springboot.service.MathService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhugu
 * @version 1.0
 * @Date 2019/4/18 15:05
 */
@RestController
public class MathController {

    private final MathService mathService;

    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @GetMapping("/math/add")
    public Object add(double num1, double num2) {
        return mathService.add(num1, num2);
    }

    @GetMapping("/math/div")
    public Object div(int num1, int num2) {
        return mathService.div(num1, num2);
    }
}
