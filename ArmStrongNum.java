import java.util.Scanner;
public class ArmStrongNum
{
	public static void main(String[] args)
	{
        Scanner s=new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n=s.nextInt();
        if(isArmStrong(n))
            System.out.println(n+" is Armstrong number");
        else
            System.out.println(n+" is not an Armstrong number");
        s.close();
	}

	public static int countDigits(int n)
	{
        int count=0;
        while(n>0)
        {
            count++;
            n/=10;
        }
        return count;
    }
        
    public static int power(int base,int pow)
    {
        int prod=1;
        for(int i=1;i<=pow;i++)
        {
            prod*=base;
        }
        return prod;
    }

    public static boolean isArmStrong(int n)
    {
        if(n<=9)
            return true;
        int num=n;
        int p=countDigits(n);
        int sum=0;
        while(n>0)
        {
            int x=n%10;
            sum+=power(x,p);
            n/=10;
	    }
	    return sum==num;
	}
}

