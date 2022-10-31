import java.util.Scanner;                                //QUICK  SORT
import java.util.ArrayList;                               //BY GULSHAN SHARMA (31 / OCT/ 2022)


public class Quick {
    public static void main(String[] args) {                                   // MAIN Function
        Inp a = new Inp();                                                   // Class to input values
        Sort b = new Sort();                                                // Class to sort 
        b.sort(a.get(), 0, a.get().size() - 1);                              // passing arrray to sort fn                       
    }   
}

class Inp{
    Scanner ip = new Scanner(System.in);
    ArrayList<Integer> a1 = new ArrayList<Integer>();
    public Inp(){
        System.out.println("Enter the number of elements of list:");
        int num = ip.nextInt();
        System.out.println("Enter " + num + " elements of the list");                   //Input elements
        for(int i = 0 ; i < num ; i++){
            a1.add(ip.nextInt());
        }
    }

    void display(){
        System.out.println("The list is :");
        for(int i : a1){                                                    // Display method
            System.out.print("  " + i);
        }
    }

    public ArrayList<Integer> get(){
        return a1;                                                                // return array to pass
    }                                                                              // to sort fn
}


class Sort{
    
    public void sort(ArrayList<Integer> a1 , int l , int r){
        if(l < r){
            
            int mid = partition(a1, l, r);                                                  // Sort method
            sort(a1, l, mid - 1);
            sort(a1, mid + 1 , r);
        }
    }

    public int partition(ArrayList<Integer> a1 , int l , int r){
        
            int i = l - 1 , j  , p = a1.get(r);
            for(j = l ; j < r ; j++ ){
                if(a1.get(j) >= p){

                }
                else if(a1.get(j) < p){ 
                    i++;
                    int temp = a1.get(i);
                    a1.set(i , a1.get(j));                      // Partiion method
                    a1.set(j , temp);
                }
            }
            int t = a1.get(i + 1);
            a1.set(i + 1 , p);
            a1.set(r , t);
            return i + 1;

    }
}

// partiion method divided the array into 2 parts recursively and placed the pivot element at the 
// right position such that all smaller element are left to it. and right to exist all the bigger elements
// the logic behind this is that i variable always point to such position that all elements right to it
// are bigger w.r.t pivot. if by using any variable we find the smaller element than pivot. the i + 1 element
// will be emptied and that will be placed there and the bigger element at that position will be transferred
// furthur back to the positon at j. As i has been incremented to i + 1 where new number has been placed
//, the numbers right to it wil be greater than pivot.
// At last i + 1 element will be replaced by pivot such that it will be at its correct positon.
// then sort is applied on the right half as well as to the right half.
