package com.littlemonster99.stack;

import java.util.Stack;

/**
 * <pre>
 * 任务：用一个栈实现另一个栈的排序 p13
 * 【题目】
 *      一个栈中元素的类型为整形，现在想讲该栈从顶到底按从大到小的顺序排序，只许申请一个栈。
 * 除此之外，可以申请新的变量，但不能申请额外的数据结构。如何完成排序?
 * 作者：
 * 时间：
 * </pre>
 */

public class Mystack13 {

    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> helpStack = new Stack<Integer>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!helpStack.isEmpty() && cur < helpStack.peek()) {
                //如果当前栈顶元素小于辅助栈顶元素，将辅助栈里的预算依次压回栈中
                stack.push(helpStack.pop());
            }
            //将这个元素压入栈中
            helpStack.push(cur);
        }
        while (!helpStack.isEmpty()) {
            stack.push(helpStack.pop());
        }
    }


}
