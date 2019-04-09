package com.zhu.springboot.contorller;

import com.zhu.springboot.utils.ResultMap;
import com.zhu.springboot.utils.sort.IArraySort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SortController {

    private final IArraySort iArraySort;

    public SortController(IArraySort iArraySort) {
        this.iArraySort = iArraySort;
    }

    @GetMapping(value = "/sort")
    public Object sort(String sortType, int[] sourceArr) {
        if ("selectionSort".equals(sortType)) {
            return ResultMap.ok(iArraySort.selectionSort(sourceArr), "选择排序成功！");
        }
        if("bubbleSort".equals(sortType)) {
            return ResultMap.ok(iArraySort.bubbleSort(sourceArr), "冒泡排序成功！");
        }
        if("insertSort".equals(sortType)) {
            return ResultMap.ok(iArraySort.InsertSort(sourceArr), "插入排序成功！");
        }
        return ResultMap.err("无该排序算法！");
    }
}
