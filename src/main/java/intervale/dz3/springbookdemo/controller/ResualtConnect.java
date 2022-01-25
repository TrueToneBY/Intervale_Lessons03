package intervale.dz3.springbookdemo.controller;

import java.math.BigDecimal;
import java.sql.*;

public class ResualtConnect {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/Books";
        String name = "root";
        String password = "123";

            try {
                Connection connection = DriverManager.getConnection(url,name,password);
                System.out.println("Connected to PostgreSQL server");

                String sql = "SELECT * FROM Books";

                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String isbn = resultSet.getString("isbn");
                    String name1 = resultSet.getString("name");
                    String author = resultSet.getString("author");
                    int pages = resultSet.getInt("pages");
                    double weight = resultSet.getDouble("weight");
                    BigDecimal price = resultSet.getBigDecimal("price");

                    System.out.printf("%d - %s - %s - %s - %s - %s - %s\n", id, isbn ,name1 , author, pages, weight, price);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }
}
