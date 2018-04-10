
public class Hanoi_advancedV2 {
	
	public static int move(String from, String to){
		
		if(from.equals("mid") || to.equals("mid")){
			System.out.println("move from " + from + " to " + to);
			return 1; //返回1步;
		}else{
			System.out.println("move from " + from + " to mid");
			System.out.println("move from mid to "+ to);
			return 2; //返回2步;
		}
		
	}
	
	public static int hanoiN(String from, String to, String left, String mid, String right, int n){
		
		if(n == 1){
			return move(from, to);
		}
		else if(from.equals(mid) || to.equals(mid)){
			String buffer = from.equals(right) || left.equals(right) ? left : right;
//			hanoiN(from, buffer, from, to, buffer, n - 1);
//			move(from, to);
//			hanoiN(buffer, to, buffer, from, to, n - 1);
			int part1 = hanoiN(from, buffer, left, mid, right, n - 1);
			int part2 = move(from, to);
			int part3 = hanoiN(buffer, to, left, mid, right, n - 1);
			return part1 + part2 + part3;
		}else{
//			hanoiN(from, to, from, mid, to, n - 1);
//			move(from, mid);
//			hanoiN(to, from, to, mid, from, n - 1);
//			move(mid, to);
//			hanoiN(from, to, from, mid, to, n - 1);
			int part1 = hanoiN(from, to, left, mid, right, n - 1);
			int part2 = move(from, mid);
			int part3 = hanoiN(to, from, left, mid, right, n - 1);
			int part4 = move(mid, to);
			int part5 = hanoiN(from, to, left, mid, right, n - 1);
			return part1 + part2 + part3 + part4 + part5;
		}
	}
	
	public static void main(String[] args){
		
		int steps = hanoiN("left", "right", "left", "mid", "right", 2);
		System.out.println("total steps: " + steps);
		
	}

}
