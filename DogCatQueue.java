import java.util.*;

/***
 * 
 * @author JTMSJBS
 * ����������ݽṹ��è�����У�Java�����Ķ���ʵ��ΪLinkedList
 * è�����е�Ҫ���ǣ������п��Դ��è���߹���ʵ�������Լ�������è/��/�������е�ʵ���Ƿ�Ϊ�գ�������è/��/�������а�˳�����
 * ���ֳ����Ĵ����ǣ�
 * 1������׼��è���У������У��Լ��ܵĶ��У�è�͹���һ�𣩣����󣺸�������
 * 2���ù�ϣ��key��cat/dogʵ����value�������еĴ��򣬴��󣺲�֧��һ��ʵ����ν�����У���ϣ���keyֻ�ܶ�Ӧһ��value
 * 3���޸�cat/dog�࣬����һ����������󣺸������û���Ľṹ
 * ��ȷ�����������°�װ���������ģ�Pet�࣬��һ��PetWithTimestamp����ά��Pet��ʵ����һ������ӵ�ʱ���������Ƶ�è������
 * ҲӦ����һ��ʱ���������Pet�������ʱ������ʱ���������ֵ��Pet(è/��)������pollAllʱֻҪ�Ƚ�è�͹�֮���ʱ��������ˣ�
 * ����ʱ������ȳ��ӡ�
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
		
		//�ж����������Ƿ�Ϊ��
		if(isEmpty()){
			throw new RuntimeException("Your queue is empty.");
		}
		//�˴�˵�����в�Ϊ�յ�è�����ѿգ�ֻʣ�¹�
		else if(catQueue.isEmpty())
			return dogQueue.poll().getPet();
		//�˴�˵�����в�Ϊ�յ��������ѿգ�ֻʣ��è
		else if(dogQueue.isEmpty())
			return catQueue.poll().getPet();
		//è�������о���Ϊ��
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