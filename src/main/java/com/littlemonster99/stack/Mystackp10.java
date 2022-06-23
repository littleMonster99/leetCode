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
//方法一 使用递归调用
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
        while (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public static Pet pollDog() {
        if (stack.isEmpty()) {
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
        if (stack.isEmpty()) {
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
        if (stack.isEmpty()) {
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
        if (stack.isEmpty()) {
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
        if (stack.isEmpty()) {
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

//方法二 使用新的结构体
class Mystackp10_2 {
    private Stack<PetEnterQueue> catQ;
    private Stack<PetEnterQueue> dogQ;
    private long count;

    public Mystackp10_2() {
        this.catQ = new Stack<PetEnterQueue>();
        this.dogQ = new Stack<PetEnterQueue>();
        this.count = 0;
    }

    public void add(Pet pet) {
        if ("Cat".equals(pet.getType())) {
            this.catQ.push(new PetEnterQueue(pet, this.count++));
        } else if ("Dog".equals(pet.getType())) {
            this.dogQ.push(new PetEnterQueue(pet, count++));
        } else {
            throw new RuntimeException("this pet is not dog or cat!");
        }
    }

    public Pet pollAll() {
        if (!this.catQ.isEmpty() && !this.dogQ.empty()) {
            if (this.catQ.peek().getCount() < this.dogQ.peek().getCount()) {
                return this.dogQ.pop().getPet();
            } else {
                return this.catQ.pop().getPet();
            }
        } else if (!this.dogQ.isEmpty()) {
            return this.dogQ.pop().getPet();
        } else if (!this.catQ.isEmpty()) {
            return this.catQ.pop().getPet();
        } else {
            throw new RuntimeException("err, queue is empty!");
        }
    }

    public Pet pollDog() {
        if (this.dogQ.isEmpty()) {
            return this.dogQ.pop().getPet();
        } else {
            throw new RuntimeException("err, dog is empty!");
        }
    }

    public Pet pollCat() {
        if (this.catQ.isEmpty()) {
            return this.catQ.pop().getPet();
        } else {
            throw new RuntimeException("err, cat is empty!");
        }
    }

    public Boolean isEmpty() {
        return this.catQ.isEmpty() && this.dogQ.isEmpty();
    }

    public Boolean isDogEmpty() {
        return this.dogQ.isEmpty();
    }

    public Boolean isCatEmpty() {
        return this.catQ.isEmpty();
    }
}

//第二种方法的结构体
class PetEnterQueue {
    private Pet pet;
    private long count;

    public PetEnterQueue(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return this.pet;
    }

    public long getCount() {
        return this.count;
    }

    public String getEnterPetType() {
        return this.pet.getType();
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
        super("Dog");
    }
}

class Cat extends Pet {
    public Cat() {
        super("Cat");
    }
}