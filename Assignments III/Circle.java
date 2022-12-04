import javax.swing.plaf.synth.SynthStyleFactory;

public class Circle{
    public static void main(String[] args){
        System.out.println("This is a Circle program");
        for(int i = 0 ; i< 5 ; i++){
            for(int j = 5 - i ; j > 0 ;j--){
                System.out.print("  ");
            }
            System.out.print("*");
            for(int j = 0 ; j < 2 * i ; j ++){
                System.out.print("  ");
            }
            System.out.println("*");
        }
        for(int i = 0 ; i < 5 ; i++){
            for(int j = 0 ; j < i ; j++){
                System.out.print("  ");
            }
            System.out.print("*");
            for(int j = 10 - 2* i ; j > 0 ; j--){
                System.out.print("  ");
            }
            System.out.println("*");
        }
    }
}