package Dao;

import Models.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManageCategory {
    static Connection connection = ConnectionSQL.getConnection();

    public static ArrayList<Category> showCategory() throws Exception {
        String sqlSelect = "select * from danhmuc";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlSelect);
        ArrayList<Category> listCategory = new ArrayList<>();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");

            listCategory.add(new Category(id, name));

        }
        return listCategory;
    }
}
