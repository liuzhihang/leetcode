package com.liuzhihang.leetcode.editor.cn.other;

import java.util.Arrays;

/**
 * @author liuzhihang
 * @date 2020/4/15 18:57
 */
public class MainTest {


    public static void main(String[] args) {


        int[] arrA = {1, 2, 3, 5, 8, 9};
        int[] arrB = {2, 3, 4, 7, 8, 10, 12};

        int[] merge = merge(arrA, arrB);

        System.out.println(Arrays.toString(merge));

    }

    public static int[] merge(int[] arrA, int[] arrB) {

        int aLength = arrA.length;
        int bLength = arrB.length;

        int[] merge = new int[aLength + bLength];
        int aIndex = 0;
        int bIndex = 0;
        int mergeIndex = 0;

        while (aIndex < aLength && bIndex < bLength) {
            if (arrA[aIndex] < arrB[bIndex]) {
                merge[mergeIndex++] = arrA[aIndex++];
            } else {
                merge[mergeIndex++] = arrB[bIndex++];
            }
        }

        // if (aIndex < aLength) {
        //
        //     do {
        //         merge[mergeIndex++] = arrA[aIndex++];
        //     } while (aIndex < aLength);
        //
        // }
        // if (bIndex < bLength) {
        //     do {
        //         merge[mergeIndex++] = arrB[bIndex++];
        //     } while (bIndex < bLength);
        //
        // }

        for (int i = aIndex; i < aLength; i++) {
            merge[mergeIndex++] = arrA[i];
        }
        for (int i = bIndex; i < bLength; i++) {
            merge[mergeIndex++] = arrB[i];
        }

        return merge;

    }


}
