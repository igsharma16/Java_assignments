import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import utilities.ProvidePadding;

import java.sql.*;

public class Menu {
    ArrayList<Food> menu = new ArrayList<Food>();
    public Menu(Connection con) throws SQLException{
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from menu");

        while (rs.next()) {
            int fid = rs.getInt("fid");
            Food f = new Food(
                    rs.getString("fname"),
                    rs.getString("category"),
                    rs.getInt("price"),
                    fid);
            this.menu.add(f);
        }
    }
    
    public Food getFood(int fid) {
        for (Food food : this.menu) {
            if (food.fid == fid) {
                return food;
            }
        }
        return null;
    }

    public ArrayList<FoodOrder> takeOrder(Scanner sc) {
        ArrayList<FoodOrder> orders = new ArrayList<FoodOrder>();
        System.out.println("\nMake your selections:");
        System.out.println("Enter 0 for exit");
        System.out.println("You can select multiple items in one line (Enter Food Numbers seprated by space)");
        System.out.println("Not valid input will be  discarded");
        // String inputString = "";

        displayMenu();
        System.out.print("Enter here (0 for exit): ");
        String inpu = sc.nextLine();
        int sq = 0;
        inputLoop:
        while (!(inpu.equals("0"))) {
            StringTokenizer strTokenizer = new StringTokenizer(inpu);
            while (strTokenizer.hasMoreTokens()) {
                int foodid;
                String str = strTokenizer.nextToken();
                try {
                    foodid = Integer.parseInt(str);
                } catch (Exception e) {
                    System.out.println(str+" is not a valid number input");
                    continue;
                }
                if (foodid <= -1 || foodid > 15) {
                    System.out.println(str+" is not a valid input");
                    continue;
                }
                if (foodid == 0) {
                    break inputLoop;
                }
                ++sq;
                Food food = getFood(foodid);
                String quantityStr ;
                int quantity;
                System.out.print("Enter quantity for "+food.fname+": ");
                while (true) {
                    quantityStr = sc.nextLine();
                    try {
                        quantity = Integer.parseInt(quantityStr);
                        break;
                    } catch (Exception e) {
                        System.out.println("Enter valid quantiy for "+food.fname+": ");
                    }
                }
                orders.add(new FoodOrder(food, quantity, sq));
            }

            displayMenu();
            System.out.print("Enter here for selecting more items (0 for exit): ");
            inpu = sc.nextLine();
        }

        System.out.println("Your selections");
        // System.out.println(orders.toString());
        return orders;
    }
    public void displayMenu() {
        String header = ProvidePadding.paddBoth("No.", 10, ' ');
        header += ProvidePadding.paddLeft("Food", 30, ' ');
        header += ProvidePadding.paddBoth("Price", 20, ' ');
        for (int i = 0; i < this.menu.size(); ++i) {
            Food food = this.menu.get(i);
            int fid = food.fid;
            if (fid < 6) {
                if (fid == 1) {
                    System.out.println("\nNorth Indian: \n");
                    System.out.println(header + "\n");
                }
                System.out.println(food);
            } else if (fid < 11) {
                if (fid == 6) {
                    System.out.println("\nSouth Indian: \n");
                    System.out.println(header + "\n");
                }
                System.out.println(food);
            } else {
                if (fid == 11) {
                    System.out.println("\nChinese\n");
                    System.out.println(header + "\n");
                }
                System.out.println(food);
            }
        }
    }

}
