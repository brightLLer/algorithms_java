import java.util.*;
/***
 * 
 * @author JTMSJBS
 *ʹ��һ������ջ��������һ��ջʵ����ջ����ջ�׵Ľ�������
 *1��������ջΪstack������ջΪhelp��
 *2����stack��ջ��Ԫ�ص�����ע��һ��Ҫ����������Ϊcur�����cur��helpջ��Ԫ��С����ֱ��ѹ�룻
 *����help��Ԫ��һһ����ֱ��cur <= help��ջ��Ԫ��
 *�������Ĵ���ṹΪ��
 *cur = stack����Ԫ��
 *while(cur > helpջ��Ԫ��){
 *   help����ջ��Ԫ�ز�ѹ��stack
 *} --->��֤ѭ������ʱΪcur <= help
 *helpѹ��cur -->����2���һ����
 *����������stack�б�������ɺ���Ҫ��help��Ԫ��"����"stack����ʵ�ֽ���
 *ע�⣺�߽�����isEmpty()�Ȳ�д����д����pop�ĵط�ʱ�ͻ���Ȼ��Ȼ������
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
