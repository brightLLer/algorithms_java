import java.util.*;
import java.util.Map.Entry;

/***
 * 
 * @author JTMSJBS
 * 寻找数组中每个元素左边/右边第一个比该元素大的数
 * 用一个递减栈和一个哈希表，以左边为例子
 * 遍历数组中的每个元素，当栈为空时将元素压入栈中，不为空则将元素与栈顶元素比较，不断pop直到栈顶元素大于当前遍历
 * 元素为止，注意在pop出的同时记录pop出的元素与pop后栈顶的元素作为键值对进入哈希表，它们分别就是当前遍历的元素
 * 与左边第一个比它大的元素
 * 完成遍历之后，栈内肯定还有元素，全部按左大右小加入哈希表
 */

public class LeftOrRightFirstBigNumber {

	//数组元素没有重复
	public static HashMap<Integer, Integer> getFirstBigNumber(int[] arr, String type){
		
		HashMap<Integer, Integer> bigMap = new HashMap<Integer, Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		if(type == "left"){
			for(int i = 0; i != arr.length; ++i){
				int curVal = arr[i];
				while(!stack.isEmpty() && stack.peek() < curVal){
					stack2Map(stack, bigMap);
				}
				//循环跳转出时刻
				//情况1：栈为空stack.isEmpty()
				//情况2：栈顶元素 > 数组遍历的当前元素
				//确保栈中的数始终保持降序
				stack.push(curVal);
			}
			//上一个循环跳出时stack肯定不为空，因为最后有个stack.push()，也就是至少有一个还在栈里
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
