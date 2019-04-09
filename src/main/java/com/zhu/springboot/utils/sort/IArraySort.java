package com.zhu.springboot.utils.sort;

/**
 * 排序算法借口
 */
public interface IArraySort {
    /**
     * 冒泡排序
     */
    int[] bubbleSort(int[] sourceArray);

    /**
     * 选择排序
     */
    int[] selectionSort(int[] sourceArray);

    /**
     * 插入排序
     */
    int[] InsertSort(int[] sourceArray);
}
