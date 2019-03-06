package com.how2java.dao;

public class IntiTree {
    public static MyNode init(){
        MyNode h =new MyNode("H",null,null);
        MyNode g = new MyNode("G",null,h);
        MyNode i = new MyNode("I",null,null);
        MyNode c = new MyNode("C",g,i);
        MyNode e = new MyNode("E",null,null);
        MyNode f = new MyNode("f",e,null);
        MyNode d = new MyNode("D",null,null);
        MyNode b = new MyNode("B",d,f);
        MyNode a = new MyNode("A",b,c);
        return a ;

    }
}
