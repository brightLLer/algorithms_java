/**
 * 
 * @author JTMSJBS
 * ��ŵ�������ʽ����ԭ������Ļ����ϣ�Ҫ����������ϵ����Ӳ���ֱ�ӵ����ұߣ�Ҳ����ֱ�ӵ������ұ�
 * ������ߣ�����֮�������������Ҫ�����м�����ӡ�
 * �߽���������Ȼ��n=1ʱ��Ҳ��������ֻ��һ�����ӣ���һ�����ӿ���λ��left��mid����rightλ��
 * �����ϣ�ÿ��λ�ö����Էֱ�������������������磬left->mid/right��mid->left/right��
 * right->mid/left��һ��3*2=6��������������£�
 * 1�������(��ʣ��)һ�����Ӵ�left->mid��һ�����right->mid��mid->left��mid->rightͬ��
 * 2�����������ʣ�ģ�һ�����Ӵ�left->right����Ҫ��������������left->mid��Ȼ����mid->right��
 * right->leftҲ��ͬ��
 * �Ǳ߽���������ʱ����N>1�������ӽ��б�ţ���������Ϊ��1��N���ƶ������Ȼ��6��
 * 1�������left->mid��������N-1�����Ӵ�left->right�������ݹ�+mid��Ϊ�ݴ棩��Ȼ�������棨���
 * ΪN����������left->mid��һ����λ����Ȼ���ٽ�N-1��������right->mid�������ݹ�+left��Ϊ�ݴ棩
 * ͬ��
 * right->mid��right->left��1��N-1����right->mid��N����left->mid��1��N-1��
 * mid->left��mid->right��mid->left��right->left
 * mid->right��mid->left��mid->right��left->right����3����
 *2�����left->right���ǲ���left->mid(1��N-1)��left->right(N)��mid->right�أ����󣬵�N
 *�����Ӵ�leftֱ�ӵ�right�ǲ��еģ���Ϊ�������Ӵ����ұ����Ϊ�������ߣ����Ĳ��ԣ�
 *�������N-1�����Ӵ�left->right������ֱ�ӵģ���Ϊ�ݹ��������޷�ֱ�ӿ����м�Ĺ��̣��ݹ��ڲ�������mid����
 *Ȼ�󽫵�N�����Ӵ�left->mid��һ����λ����Ȼ���ٽ�N-1�����Ӵ�right->left���ٽ���N�����Ӵ�mid->
 *right��һ����λ��������ٽ�N-1�����Ӵ�left�ص�right��
 *ͬ��
 *���right->left��right->left(1��N-1)��right->mid��N����left->right��1��N-1����mid->left��
 *right->left����5����
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
		//����������ж������е���������-���ĸ�����Ҳ���Զ�ͳһдΪleft,mid,right
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