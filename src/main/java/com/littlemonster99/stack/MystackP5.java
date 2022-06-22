package com.littlemonster99.stack;

import java.util.Stack;

/**
 * <pre>
 * 任务：
 * 描述：由两个栈组成的队列  p5
 * 【题目】
 *  编写一个类，用两个栈实现队列，支持队列的基本操作（add、poll、peek）
 *
 * 作者：
 * 时间：
 * </pre>
 */

//首先，栈是先进后出，队列是先进先出
public class MystackP5 {
    //用来入栈
    Stack<Integer> pushStack;
    //用来出栈
    Stack<Integer> popStack;

    MystackP5() {
        this.pushStack = new Stack<Integer>();
        this.popStack = new Stack<Integer>();
    }

    public int add(int num) {
        int push = this.pushStack.push(num);
        return push;
    }

    public int poll() {
        if (this.pushStack.empty() && this.popStack.empty()) {
            throw new RuntimeException("stack is empty");
        } else if (this.popStack.empty()) {
            while (!this.pushStack.empty()) {
                this.popStack.push(this.popStack.pop());
            }
        }
        return this.popStack.pop();
    }

    public int pop() {
        if (this.popStack.empty() && this.pushStack.empty()) {
            throw new RuntimeException("stack is empty");
        } else if (this.popStack.empty()) {
            while (this.pushStack.empty()) {
                this.popStack.push(this.pushStack.pop());
            }
        }
        return this.popStack.peek();
    }

}
