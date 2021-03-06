package com.star.springbootdemo.designpattern.factory.simplefactory.pizzastore.order;

import com.star.springbootdemo.designpattern.factory.simplefactory.pizzastore.pizza.CheesePizza;
import com.star.springbootdemo.designpattern.factory.simplefactory.pizzastore.pizza.GreekPizza;
import com.star.springbootdemo.designpattern.factory.simplefactory.pizzastore.pizza.PepperPizza;
import com.star.springbootdemo.designpattern.factory.simplefactory.pizzastore.pizza.Pizza;

//�򵥹�����
public class SimpleFactory {

	//����orderType ���ض�Ӧ��Pizza ����
	public Pizza createPizza(String orderType) {

		Pizza pizza = null;

		System.out.println("ʹ�ü򵥹���ģʽ");
		if (orderType.equals("greek")) {
			pizza = new GreekPizza();
			pizza.setName(" ϣ������ ");
		} else if (orderType.equals("cheese")) {
			pizza = new CheesePizza();
			pizza.setName(" �������� ");
		} else if (orderType.equals("pepper")) {
			pizza = new PepperPizza();
			pizza.setName("��������");
		}

		return pizza;
	}

	//�򵥹���ģʽ Ҳ�� ��̬����ģʽ

	public static Pizza createPizza2(String orderType) {

		Pizza pizza = null;

		System.out.println("ʹ�ü򵥹���ģʽ2");
		if (orderType.equals("greek")) {
			pizza = new GreekPizza();
			pizza.setName(" ϣ������ ");
		} else if (orderType.equals("cheese")) {
			pizza = new CheesePizza();
			pizza.setName(" �������� ");
		} else if (orderType.equals("pepper")) {
			pizza = new PepperPizza();
			pizza.setName("��������");
		}

		return pizza;
	}

}
