import java.util.*;
/**
 * 
 * @author JTMSJBS
 * 生成窗口最大值数组，设数组大小为n，窗口大小为w
 * [4 3 5] 4 3 3 6 7
 * 4 [3 5 4] 3 3 6 7
 * 4 3 [5 4 3] 3 6 7
 * 4 3 5 [4 3 3] 6 7
 * 4 3 5 4 [3 3 6] 7
 * 4 3 5 4 3 [3 6 7]
 * 因此，窗口最大值数组为[5 5 5 4 6 7]
 * 一共产生了n-w+1个最大值（回忆一下卷积神经网络的卷积核大小）
 * 本题可以用O(n * W)的暴力求解法，但显然不是最优的，最优的方法是O(n)
 * 主要思路在于：使用一个双端队列qmax，遍历到数组的每一个位置时，使用该队列保存
 * 当前数组里的top N个数的下标（至少保存最大值的下表，可能保存多个次最大值的下标）
 * 遍历到arr[i]时，
 *		如果qmax为空，直接qmax.addLast(i)
 *		否则取出qmax队尾的下标j，如果arr[j]>arr[i]，qmax.addLast(i)；
 *		反之循环qmax.pop()直到arr[j] > arr[i]
 * 如果qmax队头下标等于i-w，说明qmax队头下标已经过期，弹出当前队头
 * 总之，任何时候，队头下标就是遍历到该时刻的最大值。
 * 直观理解：qmax总是有一个老大按级别依次带着一群小兵，老大一旦gg（出队）就由后面的
 * 小兵顶上，一旦有一个比老大更厉害的老大，那么老大和它的所有小兵就要被踢出队。
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
