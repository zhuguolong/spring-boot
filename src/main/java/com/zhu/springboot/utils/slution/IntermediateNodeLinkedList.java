package com.zhu.springboot.utils.slution;

import java.util.List;

/**
 * @author zhugu
 * @version 1.0
 * @Date 2019/4/22 15:06
 * @Description 如何访问链表中间节点
 *
 * 对于这个问题，我们首先能够想到的就是先遍历一遍整个的链表，然后计算出链表的长度，进而遍历第二遍找出中间位置的数据。这种方式非常简单。
 *
 * 若题目要求只能遍历一次链表，那又当如何解决问题？
 *
 * 可以采取建立两个指针，一个指针一次遍历两个节点，另一个节点一次遍历一个节点，当快指针遍历到空节点时，慢指针指向的位置为链表的中间位置，这种解决问题的方法称为快慢指针方法。
 */
public class IntermediateNodeLinkedList {
    /**
     * 快慢指针方法
     */
    public static Object fastSlowPointer(List<Object> originList) {
        if (originList.size() <= 0) {
            throw new IllegalArgumentException("list size illegal");
        }

        int fastPointer = 0;
        int slowPointer = 0;
        for (int i = 0, l = originList.size(); i < l; i++) {
            if (fastPointer == l || fastPointer == l - 1) {
                break;
            }
            fastPointer += 2;
            slowPointer++;
        }

        return originList.get(slowPointer - 1);
    }

//    public static void main(String[] args) {
//        List<Object> originList = new LinkedList<>();
//        originList.add("1");
//        originList.add("2");
//        originList.add("3");
//        originList.add("4");
//        originList.add("5");
//        originList.add("6");
//
//        Object obg = fastSlowPointer(originList);
//        System.out.println(obg);
//    }
}
