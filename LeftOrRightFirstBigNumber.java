import java.util.*;
import java.util.Map.Entry;

/***
 * 
 * @author JTMSJBS
 * Ѱ��������ÿ��Ԫ�����/�ұߵ�һ���ȸ�Ԫ�ش����
 * ��һ���ݼ�ջ��һ����ϣ�������Ϊ����
 * ���������е�ÿ��Ԫ�أ���ջΪ��ʱ��Ԫ��ѹ��ջ�У���Ϊ����Ԫ����ջ��Ԫ�رȽϣ�����popֱ��ջ��Ԫ�ش��ڵ�ǰ����
 * Ԫ��Ϊֹ��ע����pop����ͬʱ��¼pop����Ԫ����pop��ջ����Ԫ����Ϊ��ֵ�Խ����ϣ�����Ƿֱ���ǵ�ǰ������Ԫ��
 * ����ߵ�һ���������Ԫ��
 * ��ɱ���֮��ջ�ڿ϶�����Ԫ�أ�ȫ���������С�����ϣ��
 */

public class LeftOrRightFirstBigNumber {

	//����Ԫ��û���ظ�
	public static HashMap<Integer, Integer> getFirstBigNumber(int[] arr, String type){
		
		HashMap<Integer, Integer> bigMap = new HashMap<Integer, Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		if(type == "left"){
			for(int i = 0; i != arr.length; ++i){
				int curVal = arr[i];
				while(!stack.isEmpty() && stack.peek() < curVal){
					stack2Map(stack, bigMap);
				}
				//ѭ����ת��ʱ��
				//���1��ջΪ��stack.isEmpty()
				//���2��ջ��Ԫ�� > ��������ĵ�ǰԪ��
				//ȷ��ջ�е���ʼ�ձ��ֽ���
				stack.push(curVal);
			}
			//��һ��ѭ������ʱstack�϶���Ϊ�գ���Ϊ����и�stack.push()��Ҳ����������һ������ջ��
			while(!stack.isEmpty()){
				stack2Map(stack, bigMap);
			}
		}else{
			for(int i = arr.length - 1; i != -1; --i){
				System.out.println(arr[i]);
				int curVal = arr[i];
				while(!stack.isEmpty() && stack.peek() < curVal){
					stack2Map(stack, bigMap);
				}
				stack.push(curVal);
			}
			while(!stack.isEmpty()){
				stack2Map(stack, bigMap);
			}
		}
		return bigMap;
	}
	
	public static void stack2Map(Stack<Integer> stack, HashMap<Integer, Integer> bigMap){
		int key = stack.pop();
		if(stack.isEmpty()){
			bigMap.put(key, null);
		}else{
			bigMap.put(key, stack.peek());
		}
	}
	
	public static void main(String[] args){
		int[] arr = {3, 4, 5, 1, 2};
		HashMap<Integer, Integer> bigMap = getFirstBigNumber(arr, "left");
		for(Entry<Integer, Integer> entry: bigMap.entrySet()){
			 System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}
