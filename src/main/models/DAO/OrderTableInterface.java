package main.models.DAO;

import main.models.pojo.Order;

import java.util.List;

/**
 * Created by admin on 24.04.2017.
 */
public interface OrderTableInterface {
    public void UpdateOrderTable();

    void UpdateOrderTable(Order orderTable);

    public void DeleteOrderTable();
    public void InsertOrderTable();

    public void InsertOrderTable(Order order);

    public List<Order> SelectOrderTable();
}
