import java.util.Scanner;

class FibonacciSeries
{
	public static void main(String[] args)
    {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter number:");
            int n=sc.nextInt();
            int a=0;
            int b=1;
            System.out.print(a+" "+b);
            for(int i=1;i<=n;i++)
            {
                int c=a+b;
                System.out.print(" "+c);
                a=b;
                b=c;
            }
        }
    }
}
	