package com.star.springbootdemo.designpatern.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: StarC
 * @Date: 2020/8/11 15:21
 * @Description:
 */
public class HandlerChain  {
    List<Handler> list = new ArrayList<>();

    public void addHandler(Handler handler){
        list.add(handler);
    }

    public boolean process(Process process){
       for(Handler handler : list){
           handler.process(process);
        }
       return false;
    }

    public static void main(String[] args) {
        HandlerChain handlerChain = new HandlerChain();
        handlerChain.addHandler(new ManagerHandler());
        handlerChain.addHandler(new CEOHandler());

        handlerChain.process(new Process("star",new BigDecimal(2000),0));
        handlerChain.process(new Process("star",new BigDecimal(20000),1));
    }

}
