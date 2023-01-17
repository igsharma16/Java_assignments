import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;
import utilities.ProvidePadding;

public class Customer {
    public String name ;
    public String phone ;

    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String toString() {
        String str = ProvidePadding.paddBoth(this.name, 25, ' ');
        str += ProvidePadding.paddRight(this.phone, 15, ' ');
        return str;
    }

    static void displayAllCustomers(ArrayList<Customer> customers) {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    static void displayAllCustomers(Connection con) {
        ArrayList<Customer> customers = getCustomers(con);
        displayAllCustomers(customers);
    }

    static ArrayList<Customer> getCustomers(Connection con) {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        String query = "select * from customer";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Customer cus = new Customer(rs.getString("name"), rs.getString("phone"));
                customers.add(cus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }

    static public boolean addCustomer(Connection con, String name, String phone) throws SQLException {
        boolean flag = false ;
        Customer cus = new Customer(name, phone);
        String query = "insert into customer (name, phone) values (?,?)";
        PreparedStatement psmt = con.prepareStatement(query);
        try {
            psmt.setString(1,cus.name);
            psmt.setString(2, cus.phone);
            psmt.executeUpdate();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    static public boolean addCustomer(Connection con, Customer cus) throws SQLException {
        boolean flag = false ;
        String query = "insert into customer (name, phone) values (?,?)";
        PreparedStatement psmt = con.prepareStatement(query);
        try {
            psmt.setString(1,cus.name);
            psmt.setString(2, cus.phone);
            psmt.executeUpdate();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag; 
    }

    static public boolean addCustomer(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Name of customer for adding: ");
        String name = sc.next();
        System.out.print("Enter phone number of customer for adding: ");
        String phone = sc.next();
        boolean flag = false ;
        Customer cus = new Customer(name, phone);
        String query = "insert into customer (name, phone) values (?,?)";
        PreparedStatement psmt = con.prepareStatement(query);
        try {
            psmt.setString(1,cus.name);
            psmt.setString(2, cus.phone);
            psmt.executeUpdate();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

}
