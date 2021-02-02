package com.liuzhihang.leetcode.editor.cn.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuzhihang
 * @date 2021/1/7 16:04
 */
public class MaxPositiveNumberList {


    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(-2, 1, 2, 3, 4, -1, 2, 3, 4, 5);


        List<Integer> longs = maxPositiveNumberList(list);
        System.out.println("longs = " + longs);


    }


    public static List<Integer> maxPositiveNumberList(List<Integer> positiveNumber) {


        int prevStartIndex = 0;
        int prevLength = 1;


        int currStartIndex = -1;
        int currLength = 0;


        for (int i = 0; i < positiveNumber.size(); i++) {

            if (positiveNumber.get(i) > 0) {
                currLength++;
                if (currStartIndex == -1) {
                    currStartIndex = i;
                }
            } else {
                if (prevLength < currLength) {
                    prevStartIndex = currStartIndex;
                    prevLength = currLength;
                }

                currStartIndex = -1;
                currLength = 0;
            }

        }

        if (prevLength < currLength) {
            prevStartIndex = currStartIndex;
            prevLength = currLength;
        }

        return positiveNumber.subList(prevStartIndex, prevStartIndex + prevLength);
    }


}
