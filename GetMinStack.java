import java.util.*;

/***
 * 
 * @author JTMSJBS
 * 
 * ���ȣ���ȷ�������ݽṹ��һ�������ܵõ���СԪ�ع��ܵ�ջ�����������Ҫ���¶�������ջ��ѹ��͵�������
 * ������������ջstackData��stackMin��ʵ����һ�������ջ
 * 1��ѹ�����
 * ����ǰԪ��newNumѹ��ջ��ʱ���Ƚ�newNumѹ��stackData��Ȼ���ж�stackMin�Ƿ�Ϊ�գ���Ϊ�գ���newNumͬ��ѹ�룬����Ϊ�գ���newNum��
 * stackMin��ջ��Ԫ��top�Ƚϣ���newNum <= top����newNumͬ��ѹ�룬����stackMin����ԭ����������֮��stackMin��ջ��ά��stackData
 * �е���СԪ�أ�
 * 2����������
 * ���Ƚ�stackData��ջ��Ԫ�ص�������¼Ϊvalue�����stackMin��ջ��Ԫ��Ϊtop����ôvalue >= top�Ǻ�����ģ����ֻҪ�жϣ����value==top��
 * ��stackMin��ջ��Ԫ��topҲ����������value > top��stackMin����Ҫ�����κ�Ԫ�ء�
 * 3����ȡ��СԪ�صĹ���
 * ֻҪ����stackMin��ջ��Ԫ�ؼ���
 * 
 * 3�������Ĺ��ܶ���O(1)
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
