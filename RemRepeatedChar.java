import java.util.Scanner;
public class RemRepeatedChar {
	public static void main(String[] args) {
		System.out.println("Enter a String: ");
		String s=new Scanner(System.in).next();
		
		for(int i=0;i<s.length();i++) {
			int j=i+1;
			while(j<s.length()) {
				char c1=s.charAt(i);
				char c2=s.charAt(j);
				if(c1!=c2)	j++;
				else	s=s.replace(c1+"", "");
			}	
		}
		System.out.println(s);
	}
}