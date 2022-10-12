package basic_class.class02;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返
 * 回栈中最小元素的操作。
 * 【要求】
 * 1．pop、push、getMin操作的时间复杂度都是O(1)。
 * 2．设计的栈类型可以使用现成的栈结构。
 */
public class Code_02_GetMinStack {

    public static class MyStack{

        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public void push(Integer obj){
            stackData.push(obj);
            if(stackMin.isEmpty() || obj <= stackMin.peek()){
                stackMin.push(obj);
            }
        }

        public Integer pop(){
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }

            int val = stackData.pop();
            if(val == stackMin.peek()){
                stackMin.pop();
            }
            return val;
        }

        public Integer getMin(){
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return stackMin.peek();
        }

    }

}
