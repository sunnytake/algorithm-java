package basic_class.class02;

/**
 * 用数组结构实现大小固定的队列和栈
 */
public class Code_01_Array_To_Stack_Queue {

    public static class ArrayStack{

        private Integer[] array;
        private Integer length;

        public ArrayStack(int initSize){
            if(initSize < 0)
                throw new IllegalArgumentException("The init size is less than 0");
            array = new Integer[initSize];
            length = 0;
        }

        public Integer peek(){
            if(length == 0)
                return null;
            return array[length-1];
        }

        public void push(int obj){
            if(length == array.length)
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            array[length++] = obj;
        }

        public Integer pop(){
            if(length == 0)
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            return array[--length];
        }

    }

    public static class ArrayQueue{

        private Integer[] array;
        private Integer length;
        private Integer first;
        private Integer last;

        public ArrayQueue(int initSize){
            if(initSize < 0)
                throw new IllegalArgumentException("The init size is less than 0");
            array = new Integer[initSize];
            length = 0;
            first = 0;
            last = 0;
        }

        public Integer peek(){
            if(length == 0)
                return null;
            return array[first];
        }

        public void push(int obj){
            if(length == array.length)
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            length++;
            array[last] = obj;
            last = last == array.length - 1 ? 0 : last + 1;
        }

        public Integer poll(){
            if(length == 0)
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            length--;
            int tmp = first;
            first = first == array.length - 1 ? 0 : first + 1;
            return array[tmp];
        }

    }


}
