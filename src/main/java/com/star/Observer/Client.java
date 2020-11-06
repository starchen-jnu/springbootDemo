package com.star.Observer;

import java.util.function.Supplier;

/**
 * @Author: StarC
 * @Date: 2020/8/26 13:39
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        ProductList productList = ProductList.getInstance();
        TaoBao taoBao = new TaoBao();
        JingDong jingDong = new JingDong();
        productList.addProductListObserver(taoBao);
        productList.addProductListObserver(jingDong);
        Supplier<Product> supplier = ()->new Product("Huawei",4999d,1.5d,"good machine");
        productList.addProduct(supplier.get());
    }
}

