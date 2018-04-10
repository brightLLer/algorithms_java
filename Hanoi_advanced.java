/**
 * 
 * @author JTMSJBS
 * 汉诺塔问题变式：在原来问题的基础上，要求最左侧塔上的盘子不能直接到最右边，也不能直接到从最右边
 * 到最左边，换言之，这两种情况需要借助中间的盘子。
 * 边界条件：依然在n=1时，也就是塔上只有一个盘子，这一个盘子可能位于left，mid或者right位置
 * 的塔上，每个位置都可以分别向两个方向进发，比如，left->mid/right；mid->left/right；
 * right->mid/left，一共3*2=6种情况。讨论如下：
 * 1、如果将(仅剩的)一个盘子从left->mid，一步到达；right->mid，mid->left，mid->right同理
 * 2、如果将（仅剩的）一个盘子从left->right，需要分两步，首先是left->mid，然后是mid->right；
 * right->left也是同理
 * 非边界条件：此时盘子N>1，对盘子进行编号，从上往下为：1到N，移动情况依然是6种
 * 1、如果从left->mid，则将上面N-1个盘子从left->right（借助递归+mid作为暂存），然后最下面（编号
 * 为N）的盘子由left->mid（一步到位），然后再将N-1个盘子由right->mid（借助递归+left作为暂存）
 * 同理：
 * right->mid：right->left（1到N-1），right->mid（N），left->mid（1到N-1）
 * mid->left：mid->right，mid->left，right->left
 * mid->right：mid->left，mid->right，left->right（共3步）
 *2、如果left->right，是不是left->mid(1到N-1)，left->right(N)，mid->right呢？错误，第N
 *个盘子从left直接到right是不行的，因为单个盘子从左到右必须分为两步骤走，更改策略：
 *让上面的N-1个盘子从left->right（不是直接的，因为递归让我们无法直接看到中间的过程，递归内部借助了mid），
 *然后将第N个盘子从left->mid（一步到位），然后再将N-1个盘子从right->left，再将第N个盘子从mid->
 *right（一步到位），最后再将N-1个盘子从left回到right；
 *同理：
 *如果right->left：right->left(1到N-1)，right->mid（N），left->right（1到N-1），mid->left，
 *right->left（共5步）
 */

public class Hanoi_advanced{
	

	public static void move(String from, String to){

		if(from.equals("left") && to.equals("mid")){
			System.out.println("from left to mid");
		}
		else if(from.equals("left") && to.equals("right")){
			System.out.println("from left to mid");
			System.out.println("from mid to right");
		}
		else if(from.equals("mid") && to.equals("right")){
			System.out.println("from mid to right");
		}
		else if(from.equals("mid") && to.equals("left")){
			System.out.println("from mid to left");
		}
		else if (from.equals("right") && to.equals("mid")) {
			System.out.println("from right to mid");
		}else{
			System.out.println("from right to mid");
			System.out.println("from mid to left");
		}

	}

	public static void hanoiN(String from, String to, String left, String mid, String right, int n){
		if(n == 1){
			move(from, to);
		}
		//下面的所有判断条件中第三个参数-第四个参数也可以都统一写为left,mid,right
	    else if(from.equals(left) && to.equals(mid)){
			hanoiN(left, right, left, mid, right, n-1);
			move(left, mid);
			hanoiN(right, mid, right, left, mid, n-1);
		}else if(from.equals(left) && to.equals(right)){
			hanoiN(left, right, left, mid, right, n-1);
			move(left, mid);
			hanoiN(right, left, right, mid, left, n-1);
			move(mid, right);
			hanoiN(left, right, left, mid, right, n-1);
		}else if(from.equals(mid) && to.equals(right)){
			hanoiN(mid, left, mid, right, left, n-1);
			move(mid, right);
			hanoiN(left, right, left, mid, right, n-1);
		}else if(from.equals(mid) && to.equals(left)){
			hanoiN(mid, right, mid, left, right, n-1);
			move(mid, left);
			hanoiN(right, left, right, mid, left, n-1);
		}else if(from.equals(right) && to.equals(mid)){
			hanoiN(right, left, right, mid, left, n-1);
			move(right, mid);
			hanoiN(left, mid, left, right, mid, n-1);
		}else{	
			hanoiN(right, left, right, mid, left, n-1);
			move(right, mid);
			hanoiN(left, right, left, mid, right, n-1);
			move(mid, left);
			hanoiN(right, left, right, mid, left, n-1);
		}

	}

	public static void main(String[] args){
		
		hanoiN("left", "right", "left", "mid", "right", 2);
	}
}