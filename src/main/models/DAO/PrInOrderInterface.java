package main.models.DAO;

import main.models.pojo.Order;
import main.models.pojo.Product;

import java.util.List;

/**
 * Created by admin on 02.05.2017.
 */
public interface PrInOrderInterface {
    public void InsertPrInOrder(int orderName_id, Product product);
    public List<Order> SelectOrderInTable();
    public List<Order> SelectOrderInTableByUser();
    public void DeletePrInOrEntityById(int id);
}
