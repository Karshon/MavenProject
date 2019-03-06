package com.how2java.dao;

public class MyNode {
    private String value;//存储业务数据
    private MyNode left;//左子树
    private MyNode right;//右子树
    public MyNode(String value ,MyNode left ,MyNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
    //访问当前节点
        public void visit(){System.out.println(value+" ");}
    //去往当前节点的左子树
        public MyNode getLeft(){return left;}
    //去往当前节点的右子树
        public MyNode getRight(){return right;}

}
