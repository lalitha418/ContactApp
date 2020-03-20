import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Validation {
	public String num;
	public String email;
	static Scanner scanner = new Scanner(System.in);

	public static  boolean validNum(String phone) {
		int length = 0;
			if ((Pattern.matches("[0-9]+", phone) == true) && (phone.length() == 10)) {
				return true;

			}
			System.out.println("\n output:false");
			return false;
			
		}



	public static boolean validEmail(String emaill)
	{
		
				 String format = "\\w+@\\w+\\.\\w+";
		 Pattern pattern = Pattern.compile(format);
		 Matcher matche = pattern.matcher(emaill);
		
			if (matche.matches()) 
			{
								return true;
			}
			return false;
			}
}
