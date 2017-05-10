package main.models.DAO;

import main.models.pojo.Product;

import java.util.List;

/**
 * Created by admin on 24.04.2017.
 */
public interface ProductsTableInterface {



    public void UpdateProductsTable();

    void UpdateProductsTable(Product productsTable);

    public void DeleteProductsTable();
    public void InsertProductsTable();

    void InsertProductsTable(Product productsTable);

    public List<Product> SelectProductsTable();
    public Product getProductById(int id);
}
