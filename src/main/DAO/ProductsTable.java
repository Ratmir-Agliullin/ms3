package main.DAO;

import main.models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by admin on 24.04.2017.
 */
public class ProductsTable implements ProductsTableInterface {
    private static Logger log = Logger.getLogger(OrderDAO.class.getName());
    public Connection initConnection(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            log.info(e.toString());
        } finally {

        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost/Kurs4","postgres", "Kbctyrjgbljh48");
        } catch (SQLException e) {
            log.info(e.toString());
        }

        return connection;
    }

    public void UpdateProductsTable() {

    }

    public void UpdateProductsTable(Product productsTable) {

    }

    public void DeleteProductsTable() {

    }

    public void InsertProductsTable() {

    }

    public void InsertProductsTable(Product productsTable) {
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO  productstable(pt_id, productname,price) VALUES (?,?)");

            preparedStatement.setString(1, productsTable.getProductName());
            preparedStatement.setInt(2, productsTable.getProductPrice());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.info(e.toString());
        }
    }

    public List<Product> SelectProductsTable() {
        Connection connection = initConnection();
        List<Product> productsTableAL = new ArrayList<Product>();

        try {
            Statement statement = connection.createStatement();
            ResultSet result =
                    statement.executeQuery("select * from public.productstable" );
            while (result.next()) {
                Product product = new Product();
                product.setId(result.getInt(1));
                product.setProductName(result.getString(2));
                product.setProductPrice(result.getInt(3));
                productsTableAL.add(product);

            }
        } catch (SQLException e) {
            log.info(e.toString());
        }
        return productsTableAL;
    }
}
