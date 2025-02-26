
import java.util.Scanner;

public class PrimeNum{
    public static void main (String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num=sc.nextInt();
        if(isPrime(num))
            System.out.println(num+" is a Prime Number");
        else
            System.out.println(num+" is not a Prime Number");
    }
    public static boolean isPrime(int n){
        if(n<=1) return false;
        boolean flag=true;
        for(int i=2;i<=n/2;i++){
            if(n%i==0)  flag=false;
        }
        return flag;
    }
}