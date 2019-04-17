package com.zhu.springboot.utils.sort;

import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @author zhugu
 * @version 1.0
 * @Date 2019/4/17 14:17
 */
@Service("insertSort")
public class InsertSort implements Sort {
    /**
     * 插入排序
     * 1、将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
     *
     * 2、从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。（如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
     */
    @Override
    public int[] sort(int[] sourceArray) {
        // 7, 2, 4, 6, 3, 9, 1
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        printArr(arr);

        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < arr.length; i++) {
            // 记录要插入的数据
            int temp = arr[i], j = i;
            // 从已经排序的序列最右边的开始比较，找到比其小的数
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            // 存在比其小的数，插入
            if (j != i) {
                arr[j] = temp;
            }

            printArr(arr);
        }

        return arr;
    }

    private void printArr(int[] arr) {
        for (int x = 0; x < arr.length; x++) {
            if (x != arr.length - 1) {
                System.out.print(arr[x] + ", ");
            } else {
                System.out.println(arr[x]);
            }
        }
    }
}
