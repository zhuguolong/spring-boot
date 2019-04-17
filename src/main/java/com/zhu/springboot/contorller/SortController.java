package com.zhu.springboot.contorller;

import com.zhu.springboot.utils.ResultMap;
import com.zhu.springboot.utils.sort.Sort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SortController {

    @Qualifier("bubbleSort")
    private final Sort bubbleSort;

    @Qualifier("selectionSort")
    private final Sort selectionSort;

    @Qualifier("insertSort")
    private final Sort insertSort;

    public SortController(Sort bubbleSort,
                          Sort selectionSort,
                          Sort insertSort) {
        this.bubbleSort = bubbleSort;
        this.selectionSort = selectionSort;
        this.insertSort = insertSort;
    }

    @GetMapping(value = "/sort")
    public Object sort(String sortType, int[] sourceArr) {
        if ("selectionSort".equals(sortType)) {
            return ResultMap.ok(selectionSort.sort(sourceArr), "选择排序成功！");
        }
        if("bubbleSort".equals(sortType)) {
            return ResultMap.ok(bubbleSort.sort(sourceArr), "冒泡排序成功！");
        }
        if("insertSort".equals(sortType)) {
            return ResultMap.ok(insertSort.sort(sourceArr), "插入排序成功！");
        }
        return ResultMap.err("无该排序算法！");
    }
}
