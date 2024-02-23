import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int target = sc.nextInt();
		
		System.out.println(findPath(target,0));
	}
	
	public static int findPath(int target, int depth) {
		if(target<=0)
			return -1;
		if(target==1)
			return 1;
		if(3*(depth * (depth-1))+1 < target && 3*(depth * (depth+1))+1 >= target)
			return depth+1;
		else{
			return findPath(target, depth+1);
		}
	}
}
