package com.how2java.dao;

public class MyLinkedList {
    private Node first;
    private Node last;
    private int size;
    public void add(Object obj){
        Node node = new Node();
        if(first==null){
            node.prev=null;
            node.next=null;
            node.setObj(obj);
            first = node;
            last  = node;
        }else{
            node.prev=last;
            node.next= null;
            node.setObj(obj);
            last.next = node;
            last = node;

        }
    }
}
