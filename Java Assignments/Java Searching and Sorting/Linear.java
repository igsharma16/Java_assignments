import java.util.ArrayList;
import java.util.Scanner;
class Inp{
     ArrayList<Integer> a1 = new ArrayList<Integer>();
     Scanner ip = new Scanner(System.in);
     public Inp(){
            
            System.out.println("Enter the number of elements to be added in array:");
            int num = ip.nextInt();
            
            for(int i = 0 ; i < num ; i++){
                a1.add(ip.nextInt());
            }
        }
        void display(){
            System.out.println("The array elements given are:");
            for(int i : a1){
                System.out.print(i + "  ");
            }
        }
        
        void Search(){
            System.out.println();
            System.out.print("Enter the number to be searched:");
            int k = ip.nextInt();
            for(int i = 0; i < a1.size(); i++ ){
                if(a1.get(i) == k){
                    System.out.println("The item is present in the list at inxex number:    " + i);
                    return;
                }
                
            }
            System.out.println("This item is not present in the list");
        }
    
}


public class Linear {
    public static void main(String[] args){
        Inp lin = new Inp();
        lin.display();
        lin.Search();
    }
}
