import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int max = 0;
		Scanner sc = new Scanner(System.in);
		int drop = 0;
		int on = 0;
		
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			drop = sc.nextInt();
			on = sc.nextInt();
			sum += on - drop;
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}

}
