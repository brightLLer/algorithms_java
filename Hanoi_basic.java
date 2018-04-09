/**
 * 
 * @author JTMSJBS
 *汉诺塔问题描述：一个大铜盘上插着三根针，记为A，B，C（左中右），A上有N个盘子，并且
 *从上往下盘子的大小依次增大，现在我们需要将A上的N个盘子全部移动到C上（可以借助B作为
 *暂存区，每次只能动一个盘子且只能动最上面那个），打印其中的步骤，并且这个过程中依然要
 *保持盘子的大小依旧由上到下增大。
 *汉诺塔（及其变式问题）的思路都是一样的：
 *1、边界条件：塔上只有一个盘子（N=1），直接移动
 *2、非边界条件：塔上的盘子大于1个（N>1），借助递归和暂存的盘子
 *那么，显然，A上的盘子全部移动到C，只需要下面三步（如果从上到下A上的盘子编号记为1-N）：
 *1、A上面的N-1个盘子移动到B（非边界：交给递归+暂存盘C）
 *2、A最下面的第N个盘子直接移动到C（边界）
 *3、B上的N-1个盘子移动到C（非边界：交给递归+暂存盘A）
 *（脑内浮现上面3个步骤的图试试会更加清晰）
 */
public class Hanoi_basic {

	public static void move(String A, String C){
		System.out.println(A + "---->" + C);
	}
	
	//A借助B移动到了C
	public static void hanoiN(String A, String B, String C, int n){
		
		if(n == 1)
			move(A, C);
		else{
			hanoiN(A, C, B, n-1);
			move(A, C);
			hanoiN(B, A, C, n-1);
		}
	}
	
	public static void main(String[] args){
		hanoiN("A", "B", "C", 3);
	}
}
