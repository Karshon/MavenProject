package com.how2java.service.impl;

import com.how2java.dao.MyNode;
import com.how2java.service.VisitAll;

public class PreVisitImpl implements VisitAll {
    @Override
    public void visitTree(MyNode myNode) {
       if(myNode == null){
           return;
       }
        myNode.visit();
        visitTree(myNode.getLeft());
        visitTree(myNode.getRight());

    }
}
