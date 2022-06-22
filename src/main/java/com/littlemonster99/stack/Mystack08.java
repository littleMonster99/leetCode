package com.littlemonster99.stack;

import java.util.Stack;

/**
 * <pre>
 * 任务：
 * 描述：如何仅用递归函数和栈操作逆序一个栈  p8
 * 【题目】
 *  一个栈一次压入1、2、3、4、5，那么从栈顶到栈底分别为5、4、3、2、1。将这个栈转置后，从栈顶到栈底为1、2、3、4、5，
 *  也就是实现栈中元素的逆序，但是只能用递归函数来实现，不能用其他数据结构
 * 作者：
 * 时间：
 * </pre>
 */

public class Mystack08 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        reverse(stack);
        System.out.println(stack);
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.empty()) {
            return;
        }
        //删除最后一个并获取
        int i = getAndRemoveLastElement(stack);
        //继续循环调用，只能放到插入之前。否则调用不能停止
        reverse(stack);
        stack.push(i);
    }

    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        //到栈底时，返回最后一个数 不用添加
        if (stack.empty()) {
            return result;
        } else {
            //如果不是最后一个元素继续递归
            int lastElement = getAndRemoveLastElement(stack);
            //除过最后一个元素原样插入
            stack.push(result);
            return lastElement;
        }
    }
}
