import java.util.*;

/***
 * 
 * @author JTMSJBS
 * ��һ�汾���㷨����һ�汾����һЩ΢С�ĸĶ�
 * 1��ѹ�����
 * ���newNum��stackMin��ջ��Ԫ��С����newNumѹ��stackMin������
 * ��stackMin��ջ��Ԫ�����ظ�ѹ��stackMinһ�Ρ�
 * 2����������
 * stackData������Ԫ�ؼ�Ϊvalue��stackMinҲͬ������ջ��Ԫ�أ����Ѿ�����
 * Ҫ�Ƚ���
 * 3����ȡ��СԪ�أ�
 * ����stackMin��ջ��Ԫ��
 * ����֮�������㷨����Ҫ˼·�ǣ�һ������Ԫ��ѹ��stackData���ͼ�Ϊһ����stackMin
 * �����þ��Ǽ�¼��ÿһ��֮���stackData����Сֵ����������ʱ�൱��һ����stackMin
 * ��һ��"����"�����á�
 * 3��������ʱ�临����ȻΪO(1)���ռ临�Ӷ�ΪO(n)
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
