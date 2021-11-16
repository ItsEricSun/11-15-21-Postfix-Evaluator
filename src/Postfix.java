import java.util.Scanner;

public class Postfix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    System.out.println("Enter Postfix Expression (One space between every number and operation):");
	    String ex = sc.nextLine();
	    PostfixEvaluator pe = new PostfixEvaluator();
	    double result = 0;
	    try {
			result = pe.evaluate(ex);
		    System.out.println(result);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
