package com.littlemonster99.stack;

import java.util.Stack;

/**
 * <pre>
 * 任务：
 * 描述：(这里用一句话描述这个类的作用)
 * 作者：
 * 时间：
 * </pre>
 */

public class Mystackp10 {
    static Stack<Pet> stack = new Stack<Pet>();

    public static void main(String[] args) {
        add(new Cat());
        add(new Dog());
        add(new Cat());
        add(new Cat());
        add(new Cat());
        add(new Dog());
        pollAll();
        add(new Dog());
        add(new Cat());
        add(new Cat());
        add(new Cat());
        add(new Dog());
        pollDog();
        pollCat();
    }

    public static void add(Pet pet) {
        stack.push(pet);
    }

    public static void pollAll() {
        while (!stack.empty()) {
            stack.pop();
        }
    }

    public static Pet pollDog() {
        if (stack.empty()) {
            throw new RuntimeException("this stack is empty");
        }
        Pet pet = stack.pop();
        if (pet instanceof Dog) {
            return pet;
        } else {
            pollAll();
            stack.push(pet);
        }
        return null;
    }

    public static Pet pollCat() {
        if (stack.empty()) {
            throw new RuntimeException("this stack is empty");
        }
        Pet pet = stack.pop();
        if (pet instanceof Cat) {
            return pet;
        } else {
            pollAll();
            stack.push(pet);
        }
        return null;
    }

    public static Boolean isEmpty() {
        if (stack.empty()) {
            throw new RuntimeException("this stack is empty");
        }
        Pet pet = stack.pop();
        if (pet instanceof Cat || pet instanceof Dog) {
            return true;
        } else {
            pollAll();
            stack.push(pet);
        }
        return false;
    }

    public static Boolean isDogEmpty() {
        if (stack.empty()) {
            throw new RuntimeException("this stack is empty");
        }
        Pet pet = stack.pop();
        if (pet instanceof Dog) {
            return true;
        } else {
            pollAll();
            stack.push(pet);
        }
        return false;
    }

    public static Boolean isCatEmpty() {
        if (stack.empty()) {
            throw new RuntimeException("this stack is empty");
        }
        Pet pet = stack.pop();
        if (pet instanceof Cat) {
            return true;
        } else {
            pollAll();
            stack.push(pet);
        }
        return false;
    }
}

class Pet {
    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}

class Dog extends Pet {
    public Dog() {
        super("dog");
    }
}

class Cat extends Pet {
    public Cat() {
        super("Cat");
    }
}