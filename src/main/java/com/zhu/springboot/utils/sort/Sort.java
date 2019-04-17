package com.zhu.springboot.utils.sort;

/**
 * @author zhugu
 * @version 1.0
 * @Date 2019/4/17 14:15
 * @Description 排序
 */
public interface Sort {
    /**
     * 排序类型
     * @return SortType
     */
    SortType getSortType();

    /**
     * 排序方法
     * @param sourceArray 无序数组
     * @return 有序数组
     */
    int[] sorting(int[] sourceArray);
}
