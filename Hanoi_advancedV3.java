import java.util.*;


/**
 * 
 * @author JTMSJBS
 * 仍然是汉诺塔变式算法，这次使用非递归版本，主要思路如下：
 * 3个塔可以看成3个栈，移动的动作其实只包括left->mid，right->mid，mid->left以及mid->right
 * 这四个动作满足如下两个原则：
 * 1、只能小压大
 * 2、相邻动作不可逆，比如前一步是L->M，这一步不可能是M->L，仔细想想怎么可能搬过来又搬回去呢
 * 另外，还有1个必然事实是，第一步只能是left->mid
 * 因此，依据这2个原则分别对这四个动作进行判断，可以得出下一个动作
 * 例如：上一个动作为L->M（记录上一个动作可以用一个变量来表示）
 * 根据原则1，下一个动作不可能是L->M
 * 根据原则2，下一个动作不可能是M->L
 * 根据原则1，下一个动作只可能M->R和R->M中的其中一个
 * 遍历上述过程，直到左边和中间的栈均为空为止（循环结束时为lStack.isEmpty() && mStack.isEmpty()）
 */

public class Hanoi_advancedV3 {

	private Stack<Integer> lStack;
	private Stack<Integer> mStack;
	private Stack<Integer> rStack;
	
	
	public Hanoi_advancedV3(int n) {
		lStack = new Stack<Integer>();
		mStack = new Stack<Integer>();
		rStack = new Stack<Integer>();
		for(int item = n; item >= 1; item --){
			lStack.push(item);
		}
	}
	
	
	public void move(){
		
		int flag = 1;
		mStack.push(lStack.pop());
		System.out.println("L->M");
		 
		while(!lStack.isEmpty() || !mStack.isEmpty()){
			switch (flag) {
			case 1:
			case 2:
				/*
					编程技巧：不要在意最外层判断条件，先写思路里面提到的小压大原则，也就是内层的
					if(mStack.peek() < rStack.peek())，然后发现有两个peek，自然
					会在外面补上判断if(!mStack.isEmpty() && !rStack.isEmpty())，
					补充了这个if之后自然就会考虑和补充else if和else等分支判断条件了。
				*/
				if(!mStack.isEmpty() && !rStack.isEmpty()){
					if(mStack.peek() < rStack.peek()){
					    rStack.push(mStack.pop());
					    flag = 3;
					    System.out.println("M->R");
					}else{
						mStack.push(rStack.pop());
						flag = 4;
						System.out.println("R->M");
					}
				}else if(mStack.isEmpty()){
					mStack.push(rStack.pop());
					flag = 4;
					System.out.println("R->M");
				}else{
					rStack.push(mStack.pop());
					flag = 3;
					System.out.println("M->R");
				}
				break;
			case 3:
			case 4:
				if(!mStack.isEmpty() && !lStack.isEmpty()){
					if(mStack.peek() < lStack.peek()){
						lStack.push(mStack.pop());
						flag = 2;
						System.out.println("M->L");
					}else{
						mStack.push(lStack.pop());
						flag = 1;
						System.out.println("L->M");
					}
				}else if(mStack.isEmpty()){
					mStack.push(lStack.pop());
					flag = 1;
					System.out.println("L->M");
				}else{
					lStack.push(mStack.pop());
					flag = 2;
					System.out.println("M->L");
				}
				break;
			}	
		}
		
	}
	
	public static void main(String[] args){
		Hanoi_advancedV3 hanoi_advancedV3 = new Hanoi_advancedV3(2);
		hanoi_advancedV3.move();
	}
}
