package interview.dandiaostack;

import java.util.LinkedList;
import java.util.Queue;

public class Code_03_CatDogQueue {

    private Queue<PetEnterQueue> dogQueue;
    private Queue<PetEnterQueue> catQueue;
    private Long index;

    public Code_03_CatDogQueue() {
        this.dogQueue = new LinkedList<PetEnterQueue>();
        this.catQueue = new LinkedList<PetEnterQueue>();
        this.index = 0L;
    }

    class Pet{
        private String type;
        public Pet(String type){
            this.type = type;
        }
        public String getPetType(){
            return this.type;
        }
    }

    class Dog extends Pet{
        public Dog() {
            super("Dog");
        }
    }

    class Cat extends Pet{
        public Cat() {
            super("Cat");
        }
    }

    class PetEnterQueue{
        private Pet pet;
        private Long index;

        public PetEnterQueue(Pet pet, Long index) {
            this.pet = pet;
            this.index = index;
        }

        public Pet getPet() {
            return pet;
        }

        public Long getIndex() {
            return index;
        }

        public String getEnterPetType(){
            return this.pet.getPetType();
        }
    }

    public void add(Pet pet){
        if("Dog".equals(pet.getPetType())){
            this.dogQueue.add(new PetEnterQueue(pet, this.index++));
        }else if("Cat".equals(pet.getPetType())){
            this.catQueue.add(new PetEnterQueue(pet, this.index++));
        }else{
            throw new RuntimeException("error, not dog or cat");
        }
    }

    public Pet pollAll(){
        if(!this.dogQueue.isEmpty() && !this.catQueue.isEmpty()){
            if(this.dogQueue.peek().getIndex() < this.catQueue.peek().getIndex()){
                return this.dogQueue.poll().getPet();
            }else{
                return this.catQueue.poll().getPet();
            }
        }else if(!this.dogQueue.isEmpty()){
            return this.dogQueue.poll().getPet();
        }else if(!this.catQueue.isEmpty()) {
            return this.catQueue.poll().getPet();
        }else{
            throw new RuntimeException("error, the queue is empty");
        }
    }

    public Dog pollDog(){
        if(!this.dogQueue.isEmpty()){
            return (Dog)this.dogQueue.poll().getPet();
        }else{
            throw new RuntimeException("Dog queue is empty!");
        }
    }

    public Cat pollCat(){
        if(!this.catQueue.isEmpty()){
            return (Cat)this.catQueue.poll().getPet();
        }else{
            throw new RuntimeException("Cat queue is empty!");
        }
    }

    public boolean isEmpty(){
        return this.dogQueue.isEmpty() && this.catQueue.isEmpty();
    }

    public boolean isDogQueueEmpty(){
        return this.dogQueue.isEmpty();
    }

    public boolean isCatQueueEmpty(){
        return this.catQueue.isEmpty();
    }



}
