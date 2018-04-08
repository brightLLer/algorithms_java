import java.util.*;
/***
 * 
 * @author JTMSJBS
 *使用一个辅助栈帮助另外一个栈实现由栈顶到栈底的降序排列
 *1、设置主栈为stack，辅助栈为help：
 *2、将stack的栈顶元素弹出（注意一定要弹出），记为cur，如果cur比help栈顶元素小，则直接压入；
 *否则将help的元素一一弹出直到cur <= help的栈顶元素
 *这两步的代码结构为：
 *cur = stack弹出元素
 *while(cur > help栈顶元素){
 *   help弹出栈顶元素并压入stack
 *} --->保证循环跳出时为cur <= help
 *help压入cur -->根据2点第一部分
 *上述步骤在stack中遍历，完成后需要将help的元素"倒回"stack才能实现降序
 *注意：边界条件isEmpty()先不写，等写到有pop的地方时就会自然而然补上了
 */

public class SortStackByStack {

	private Stack<Integer> stack;
	private Stack<Integer> help;
	
	public SortStackByStack(){
		stack = new Stack<Integer>();
		help = new Stack<Integer>();
	}
	
	public void push(int item){
		stack.push(item);
	}
	
	public boolean isEmpty(){
		return stack.isEmpty();
	}
	
	public int pop(){
		return stack.pop();
	}
	
	public void sort(){
		
		while(!stack.isEmpty()){
			int cur = stack.pop();
			while(!help.isEmpty() && cur > help.peek()){
				stack.push(help.pop());
			}
			help.push(cur);
		}
		while(!help.isEmpty()){
			stack.push(help.pop());
		}
		
	}
	
	public static void main(String[] args){
		
		SortStackByStack sortStackbyStack = new SortStackByStack();
		sortStackbyStack.push(4);
		sortStackbyStack.push(5);
		sortStackbyStack.push(1);
		sortStackbyStack.push(3);
		sortStackbyStack.push(2);
		sortStackbyStack.push(8);
		sortStackbyStack.sort();
		while(!sortStackbyStack.isEmpty()){
			System.out.println(sortStackbyStack.pop());
		}
		
	}
}
