package com.zhu.springboot.utils.sort;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service("sort")
public class Sort implements IArraySort {
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
    public int[] bubbleSort(int[] sourceArray) {
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

    /**
     * 选择排序：
     * 1、首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
     *
     * 2、再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     *
     * 3、重复第二步，直到所有元素均排序完毕。
     */
    @Override
    public int[] selectionSort(int[] sourceArray) {
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

    /**
     * 插入排序
     * 1、将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
     *
     * 2、从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。（如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
     */
    @Override
    public int[] InsertSort(int[] sourceArray) {
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
