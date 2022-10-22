import java.util.Scanner;
public class Matrix {
    public static void main(String[] args){
        System.out.println("This is a program to create matrix of any order:");
        Scanner ip = new Scanner(System.in);
        System.out.println("Enter rows of matrix");
        int r = ip.nextInt();
        System.out.println("Enter columns of the matrix:");
        int c = ip.nextInt();
        System.out.println("Enter " + r * c + " elements of the matrix row wise:");
        int[] mat = new int[r* c];
        for(int i = 0 ; i < r * c ; i++){
            mat[i] = ip.nextInt();
        }
    System.out.println("The matrix is :");
        for(int j = 0 ; j < r ; j++){
            for(int k = 0 ; k < c ; k ++){
                System.out.print(mat[j + k] + "    ");
            }
            System.out.println();
        }
        
    }
}
// Matrix Program using one dimensional array