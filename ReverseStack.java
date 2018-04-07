import java.util.*;
/***
 * 
 * @author JTMSJBS
 * ʹ��һ��ջ��һ���ݹ麯��������һ��ջ
 * һ���ǳ���Ҫ�ĵ��ǣ�ջ��ÿһ��͵ݹ��ÿһ����һһ��Ӧ�ģ�һ���ݹ麯�����ڲ�����ʹ����˵ݹ��һ��
 * ����Ҫ��Ƶĵ�һ���ݹ麯���ǣ���ȡջ�ײ�Ԫ�صĺ�����
 * 1���߽��������ǵݹ����ײ㣬Ҳ��ջ����ײ㣬������Ҫ��Ԫ�������pop������ֱ�ӷ���
 * 2���Ǳ߽��������ǵݹ�/ջ�ĵײ����ϵĸ��㣬û��������Ҫ��Ԫ��,���Ԫ��pop������push��ȥ
 * ����˳����ʵ�����ԣ���ÿһ���ϵ�˳��Ϊpop->�ݹ�->push������pop->ջ->���أ��ײ��ʱ��
 * ��Ƶĵڶ����ݹ麯��Ҳ����
 * ��ջ��ÿһ���ϣ���ȡ����ǰ��ʱ�ײ��Ԫ�ز����ײ��Ƴ�������push��ջ����ˣ�˳��Ϊ��
 * getAndRemoveLastElement->�ݹ�->push������ջ����ջ��Ϊ3->2->1����ôÿ
 * һ���Ӧ�ĵײ�Ԫ��Ϊ1->2->3���ڵ�һ���ϣ���1push���ڶ����ϣ���2push....����֮
 * �����֮���Ƕ����ġ�
 * ���ο����ϵ�9ҳ��ͼ��⣩
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
		   //�߽�����
			return result;
		}else{
			//�ȵݹ��ٽ���ջ����
			//�з���ֵ�ĵݹ麯���ڷǱ߽������·����䱾��
			int last = getAndRemoveLastElement();
			stack.push(result);
			return last;
		}
		
	}
	
	public void reverse(){
		//�߽�����
		if(stack.isEmpty()){
			return;
		}else{	
			int item = getAndRemoveLastElement();
			//�ȵݹ��ڽ���ջ����
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
