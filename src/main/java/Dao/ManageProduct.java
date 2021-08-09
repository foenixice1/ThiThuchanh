package Dao;

import Models.Product;

import java.sql.*;
import java.util.ArrayList;

public class ManageProduct {
    static Connection connection = ConnectionSQL.getConnection();

    public static ArrayList<Product> showProduct() throws Exception {
        String sqlSelect = "select * from sanpham";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlSelect);
        ArrayList<Product> listSP = new ArrayList<>();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            double price = resultSet.getDouble("price") ;
            int amount = resultSet.getInt("amount");
            String color = resultSet.getString("color");
            String description = resultSet.getString("description");
            int idCategory = resultSet.getInt("idCategory");
            listSP.add(new Product(id,name,price,amount,color,description,idCategory));

        }
        return listSP;
    }

    public static void saveProduct(Product product) throws SQLException {
        String sqlSave = "insert into sanpham value(?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlSave);

        preparedStatement.setInt(1,product.getId());
        preparedStatement.setString(2,product.getName());
        preparedStatement.setDouble(3,product.getPrice());
        preparedStatement.setInt(4,product.getAmount());
        preparedStatement.setString(5,product.getColor());
        preparedStatement.setString(6,product.getDescription());
        preparedStatement.setInt(7,product.getIdCategory());
        preparedStatement.execute();
    }

    public static void editProduct(Product product) throws SQLException {
        String sqlEdit = "update sanpham set name=? , price=? ,amount=?,color=?,description=?,idCategory=? where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlEdit);

        preparedStatement.setInt(7,product.getId());
        preparedStatement.setString(1,product.getName());
        preparedStatement.setDouble(2,product.getPrice());
        preparedStatement.setInt(3,product.getAmount());
        preparedStatement.setString(4,product.getColor());
        preparedStatement.setString(5,product.getDescription());
        preparedStatement.setInt(6,product.getIdCategory());
        preparedStatement.execute();

    }

    public static void deleteProduct(int id) throws SQLException {
        String sqldelete = "delete from sanpham where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqldelete);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }

    public static ArrayList<Product> findByName(String findName) throws SQLException {
        ArrayList<Product> findList = new ArrayList<>();
        String findByName = "select * from sanpham where name like '%" + findName + "%'";
        PreparedStatement preparedStatement = connection.prepareStatement(findByName);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            double price = resultSet.getDouble("price") ;
            int amount = resultSet.getInt("amount");
            String color = resultSet.getString("color");
            String description = resultSet.getString("description");
            int idCategory = resultSet.getInt("idCategory");
            findList.add(new Product(id,name,price,amount,color,description,idCategory));

        }
        return findList;

    }

















}
