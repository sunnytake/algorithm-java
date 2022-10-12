package basic_class.class02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code_03_StackAndQueueConvert {

    public static class TwoStackQueue{

        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public TwoStackQueue(){
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }

        public void push(int obj){
            this.stackPush.push(obj);
        }

        public int poll(){
            if(stackPop.empty() && stackPush.empty()){
                throw new RuntimeException("Queue is empty!");
            }else if(stackPop.empty()){
                while(!stackPush.empty()){
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.pop();
        }

        public int peek(){
            if(stackPop.empty() && stackPush.empty()){
                throw new RuntimeException("Queue is empty!");
            }else if(stackPop.empty()){
                while(!stackPush.empty()){
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }

    }

    public static class TwoQueueStack{

        private Queue<Integer> queue;
        private Queue<Integer> help;

        public TwoQueueStack(){
            queue = new LinkedList<Integer>();
            help = new LinkedList<Integer>();
        }

        public void push(int obj){
            this.queue.add(obj);
        }

        public int pop(){
            if(queue.isEmpty())
                throw new RuntimeException("Stack is Empty");

            while(queue.size() > 1)
                help.add(queue.poll());

            int res = queue.poll();
            swap();
            return res;
        }

        public void swap(){
            Queue<Integer> temp = help;
            help = queue;
            queue = temp;
        }

        public int peek(){
            if(queue.isEmpty())
                throw new RuntimeException("Stack is Empty");

            while(queue.size() > 1)
                help.add(queue.poll());

            int res = queue.poll();
            help.add(res);
            swap();
            return res;
        }

    }

}
