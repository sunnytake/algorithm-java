package interview.dandiaostack;


import java.util.Stack;

public class Code_02_Stack2Queue {

    private Stack<Integer> stack;
    private Stack<Integer> helpStack;

    public Code_02_Stack2Queue(){
        this.stack = new Stack<Integer>();
        this.helpStack = new Stack<Integer>();
    }

    public void add(Integer val){
        this.stack.push(val);
    }

    public Integer poll(){
        if(!this.helpStack.isEmpty()){
            return this.helpStack.pop();
        }else if(!this.stack.isEmpty()){
            while(!this.stack.isEmpty()){
                this.helpStack.push(this.stack.pop());
            }
            return this.helpStack.pop();
        }
        return null;
    }

    public Integer peek(){
        if(!this.helpStack.isEmpty()){
            return this.helpStack.peek();
        }else if(!this.stack.isEmpty()){
            while(!this.stack.isEmpty()){
                this.helpStack.push(this.helpStack.pop());
            }
            return this.helpStack.peek();
        }
        return null;
    }

}
