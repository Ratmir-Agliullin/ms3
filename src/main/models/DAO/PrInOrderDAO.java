package main.models.DAO;

import main.models.pojo.Order;
import main.models.pojo.Product;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by admin on 02.05.2017.
 */
@Service
public class PrInOrderDAO implements PrInOrderInterface {
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


    @Override
    public void InsertPrInOrder(int orderName_id, Product product) {
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO  productsinordertable( ordername_id, productname,price) VALUES (?,?,?)");
            preparedStatement.setInt(1, orderName_id);
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setInt(3, product.getProductPrice());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.info(e.toString());
        }
    }

    @Override
    public List<Order> SelectOrderInTable() {
        return null;
    }

    @Override
    public List<Order> SelectOrderInTableByUser() {
        return null;
    }

    public void DeletePrInOrEntityById(int id){
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "delete from public.productsinordertable WHERE ordername_id="+id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.info(e.toString());
        }
    };
}
