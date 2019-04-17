package com.zhu.springboot.utils.sort;

import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @author zhugu
 * @version 1.0
 * @Date 2019/4/17 14:15
 */
@Service("bubbleSort")
public class BubbleSort implements Sort {
    /**
     * 冒泡排序：
     * 1、比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     *
     * 2、对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
     *
     * 3、针对所有的元素重复以上的步骤，除了最后一个。
     *
     * 4、持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     */
    @Override
    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }
}
