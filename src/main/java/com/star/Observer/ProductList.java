package com.star.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * @Author: StarC
 * @Date: 2020/8/26 11:50
 * @Description:
 */
public class ProductList extends Observable {

    private List<Product> productList = null;
    private static ProductList instance;
    private ProductList(){}

    public static ProductList getInstance(){
        if(instance == null){
            instance = new ProductList();
            instance.productList = new ArrayList<>();
        }
        return instance;
    }
    public void addProductListObserver(Observer observer){
        this.addObserver(observer);
    }
    public void addProduct(Product product){
        productList.add(product);
        System.out.println("produce update:"+product.getName());
        this.setChanged();
        this.notifyObservers(product);
    }

}
