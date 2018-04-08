import java.util.*;

/***
 * 
 * @author JTMSJBS
 * 设计特殊数据结构：猫狗队列，Java中最经典的队列实现为LinkedList
 * 猫狗队列的要求是：队列中可以存放猫或者狗的实例，可以检查队列中猫/狗/整个队列的实例是否为空，可以让猫/狗/整个队列按顺序出队
 * 几种常见的错误是：
 * 1、单独准备猫队列，狗队列，以及总的队列（猫和狗放一起），错误：更新问题
 * 2、用哈希表：key：cat/dog实例，value：进队列的次序，错误：不支持一个实例多次进入队列，哈希表的key只能对应一个value
 * 3、修改cat/dog类，增加一个计数项，错误：更改了用户类的结构
 * 正确的做法是重新包装（但不更改）Pet类，用一个PetWithTimestamp类来维护Pet的实例和一个它入队的时间戳，所设计的猫狗队列
 * 也应该有一个时间戳，当有Pet进入队列时，队列时间戳自增后赋值给Pet(猫/狗)，这样pollAll时只要比较猫和狗之间的时间戳就行了，
 * 来的时间早的先出队。
 */

public class DogCatQueue {
	
	private LinkedList<PetWithTimestamp> dogQueue;
	private LinkedList<PetWithTimestamp> catQueue;
	private long count;
	
	public DogCatQueue(){
		dogQueue = new LinkedList<PetWithTimestamp>();
		catQueue = new LinkedList<PetWithTimestamp>();
	}
	
	public boolean isDogEmpty(){
		return dogQueue.isEmpty();
	}
	
	public boolean isCatEmpty(){
		return catQueue.isEmpty();
	}
	
	public boolean isEmpty(){
		return dogQueue.isEmpty() && catQueue.isEmpty();
	}
	
	public void add(Pet pet){
		PetWithTimestamp petWithTimestamp = new PetWithTimestamp(pet, this.count++);
		if(pet.getPetType().equals("dog"))
			dogQueue.add(petWithTimestamp);
		else
			catQueue.add(petWithTimestamp);
	}
	
	public Pet pollAll(){
		
		//判断整个队列是否为空
		if(isEmpty()){
			throw new RuntimeException("Your queue is empty.");
		}
		//此处说明队列不为空但猫队列已空，只剩下狗
		else if(catQueue.isEmpty())
			return dogQueue.poll().getPet();
		//此处说明队列不为空但狗队列已空，只剩下猫
		else if(dogQueue.isEmpty())
			return catQueue.poll().getPet();
		//猫，狗队列均不为空
		else{
			PetWithTimestamp catWithTimestamp = catQueue.peek();
			PetWithTimestamp dogWithTimestamp = dogQueue.peek();
			if(catWithTimestamp.getCount() < dogWithTimestamp.getCount())
				return catQueue.poll().getPet();
			else
				return dogQueue.poll().getPet();
		}
	}
	
	public Dog pollDog(){
		if(dogQueue.isEmpty()){
			throw new RuntimeException("Your dog queue is empty.");
		}
		return (Dog)dogQueue.poll().getPet();
	}
	
	public Cat pollCat(){
		if(dogQueue.isEmpty()){
			throw new RuntimeException("Your cat queue is empty.");
		}
		return (Cat)catQueue.poll().getPet();
	}
	
	public static void main(String[] args){
		
		DogCatQueue dogCatQueue = new DogCatQueue();
		Dog dog1 = new Dog();
		Dog dog2 = new Dog();
		Cat cat1 = new Cat();
		Cat cat2 = new Cat();
		dogCatQueue.add(dog1);
		dogCatQueue.add(cat1);
		dogCatQueue.add(dog2);
		dogCatQueue.add(cat2);
		while(!dogCatQueue.isEmpty()){
			System.out.println(dogCatQueue.pollAll().getPetType());
		}
		System.out.println();
		dogCatQueue.add(dog1);
		dogCatQueue.add(cat1);
		dogCatQueue.add(dog2);
		dogCatQueue.add(cat2);
		while(!dogCatQueue.isCatEmpty()){
			System.out.println(dogCatQueue.pollCat().getPetType());
		}
		System.out.println();
		dogCatQueue.add(dog1);
		dogCatQueue.add(cat1);
		dogCatQueue.add(dog2);
		dogCatQueue.add(cat2);
		while(!dogCatQueue.isDogEmpty()){
			System.out.println(dogCatQueue.pollDog().getPetType());
		}
	}

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
	public Dog(){
		super("dog");
	}
}

class Cat extends Pet{
	public Cat(){
		super("Cat");
	}
}

class PetWithTimestamp{
	private Pet pet;
	private long count;
	public PetWithTimestamp(Pet pet, long count){
		this.pet = pet;
		this.count = count;
	}
	public Pet getPet(){
		return this.pet;
	}
	public long getCount(){
		return this.count;
	}
	public String getPetType(){
		return this.pet.getPetType();
	}
	
}