package com.star.springbootdemo.designpattern.factory.absfactory.pizzastore.order;

import com.star.springbootdemo.designpattern.factory.absfactory.pizzastore.pizza.Pizza;

//һ�����󹤳�ģʽ�ĳ����(�ӿ�)
public interface AbsFactory {
	//������Ĺ��������� ����ʵ��
	public Pizza createPizza(String orderType);
}
