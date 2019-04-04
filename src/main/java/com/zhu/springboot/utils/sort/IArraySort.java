package com.zhu.springboot.utils.sort;

/**
 * 排序算法借口
 */
public interface IArraySort {
    public int[] bubbleSort(int[] sourceArray);

    public int[] selectionSort(int[] sourceArray);
}
