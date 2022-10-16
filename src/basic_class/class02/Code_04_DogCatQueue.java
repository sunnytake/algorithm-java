package basic_class.class02;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 猫狗队列 【题目】 宠物、狗和猫的类如下：
 * public class Pet { private String type;
 * public Pet(String type) { this.type = type; }
 * public String getPetType() { return this.type; }
 * }
 * public class Dog extends Pet { public Dog() { super("dog"); } }
 * public class Cat extends Pet { public Cat() { super("cat"); } }
 * 实现一种狗猫队列的结构，要求如下：
 * 用户可以调用add方法将cat类或dog类的实例放入队列中；
 * 用户可以调用pollAll方法，将队列中所有的实例按照进队列的先后顺序依次弹出；
 * 用户可以调用pollDog方法，将队列中dog类的实例按照进队列的先后顺序依次弹出；
 * 用户可以调用pollCat方法，将队列中cat类的实例按照进队列的先后顺序依次弹出；
 * 用户可以调用isEmpty方法，检查队列中是否还有dog或cat的实例；
 * 用户可以调用isDogEmpty方法，检查队列中是否有dog类的实例；
 * 用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例。
 */
public class Code_04_DogCatQueue {

    public static class Pet{
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    public static class Cat extends Pet{

        public Cat(String type) {
            super("cat");
        }

    }

    public static class Dog extends Pet{

        public Dog(String type) {
            super("dog");
        }
    }

    public static class PetEnterQueue{
        private Pet pet;
        private long count;

        public PetEnterQueue(Pet pet, long count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return pet;
        }

        public long getCount() {
            return count;
        }

        public String getEnterPetType(){
            return this.pet.getType();
        }
    }

    public static class DogCatQueue{
        private Queue<PetEnterQueue> dogQ;
        private Queue<PetEnterQueue> catQ;
        private long count;

        public DogCatQueue(){
            this.dogQ = new LinkedList<PetEnterQueue>();
            this.catQ = new LinkedList<PetEnterQueue>();
            this.count = 0;
        }

        public void add(Pet pet){
            if(pet.getType().equals("dog")){
                this.dogQ.add(new PetEnterQueue(pet, this.count++));
            }else if(pet.getType().equals("cat")){
                this.catQ.add(new PetEnterQueue(pet, this.count++));
            }else{
                throw new RuntimeException("error, not dog or cat!");
            }
        }

        public Pet pollAll(){
            if(!this.dogQ.isEmpty() && !this.catQ.isEmpty()){
                if(this.dogQ.peek().getCount() < this.catQ.peek().getCount()){
                    return this.dogQ.poll().getPet();
                }else{
                    return this.catQ.poll().getPet();
                }
            }else if(!this.dogQ.isEmpty()){
                return this.dogQ.poll().getPet();
            }else if(!this.catQ.isEmpty()){
                return this.catQ.poll().getPet();
            }else{
                throw new RuntimeException("error, queue is empty!");
            }
        }

        public Dog pollDog(){
            if(!this.dogQ.isEmpty()){
                return (Dog) this.dogQ.poll().getPet();
            }else{
                throw new RuntimeException("Dog queue is empty!");
            }
        }

        public Cat pollCat(){
            if(!this.catQ.isEmpty()){
                return (Cat) this.catQ.poll().getPet();
            }else{
                throw new RuntimeException("Cat queue is empty!");
            }
        }
    }



}
