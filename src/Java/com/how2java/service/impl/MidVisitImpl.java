package com.how2java.service.impl;

import com.how2java.dao.IntiTree;
import com.how2java.dao.MyNode;
import com.how2java.service.VisitAll;

import java.util.ArrayDeque;
import java.util.Deque;

public class MidVisitImpl implements VisitAll {
    @Override
    public void visitTree(MyNode myNode) {
        Deque<MyNode> dq = new ArrayDeque<>();

        while(myNode!=null||dq.size()!=0){
            while(myNode!=null){
                dq.push(myNode);
                myNode = myNode.getLeft();
            }
            if(dq.size()>0){
                myNode = dq.pop();
                myNode.visit();
                myNode= myNode.getRight();
            }
        }
    }
}
