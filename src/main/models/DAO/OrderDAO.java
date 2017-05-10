package main.models.DAO;

import main.models.pojo.Order;
import main.models.pojo.Users;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by admin on 24.04.2017.
 */
@Service
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

    public void DeleteOrderById(int id) {
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "delete from public.orderstable WHERE ot_id="+id);
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
                    "INSERT INTO  orderstable( user_name_id, result_price, time_order, status,ordername) VALUES (?,?,?,?,?)");
                  preparedStatement.setInt(1, order.getUser_id());
            preparedStatement.setInt(2, order.getResultPrice());
            preparedStatement.setLong(3, order.getTime());
            preparedStatement.setString(4, order.getStatus());
            preparedStatement.setString(5, order.getOrderName());
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

    public int SelectOrderId(Order order){
        int res=0;
        Connection connection = initConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet result =
                    statement.executeQuery("select ot_id from public.orderstable where ordername='"+
                            order.getOrderName()+"'");
            while (result.next())
            res = result.getInt(1);

        } catch (SQLException e) {
            log.info(e.toString());
        }
        return res;
    }

    public List<Order> SelectOrderByUserId(int id){

        List<Order> orderList = new ArrayList<>();
        Connection connection = initConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet result =
                    statement.executeQuery("select * from public.orderstable"+
                            "  inner join users on orderstable.user_name_id = users.user_id where user_name_id="+id);
            while (result.next()) {
                Order order = new Order();
                order.setUser_id(result.getInt(2));
                order.setResultPrice(result.getInt(3));
                order.setTime(result.getLong(4));
                order.setStatus(result.getString(5));
                order.setOrderName(result.getString(6));
                Users user = new Users();
                user.setUserName(result.getString(8));
                user.setPassName(result.getString(9));
                order.setUserName(user);
                orderList.add(order);
            }
        } catch (SQLException e) {
            log.info(e.toString());
        }
        return orderList;
    }
}
