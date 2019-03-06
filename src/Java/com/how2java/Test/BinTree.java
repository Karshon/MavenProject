package com.how2java.Test;

import com.how2java.dao.IntiTree;
import com.how2java.dao.MyNode;
import com.how2java.service.VisitAll;
import com.how2java.service.impl.MidVisitImpl;
import com.how2java.service.impl.PostVisitImpl;
import com.how2java.service.impl.PreVisitImpl;

public class BinTree {

    public static void main (String[] args) {
        MyNode rootFact = IntiTree.init();
        VisitAll visitAll = new PostVisitImpl();
        visitAll.visitTree(rootFact);
    }

    }
