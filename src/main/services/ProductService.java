package main.services;

import main.models.DAO.ProductsTable;
import main.models.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 27.04.2017.
 */
@Service
public class ProductService {

    private ProductsTable productsTable;
@Autowired
    public void setProductsTable(ProductsTable productsTable) {
        this.productsTable = productsTable;
    }





    public Product getProductById(int id){
        return productsTable.getProductById(id);}

}
