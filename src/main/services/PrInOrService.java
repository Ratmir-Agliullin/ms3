package main.services;

import main.models.DAO.OrderDAO;
import main.models.DAO.PrInOrderDAO;
import main.models.pojo.Product;
import main.models.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 27.04.2017.
 */
@Service
public class PrInOrService {

    private OrderDAO orderDAO;
    @Autowired
    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }



    private PrInOrderDAO prInOrderDAO;
@Autowired
    public void setPrInOrderDAO(PrInOrderDAO prInOrderDAO) {
        this.prInOrderDAO = prInOrderDAO;
    }

    public int getSumPrice(List<Product> productList){
        int result = 0;
        for (Product product: productList
             ) {result+=product.getProductPrice();

        }
        return result;
    }


    public List<Product> ProductToList(Product product){
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        return productList;
    }

    public String newOrderNameCreate(List<Product> productList, Users user){
        long now = System.currentTimeMillis();
        String orderName = "New_order_" + user.getId()+"___" + now;
        return orderName;

    }
    public void InsertInPrInOrTable(int orderName_id, Product product){prInOrderDAO.InsertPrInOrder(orderName_id,
            product);};

    public void InsertListInPrInOrTable(int orderName_id,List<Product> productList){
        for (Product product:productList
             ) {prInOrderDAO.InsertPrInOrder(orderName_id,product);

        }
    }
    public void DeletePrInOrderById(int id){prInOrderDAO.DeletePrInOrEntityById(id);}
}
