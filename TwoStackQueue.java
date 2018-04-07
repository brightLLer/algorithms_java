import java.util.*;

/***
 * 
 * @author JTMSJBS
 * ������ջʵ��һ�����У�ֻ��Ҫ׼��һ��ѹ��ջ��һ������ջ����ѹ��ջ�����ݷ�����"����"����ջ��
 * ������У�ѹ��ջ�򵯳�ջ����������Ҫע�⣺
 * 1�����ѹ��ջҪ�򵯳�ջ�������ݣ�һ��Ҫһ���Խ��������ݵ��루���ֻ���벿�֣����Ի�Ӱ�쵽���ӵ�˳��
 * 2���������ջ��Ϊ�գ�ѹ��ջҲ���������ݵ��뵯��ջ�У�����ջ��Ϊ�մ���ԭ��������û�г�����ϣ��ֵ��������ݾ�����"���"�ˣ�
 *�����������㣬���Ե�����дһ��ѹ��ջ�򵯳�ջ�����ݵĺ�������һ"����"��ʱ�����Է�������Ӻ󣬳���ǰ�����߻�ȡ��βԪ��ǰ���κ�
 *һ��ʱ������Ȼ��Ҳ����������д�ϣ���
 *ע�⣺���к�ջ�ؼ�Ҫע���пգ�����д��pop����poll�Ĵ��롣
 */

public class TwoStackQueue {
	
	public Stack<Integer> stackPush;
	public Stack<Integer> stackPop;
	
	
	public TwoStackQueue(){
		stackPush = new Stack<Integer>();
		stackPop = new Stack<Integer>();
	}
	
	public void stackPush2stackPop(){
		if(stackPush.isEmpty() && stackPop.isEmpty()){
			throw new RuntimeException("Queue is empty");
		}
		if(stackPop.isEmpty()){
			while(!stackPush.isEmpty()){
				int item = stackPush.pop();
				stackPop.push(item);
			}
		}
	}

	//add
	public void enqueue(int item){
		
		stackPush.push(item);
		stackPush2stackPop();
	}
	
	//poll
	public int dequeue(){
		
		stackPush2stackPop();
		return stackPop.pop();
	}
	
	//peek
	public int front(){
		
		stackPush2stackPop();
		return stackPop.peek();	
	}
	
	public static void main(String[] args){
		
		TwoStackQueue twoStackQueue = new TwoStackQueue();
		twoStackQueue.enqueue(1);
		twoStackQueue.enqueue(2);
		twoStackQueue.enqueue(3);
		System.out.println(twoStackQueue.dequeue());
		twoStackQueue.enqueue(4);
		System.out.println(twoStackQueue.dequeue());
		twoStackQueue.enqueue(5);
		System.out.println(twoStackQueue.dequeue());
		System.out.println(twoStackQueue.dequeue());
		System.out.println(twoStackQueue.dequeue());
	}
}
