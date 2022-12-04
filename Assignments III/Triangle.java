public class Circle{
    public static void main(String[] args){
        System.out.println("This is a Triangle program");
    for(int i = 1 ; i < 10 ; i++)        {
        for(int j = 10  - i ; j> 0 ; j--){
            System.out.print(" ");
            if(j == 9)System.out.print(" ");
        }
        System.out.print("*");
        if(i != 1){
            for(int j = 1 ; j < 2 * i; j++ ){
                System.out.print(" ");
            }
            System.out.print("*");
        }
        System.out.println();
    }
for(int i = 0 ; i < 10 ;i++){
    System.out.print(" *");
}
    }
}