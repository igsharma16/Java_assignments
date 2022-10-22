// By Gulshan Sharma 

import java.util.Scanner;
public class Matrix{
    public static void main(String[] args){
        Create mat1 = new Create();
        Create mat2 = new Create();                                         // Create 2 matrix
        Add two = new Add(mat1, mat2);
        mat1.display(two.get());
    }
}

class Create{
    Scanner ip = new Scanner(System.in);
    private int[][] mat;
     int r , c;
    public Create(){
    System.out.println("Create Matrix");
    System.out.println("Enter rows and columns of the matrix:");            // Create Class
     r = ip.nextInt();
     c = ip.nextInt();
    mat = new int[r][c];
    inp();
    }

    void display(){
        System.out.println("The matrix formed is:");
        for(int z = 0 ; z < r; z ++){
            for(int b = 0 ; b < c ; z ++){
                System.out.println("   " + mat[z][b]+ "  ");        //Display created matrix
            }
            System.out.println();
        }
    }
    void display(int[][] mat3){
        System.out.println("The matrix formed after addition is:");
        for(int z = 0 ; z < r; z ++){
            for(int b = 0 ; b < c ; b ++){
                System.out.print("   " + mat3[z][b]+ "  ");                 // Display added matrix
            }                                                                // use of polymorphism and passing values
            System.out.println();
        }
    }

    private void inp(){
        System.out.println("Enter data of the matrix row wise");
        for(int z = 0 ; z < r ; z ++){                                                  //input to the matrix
            for(int q = 0 ; q < c ; q ++){
                mat[z][q] = ip.nextInt();
            }
        }
    }

    public int[][] get(){
        return mat;                                                                 // To transfer matrix to another class
    }
}

class Add{
    int[][] mat3;
    public Add(Create mat1 , Create mat2){

        
        if(mat1.r != mat2.r || mat1.c != mat2.c){
            System.out.println("These matix are not of same order");
            return;
        }
        int[][] a= mat1.get();
        int[][] b = mat2.get();
        mat3 = new int[mat1.r][mat1.c];
        for(int p = 0 ; p < mat1.r; p++){
            for(int z = 0 ; z < mat2.c; z++){                                           //Subtraction in const.
                mat3[p][z] = a[p][z]  - b[p][z];
            }
        }
    }
    public int[][] get(){
        return mat3;                                                                  //Returning matrix to display 
    }
    
}
