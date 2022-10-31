import java.util.Scanner;;
public class code{
    public static void main(String[] args){
        Scanner ip = new Scanner(System.in);
        System.out.println("Enter any character:");
        char p = ip.next().charAt(0);
        System.out.println("The ASCII Value of " + p + " will be :");
        int z = p;
        System.out.print(z);
    }
}