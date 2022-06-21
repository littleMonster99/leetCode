package com.littlemonster99.stack;

import java.util.Stack;

/**
 * <pre>
 * 任务：
 * 描述：设计一个有getMin功能的栈  p1
 * 【题目】
 *  实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 * 【要求】
 *      1.pop、push、getMin操作的时间复杂度为O（1）
 *      2.设计的栈类型可以使用现成的栈结构
 * 作者：
 * 时间：
 * </pre>
 */

public class Mystack01 {
    //正常的栈
    private Stack<Integer> nowStack;
    //记录最小的栈
    private Stack<Integer> minStack;

    Mystack01() {
        nowStack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    private void push(int newNum) {
        if (this.minStack.isEmpty()) {
            this.minStack.push(newNum);
        } else if (newNum <= getMin()) {
            this.minStack.push(newNum);
        }
        this.nowStack.push(newNum);
    }

    private int pop() {
        if (this.nowStack.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        Integer pop = this.nowStack.pop();
        if (pop == getMin()) {
            this.minStack.pop();
        }
        return pop;
    }

    private int getMin() {
        if (this.minStack.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        return this.minStack.peek();
    }

}

class Mystack02 {
    //正常的栈
    private Stack<Integer> nowStack;
    //记录最小的栈
    private Stack<Integer> minStack;

    Mystack02() {
        nowStack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    private void push(int newNum) {
        if (this.minStack.isEmpty()) {
            this.minStack.push(newNum);
        } else if (newNum <= getMin()) {
            this.minStack.push(newNum);
        } else {
            //*******  第二种方法在入栈时如果当前数据不是最小的，会给minStack继续插入一条minStack栈顶元素
            Integer peek = this.minStack.peek();
            this.minStack.push(peek);
        }
        this.nowStack.push(newNum);
    }

    private int pop() {
        if (this.nowStack.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        Integer pop = this.nowStack.pop();
        //*******  好处就是出栈时效率高，但是入栈相比较上面方法效率低
        this.minStack.pop();
        return pop;
    }

    private int getMin() {
        if (this.minStack.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        return this.minStack.peek();
    }

}

