package main.services;

import main.models.DAO.OrderDAO;
import main.models.pojo.Order;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 27.04.2017.
 */
@Service
public class OrderService {
    private OrderDAO orderDAO  = new OrderDAO();
    public void InsertInOrder(Order order) {orderDAO.InsertOrderTable(order);}
    public List<Order> SelectAllOrders(){return orderDAO.SelectOrderTable();}
    public List<Order> SelectOrderByUser(){return orderDAO.SelectOrderTable();}
    public int SelectOrderId(Order order){return orderDAO.SelectOrderId(order);}
    public List<Order> SelectOrderByUserId(int id){return orderDAO.SelectOrderByUserId(id);}
    public void DeleteOrderById(int id){orderDAO.DeleteOrderById(id);}
}
