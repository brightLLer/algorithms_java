import java.util.*;

/***
 * 
 * @author JTMSJBS
 * 这一版本的算法比上一版本有了一些微小的改动
 * 1、压入规则：
 * 如果newNum比stackMin的栈顶元素小，则将newNum压入stackMin，否则，
 * 将stackMin的栈顶元素再重复压入stackMin一次。
 * 2、弹出规则：
 * stackData弹出的元素记为value，stackMin也同步弹出栈顶元素，但已经不需
 * 要比较了
 * 3、获取最小元素：
 * 返回stackMin的栈顶元素
 * 换言之，这种算法的主要思路是：一旦有新元素压入stackData，就记为一步，stackMin
 * 的作用就是记录这每一步之后的stackData的最小值，发生弹出时相当于一个让stackMin
 * 起到一个"回退"的作用。
 * 3个函数的时间复杂依然为O(1)，空间复杂度为O(n)
 * 
 *
 */


public class GetMinStackV2 {
	
	public Stack<Integer> stackData;
	public Stack<Integer> stackMin;
	
	public GetMinStackV2(){
		
		stackData = new Stack<Integer>();
		stackMin = new Stack<Integer>();
		
	}
	
	public int getMin(){
		if(stackMin.isEmpty())
			throw new RuntimeException("Your stack is empty");
		return stackMin.peek();
	}
	
	public void push(int newNum){
		
		stackData.push(newNum);
		if(stackMin.isEmpty()){
			stackMin.push(newNum);
		}else{
			int top = getMin();
			if(newNum <= top)
				stackMin.push(newNum);
			else
				stackMin.push(top);
		}
		
	}
	
	public int pop(){
		
		if(stackData.isEmpty() || stackMin.isEmpty())
			throw new RuntimeException("Your stack is empty");
		int value = stackData.pop();
		stackMin.pop();
		return value;
		
	}
	
	public static void main(String[] args){
		
		GetMinStackV2 getMinStack = new GetMinStackV2();
		getMinStack.push(6);
		getMinStack.push(4);
		getMinStack.push(1);
		getMinStack.push(3);
		getMinStack.push(5);
		System.out.println(getMinStack.getMin());
		getMinStack.pop();
		getMinStack.pop();
		System.out.println(getMinStack.getMin());
	}

}
