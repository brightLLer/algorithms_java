import java.util.*;

/***
 * 
 * @author JTMSJBS
 * 用两个栈实现一个队列，只需要准备一个压入栈和一个弹出栈，将压入栈的数据反过来"倒入"弹出栈中
 * 这过程中，压入栈向弹出栈倒入数据需要注意：
 * 1、如果压入栈要向弹出栈倒入数据，一定要一次性将所有数据倒入（如果只倒入部分，明显会影响到出队的顺序）
 * 2、如果弹出栈不为空，压入栈也不允许将数据倒入弹出栈中（弹出栈不为空代表原来的数据没有出队完毕，又倒入新数据就是在"插队"了）
 *基于以上两点，可以单独编写一个压入栈向弹出栈倒数据的函数，这一"倒入"的时机可以发生在入队后，出队前，或者获取队尾元素前的任何
 *一个时机（当然，也可以三个都写上）。
 *注意：队列和栈关键要注意判空，留意写了pop或者poll的代码。
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
