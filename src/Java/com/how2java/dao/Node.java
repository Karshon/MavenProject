package com.how2java.dao;

public class Node {
    public Node(Object obj, Node prev, Node next) {
        this.obj = obj;
        this.prev = prev;
        this.next = next;
    }
    public void setObj(Object obj){
        this.obj = obj;
    }
    public Node() {
    }

    //当前
    public Object obj;
    //上一个节点
    public  Node prev;
    //下一个节点
    public Node next;

}
