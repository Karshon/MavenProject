package com.how2java.service.impl;

import com.how2java.dao.MyNode;
import com.how2java.service.VisitAll;

import java.util.ArrayDeque;
import java.util.Deque;

public class PostVisitImpl implements VisitAll {
    @Override
    public void visitTree(MyNode myNode) {
        Deque<MyNode> d1 = new ArrayDeque<>();
        Deque<MyNode> d2 = new ArrayDeque<>();
        while(myNode!=null||d1.size()>0){
            while(myNode!=null){
                d1.push(myNode);
                d2.push(myNode);
                myNode = myNode.getRight();
            }
            if(d1.size()>0){
                myNode = d1.pop();
                myNode = myNode.getLeft();
            }
        }
        while(d2.size()>0){
            myNode = d2.pop();
            myNode.visit();

        }
    }
}
