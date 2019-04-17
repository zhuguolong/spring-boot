package com.zhu.springboot.utils.sort;

import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author zhugu
 * @version 1.0
 * @Date 2019/4/17 14:16
 */
@Component
public class SelectionSort implements Sort {
    @Override
    public SortType getSortType() {
        return SortType.SELECTION;
    }

    /**
     * 选择排序：
     * 1、首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
     *
     * 2、再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     *
     * 3、重复第二步，直到所有元素均排序完毕。
     */
    @Override
    public int[] sorting(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        // 总共要经过 N-1 轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    // 记录目前能找到的最小值元素的下标
                    min = j;
                }
            }

            // 将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }

        return arr;
    }
}
