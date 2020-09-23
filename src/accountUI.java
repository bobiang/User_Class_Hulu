import java.util.Scanner;

public class accountUI {
	
	public static void main(String[] args) {
		HuluClassUser user=new HuluClassUser();
		Scanner scanner=new Scanner(System.in);
		System.out.println("username:");
		String temp=scanner.nextLine();
		user.setEmail(temp);
		System.out.println("password");
		temp=scanner.nextLine();
		user.setPassword(temp);
	}
}
