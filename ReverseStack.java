import java.util.*;
/***
 * 
 * @author JTMSJBS
 * 使用一个栈和一个递归函数来逆序一个栈
 * 一个非常重要的点是：栈的每一层和递归的每一层是一一对应的，一个递归函数的内部代码就代表了递归的一层
 * 我们要设计的第一个递归函数是，获取栈底部元素的函数：
 * 1、边界条件，是递归的最底层，也是栈的最底层，我们想要的元素在这里，pop出来后直接返回
 * 2、非边界条件，是递归/栈的底层以上的各层，没有我们想要的元素,因此元素pop出来又push回去
 * 所以顺序其实很明显，在每一层上的顺序为pop->递归->push，或者pop->栈->返回（底层的时候）
 * 设计的第二个递归函数也类似
 * 在栈的每一层上，获取到当前层时底层的元素并将底层移除后，重新push回栈，因此，顺序为：
 * getAndRemoveLastElement->递归->push，比如栈顶到栈底为3->2->1，那么每
 * 一层对应的底层元素为1->2->3，在第一层上，将1push，第二层上，将2push....换言之
 * 层与层之间是独立的。
 * （参考书上第9页的图理解）
 *
 */

public class ReverseStack {

	public Stack<Integer> stack;
	
	public ReverseStack() {
		stack = new Stack<Integer>();
	}
	
	public void push(int item){
		stack.push(item);
	}
	
	public int pop(){
		return stack.pop();
	}
	
	public boolean isEmpty(){
		return stack.isEmpty();
	}
	
	public int getAndRemoveLastElement(){
		
		int result = stack.pop();
		
		if(stack.isEmpty()){
		   //边界条件
			return result;
		}else{
			//先递归再进行栈操作
			//有返回值的递归函数在非边界的情况下返回其本身
			int last = getAndRemoveLastElement();
			stack.push(result);
			return last;
		}
		
	}
	
	public void reverse(){
		//边界条件
		if(stack.isEmpty()){
			return;
		}else{	
			int item = getAndRemoveLastElement();
			//先递归在进行栈操作
			reverse();
			stack.push(item);		
		}
		
	}
	
	public static void main(String[] args){
		ReverseStack reverseStack = new ReverseStack();
		for(int i = 0; i < 5; ++i){
			reverseStack.push(i + 1);
		}
		reverseStack.reverse();
		while(!reverseStack.isEmpty()){
			System.out.println(reverseStack.pop());
		}
	}
}
