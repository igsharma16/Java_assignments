import java.util.Scanner;
import java.util.ArrayList;
public class left_java {
    public static void main(String[] args){
        Rotate arr = new Rotate();
    }
}
class Rotate{
    Scanner ip = new Scanner(System.in);
    ArrayList<Integer> num = new ArrayList<Integer>();
    public Rotate(){
        System.out.println("Enter the number of elements to be added in array:\t");
        int k = ip.nextInt();
        System.out.println("Enter " + k + " elements of the array:");
        for(int i = 0 ; i < k ; i++){
            int z = ip.nextInt();
            num.add(z);
        }
        display();
    }
    void display(){
        System.out.println("The elements of the array are:\t");
        System.out.println(num);
        left_r();
    }
    void left_r(){
        int z = num.get(0);
        for(int i = 0 ; i < num.size() - 1; i++){
            num.set(i , num.get(i + 1));
        }
        num.set(num.size() - 1 , z);
        System.out.println("This left rotated array will be :\t");
        System.out.println(num);
    }
}
//By Gulshan Sharma