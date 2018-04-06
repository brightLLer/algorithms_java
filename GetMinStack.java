import java.util.*;

/***
 * 
 * @author JTMSJBS
 * 
 * 首先，明确这种数据结构是一个具有能得到最小元素功能的栈，因此我们需要重新定义这种栈的压入和弹出规则
 * 可以利用两个栈stackData和stackMin来实现这一种特殊的栈
 * 1、压入规则：
 * 将当前元素newNum压入栈中时，先将newNum压入stackData，然后判断stackMin是否为空，若为空，则将newNum同步压入，若不为空，则将newNum与
 * stackMin的栈顶元素top比较，若newNum <= top，则将newNum同步压入，否则stackMin保持原样。（换言之，stackMin的栈顶维持stackData
 * 中的最小元素）
 * 2、弹出规则：
 * 首先将stackData的栈顶元素弹出，记录为value，如果stackMin的栈顶元素为top，那么value >= top是恒成立的，因此只要判断，如果value==top，
 * 则将stackMin的栈顶元素top也弹出，否则，value > top，stackMin不需要弹出任何元素。
 * 3、获取最小元素的规则：
 * 只要返回stackMin的栈顶元素即可
 * 
 * 3个函数的功能都是O(1)
 *
 */

public class GetMinStack {
	
	public Stack<Integer> stackData;
	public Stack<Integer> stackMin;
	
	public GetMinStack(){
		stackData = new Stack<Integer>();
		stackMin = new Stack<Integer>();
	}
	
	
	public void push(int newNum){
		stackData.push(newNum);
		if(stackMin.isEmpty())
			stackMin.push(newNum);
		else{
			if(newNum <= getMin()){
				stackMin.push(newNum);
			}
		}
	}
	
	public int pop(){
		if(stackData.isEmpty()){
			throw new RuntimeException("Your stack is empty");
		}
		int value = stackData.pop();
		if(value == getMin())
			stackMin.pop();
		return value;
	}
	
	
	public int getMin(){
		if(stackMin.isEmpty()){
			throw new RuntimeException("Your stack is Empty");
		}
		return stackMin.peek();
	}
	
	
	public static void main(String[] args) {
	
		GetMinStack getMinStack = new GetMinStack();
		getMinStack.push(6);
		getMinStack.push(3);
		getMinStack.push(1);
		getMinStack.push(4);
		System.out.println(getMinStack.getMin());
		getMinStack.pop();
		getMinStack.pop();
		System.out.println(getMinStack.getMin());
	}
}
