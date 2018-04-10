import java.util.*;


/**
 * 
 * @author JTMSJBS
 * ��Ȼ�Ǻ�ŵ����ʽ�㷨�����ʹ�÷ǵݹ�汾����Ҫ˼·���£�
 * 3�������Կ���3��ջ���ƶ��Ķ�����ʵֻ����left->mid��right->mid��mid->left�Լ�mid->right
 * ���ĸ�����������������ԭ��
 * 1��ֻ��Сѹ��
 * 2�����ڶ��������棬����ǰһ����L->M����һ����������M->L����ϸ������ô���ܰ�����ְ��ȥ��
 * ���⣬����1����Ȼ��ʵ�ǣ���һ��ֻ����left->mid
 * ��ˣ�������2��ԭ��ֱ�����ĸ����������жϣ����Եó���һ������
 * ���磺��һ������ΪL->M����¼��һ������������һ����������ʾ��
 * ����ԭ��1����һ��������������L->M
 * ����ԭ��2����һ��������������M->L
 * ����ԭ��1����һ������ֻ����M->R��R->M�е�����һ��
 * �����������̣�ֱ����ߺ��м��ջ��Ϊ��Ϊֹ��ѭ������ʱΪlStack.isEmpty() && mStack.isEmpty()��
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
					��̼��ɣ���Ҫ����������ж���������д˼·�����ᵽ��Сѹ��ԭ��Ҳ�����ڲ��
					if(mStack.peek() < rStack.peek())��Ȼ����������peek����Ȼ
					�������油���ж�if(!mStack.isEmpty() && !rStack.isEmpty())��
					���������if֮����Ȼ�ͻῼ�ǺͲ���else if��else�ȷ�֧�ж������ˡ�
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
