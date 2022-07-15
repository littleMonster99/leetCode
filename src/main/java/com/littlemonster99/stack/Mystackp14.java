package com.littlemonster99.stack;

/**
 * <pre>
 * 任务：用栈来求解汉诺塔问题 p14   ??? 看不懂
 * 【题目】
 *      汉诺塔问题比较经典，这里修改一下游戏规则：现在限制不能从最左侧的塔直接移动
 * 到最右侧，也不能从最右侧直接移动到最左侧，而是必须经过中间。求当塔有N层的时候，
 * 打印最优移动过程和最优移动总步数。
 * </pre>
 */

public class Mystackp14 {
    public int hanoiProblem1(int num, String left, String mid,
                             String right) {
        if (num < 1) {
            return 0;
        }
        return process(num, left, mid, right, left, right);
    }

    public int process(int num, String left, String mid, String right,
                       String from, String to) {
        if (num == 1) {
            if (from.equals(mid) || to.equals(mid)) {
                System.out.println("Move 1 from " + from + " to " + to);
                return 1;
            } else {
                System.out.println("Move 1 from " + from + " to " + mid);
                System.out.println("Move 1 from " + mid + " to " + to);
                return 2;
            }
        }
        if (from.equals(mid) || to.equals(mid)) {
            String another = (from.equals(left) || to.equals(left)) ? right :
                    left;
            int part1 = process(num - 1, left, mid, right, from, another);
            int part2 = 1;
            System.out.println("Move " + num + " from " + from + " to " + to);
            int part3 = process(num - 1, left, mid, right, another, to);
            return part1 + part2 + part3;
        } else {
            int part1 = process(num - 1, left, mid, right, from, to);
            int part2 = 1;
            System.out.println("Move " + num + " from " + from + " to " + mid);
            int part3 = process(num - 1, left, mid, right, to, from);
            int part4 = 1;
            System.out.println("Move " + num + " from " + mid + " to " + to);
            int part5 = process(num - 1, left, mid, right, from, to);
            return part1 + part2 + part3 + part4 + part5;
        }
    }
}
