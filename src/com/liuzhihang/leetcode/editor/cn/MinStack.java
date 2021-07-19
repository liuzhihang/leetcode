//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计 
// 👍 959 👎 0


package com.liuzhihang.leetcode.editor.cn;

import java.util.LinkedList;

// public class MinStack {

// public static void main(String[] args) {


// }

//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {

    private LinkedList<Integer> stack = new LinkedList<>();
    private LinkedList<Integer> sortList = new LinkedList<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int val) {
        stack.addFirst(val);

        if (sortList.isEmpty()) {
            sortList.addFirst(val);
        } else {

            int tempIndex = 0;

            for (Integer indexVal : sortList) {
                if (indexVal > val) {
                    break;
                }
                tempIndex++;
            }

            sortList.add(tempIndex, val);

        }


    }

    public void pop() {
        Integer pop = stack.pop();

        int tempIndex = 0;
        for (Integer indexVal : sortList) {
            if (indexVal.equals(pop)) {
                break;
            }
            tempIndex++;
        }
        sortList.remove(tempIndex);
    }

    public int top() {
        return stack.getFirst();
    }

    public int getMin() {

        return sortList.getFirst();
    }
}


//leetcode submit region end(Prohibit modification and deletion)


// }
