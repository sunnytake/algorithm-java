package interview.dandiaostack;

import java.util.Stack;

/**
 * 【题目】实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 * 要求：
 * 1.pop、push、getMin操作的时间复杂度都是O（1）。
 * 2.设计的栈类型可以使用现成的栈结构。
 */
public class Code_01_StackWithMin {

    public Stack<Integer> stack;
    public Stack<Integer> minStack;

    public Code_01_StackWithMin() {
        this.stack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();
    }

    public Integer pop(){
        if(stack.size() > 0) {
            int temp = stack.pop();
            if(this.minStack.peek() == temp){
                this.minStack.pop();
            }
            return temp;
        }

        return null;
    }

    public void push(Integer val){
        this.stack.push(val);
        if(this.minStack.isEmpty() || val <= this.minStack.peek()){
            this.minStack.push(val);
        }
    }

    public Integer getMin(){
        return this.minStack.peek();
    }




}
