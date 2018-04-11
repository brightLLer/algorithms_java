import java.util.*;
/**
 * 
 * @author JTMSJBS
 * ���ɴ������ֵ���飬�������СΪn�����ڴ�СΪw
 * [4 3 5] 4 3 3 6 7
 * 4 [3 5 4] 3 3 6 7
 * 4 3 [5 4 3] 3 6 7
 * 4 3 5 [4 3 3] 6 7
 * 4 3 5 4 [3 3 6] 7
 * 4 3 5 4 3 [3 6 7]
 * ��ˣ��������ֵ����Ϊ[5 5 5 4 6 7]
 * һ��������n-w+1�����ֵ������һ�¾��������ľ���˴�С��
 * ���������O(n * W)�ı�����ⷨ������Ȼ�������ŵģ����ŵķ�����O(n)
 * ��Ҫ˼·���ڣ�ʹ��һ��˫�˶���qmax�������������ÿһ��λ��ʱ��ʹ�øö��б���
 * ��ǰ�������top N�������±꣨���ٱ������ֵ���±����ܱ����������ֵ���±꣩
 * ������arr[i]ʱ��
 *		���qmaxΪ�գ�ֱ��qmax.addLast(i)
 *		����ȡ��qmax��β���±�j�����arr[j]>arr[i]��qmax.addLast(i)��
 *		��֮ѭ��qmax.pop()ֱ��arr[j] > arr[i]
 * ���qmax��ͷ�±����i-w��˵��qmax��ͷ�±��Ѿ����ڣ�������ǰ��ͷ
 * ��֮���κ�ʱ�򣬶�ͷ�±���Ǳ�������ʱ�̵����ֵ��
 * ֱ����⣺qmax������һ���ϴ󰴼������δ���һȺС�����ϴ�һ��gg�����ӣ����ɺ����
 * С�����ϣ�һ����һ�����ϴ���������ϴ���ô�ϴ����������С����Ҫ���߳��ӡ�
 * 
 */

public class MaxWindowArray {
	
	public LinkedList<Integer> qmax;
	public int[] array;
	
	public MaxWindowArray(int[] array){
		qmax = new LinkedList<Integer>();
		this.array = array;
	}
	
	public int[] getMaxWindowArray(int w){
		
		int[] maxWindowArr = new int[this.array.length - w + 1];
		int cnt = 0;
		
		for(int i = 0; i < array.length; ++i){
			
			if(qmax.isEmpty()){
				qmax.push(i);
			}else{
				int j = qmax.peekLast();
				while(array[j] <= array[i]){
					qmax.pollLast();
					if(!qmax.isEmpty())
						j = qmax.peekLast();
					else
						break;
				}
				qmax.addLast(i);
			}
			if(i >= w - 1){
				if(i - w == qmax.peekFirst())
					qmax.pollFirst();
				maxWindowArr[cnt ++] = array[qmax.peekFirst()];
			}
			
		}
		return maxWindowArr;
		
	}
	
	public static void main(String[] args){
		
		int[] array = {4, 3, 5, 4, 3, 3, 6, 7};
 		MaxWindowArray maxWindowArray = new MaxWindowArray(array);
 		int[] maxWinArr = maxWindowArray.getMaxWindowArray(3);
 		for(int i = 0; i < maxWinArr.length; ++i){
 			System.out.println(maxWinArr[i]);
 		}
		
	}

}
