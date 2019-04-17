package com.zhu.springboot.utils.sort;

/**
 * @author zhugu
 * @version 1.0
 * @Date 2019/4/17 14:15
 */
public interface Sort {
    SortType getSortType();
    int[] sorting(int[] sourceArray);
}
