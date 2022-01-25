package intervale.dz3.springbookdemo.controller;

import java.math.BigDecimal;
import java.sql.*;

public class Connect {
    public static void main(String[] args) {


        String url = "jdbc:postgresql://localhost:5432/Books";
        String name = "root";
        String password = "123";

        try {
            Connection connection = DriverManager.getConnection(url, name, password);
            System.out.println("Connect to PostgreSQL");

            String sql = "INSERT INTO Books  (isbn,name,author,pages,weight,price) VALUES (?,?,?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, "43434343545");
            statement.setString(2, "Josh");
            statement.setString(3, "Doe");
            statement.setInt(4, 50);
            statement.setInt(5, 100);
            statement.setBigDecimal(6, BigDecimal.valueOf(600));

            int rows = statement.executeUpdate();
            if (rows > 0){
                System.out.println("A new Books contact");
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("Error in connection to PostgreSQl");
            e.printStackTrace();
        }


    }

}
        
    

