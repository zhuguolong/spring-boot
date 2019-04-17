package com.zhu.springboot.contorller;

import com.zhu.springboot.utils.sort.SortFactory;
import com.zhu.springboot.utils.sort.SortType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SortController {

    private final SortFactory sortFactory;

    public SortController(SortFactory sortFactory) {
        this.sortFactory = sortFactory;
    }

    @PostMapping(value = "factory/sort")
    public Object sortFactory(SortType sortType, int[] sourceArr) {
        return sortFactory.sorting(sortType, sourceArr);
    }
}
