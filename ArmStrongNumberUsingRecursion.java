import java.util.Scanner;

public class ArmStrongNumberUsingRecursion {
    public static int numOfDigits(int n)
	{
        if(n==0) return 0;
        return 1+numOfDigits(n/10);
	}
  
	public static int armStrong(int n,int power)
	{
        if(n==0) return 0;
        return(int) Math.pow(n%10,power)+armStrong(n/10,power);
	}
    
    public static void main(String[] args)
	{
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter which number you want to check: ");
        int num=sc.nextInt();
        int power=numOfDigits(num);
        if(num==armStrong(num,power))
            System.out.println(num+" is a armstrong num..");
        else
            System.out.println(num+" is not a armstrong num..");
        sc.close();
	}

}
