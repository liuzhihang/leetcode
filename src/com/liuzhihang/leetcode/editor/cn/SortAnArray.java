//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// -50000 <= nums[i] <= 50000 
// 
// 👍 217 👎 0


package com.liuzhihang.leetcode.editor.cn;

import java.util.Arrays;

public class SortAnArray {
    public static void main(String[] args) {

        Solution solution = new SortAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] nums) {

            // return bubbleSort(nums);

            // quickSort(nums, 0, nums.length - 1);

            // insertSort(nums);
            // selectSort(nums);

            // return nums;

            return mergeSort(nums);

        }

        /**
         * 归并排序:
         * 一直分解成小的组合 进行两两合并
         *
         * @param nums
         */
        public int[] mergeSort(int[] nums) {
            if (nums.length <= 1) {
                return nums;
            }

            int mid = nums.length >> 1;

            int[] left = Arrays.copyOfRange(nums, 0, mid);
            int[] right = Arrays.copyOfRange(nums, mid, nums.length);

            return mergeArray(mergeSort(left), mergeSort(right));

        }

        public int[] mergeArray(int[] left, int[] right) {

            int[] result = new int[left.length + right.length];

            int resultPoint = 0;

            int leftPoint = 0;
            int rightPoint = 0;

            while (leftPoint < left.length && rightPoint < right.length) {

                if (left[leftPoint] <= right[rightPoint]) {
                    // i++ 返回之前的值
                    result[resultPoint++] = left[leftPoint++];
                } else {
                    result[resultPoint++] = right[rightPoint++];
                }
            }
            // 判断是否还有剩余

            if (leftPoint < left.length) {
                System.arraycopy(left, leftPoint, result, resultPoint, left.length - leftPoint);
            }

            if (rightPoint < right.length) {
                System.arraycopy(right, rightPoint, result, resultPoint, right.length - rightPoint);

            }
            return result;

        }

        /**
         * 选择排序:
         * <p>
         * 每次选未排序的列表中选出最小的, 和未排序列表第一个做交换
         *
         * @param nums
         */
        public void selectSort(int[] nums) {
            if (nums.length <= 1) {
                return;
            }

            for (int i = 0; i < nums.length - 1; i++) {
                int minNumIndex = i;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[minNumIndex] > nums[j]) {
                        minNumIndex = j;
                    }
                }
                if (minNumIndex != i) {
                    swap(nums, minNumIndex, i);
                }
            }


        }


        /**
         * 直接插入排序
         * <p>
         * 1. 默认第一个元素已经排序
         * 2. 取出下一个元素，在已经排序的元素序列中从后向前扫描
         * 3. 如果该元素（已排序）大于新元素，将该元素移到下一位置
         * 4. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
         * 5. 将新元素插入到该位置后
         *
         * @param nums
         */
        public void insertSort(int[] nums) {

            if (nums.length <= 1) {
                return;
            }

            for (int i = 1; i < nums.length; i++) {

                int currIndex = i - 1;
                int temp = nums[i];

                while (currIndex >= 0 && nums[currIndex] > temp) {
                    nums[currIndex + 1] = nums[currIndex];
                    currIndex--;
                }
                nums[currIndex + 1] = temp;

            }

        }


        /**
         * 快排 双指针法
         *
         * @param nums
         * @param l
         * @param f
         */
        public void quickSort(int[] nums, int l, int f) {

            if (l >= f) {
                return;
            }
            int i = l;
            int j = f;
            int base = nums[l];

            while (i < j) {

                while (base <= nums[j] && i < j) {
                    j--;
                }
                while (base >= nums[i] && i < j) {
                    i++;
                }

                if (i < j) {
                    swap(nums, i, j);
                }
            }
            swap(nums, l, i);

            quickSort(nums, l, i - 1);
            quickSort(nums, i + 1, f);

        }


        /**
         * 冒泡排序
         *
         * @param nums
         */
        public int[] bubbleSort(int[] nums) {

            if (nums.length <= 1) {
                return nums;
            }
            // 外层循环
            for (int i = 0; i < nums.length - 1; i++) {

                // 内层循环, 每次比较挨着的两个
                for (int j = 0; j < nums.length - 1 - i; j++) {

                    if (nums[j] > nums[j + 1]) {
                        swap(nums, j, j + 1);
                    }

                }

            }

            return nums;
        }

        /**
         * 交换 j 和 j
         *
         * @param nums
         * @param i
         * @param j
         */
        public void swap(int[] nums, int i, int j) {

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
