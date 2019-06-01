package com.zhu.springboot.contorller;

import com.zhu.springboot.entity.BaseUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class NotNullController {
    private final Logger log = LoggerFactory.getLogger(NotNullController.class);

    @GetMapping(value = "/info")
    public Object addBaseUser(@Valid BaseUser baseUser) {
        return baseUser;
    }
}
