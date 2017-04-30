package main.models.DAO;

import main.models.pojo.Order;
import main.models.pojo.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by admin on 24.04.2017.
 */
public class OrderDAO implements OrderTableInterface {
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

    public void UpdateOrderTable() {

    }

    public void UpdateOrderTable(Order orderTable) {

    }

    public void DeleteOrderTable() {
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "delete from public.orderstable");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.info(e.toString());
        }
    }

    public void InsertOrderTable() {

    }

    public void InsertOrderTable(Order order) {
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO  orderstable(ot_id, user_name_id, result_price, time_order, status,ordername) VALUES (?,?,?,?,?,?)");
            preparedStatement.setInt(1, order.getId());
            preparedStatement.setInt(2, order.getUser_id());
            preparedStatement.setInt(3, order.getResultPrice());
            preparedStatement.setLong(4, order.getTime());
            preparedStatement.setString(5, order.getStatus());
            preparedStatement.setString(6, order.getOrderName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.info(e.toString());
        }
    }

    public List<Order> SelectOrderTable() {
        Connection connection = initConnection();
        List<Order> orderTableAL = new ArrayList<Order>();

        try {
            Statement statement = connection.createStatement();
            ResultSet result =
                    statement.executeQuery("select * from public.orderstable inner join users"+
                    " on orderstable.user_name_id = users.user_id");
            while (result.next()) {
                Order orderTable = new Order();
                Users userTable = new Users();
                userTable.setId(result.getInt(7));
                userTable.setUserName(result.getString(8));
                userTable.setPassName(result.getString(9));
                orderTable.setId(result.getInt(1));
                orderTable.setUser_id(result.getInt(2));
                orderTable.setResultPrice(result.getInt(3));
                orderTable.setTime(result.getLong(4));
                orderTable.setStatus(result.getString(5));
                orderTable.setOrderName(result.getString(6));
                orderTable.setUserName(userTable);
                orderTableAL.add(orderTable);

            }
        } catch (SQLException e) {
            log.info(e.toString());
        }
        return orderTableAL;
    }
}
