package com.how2java.dao;

import java.util.ArrayList;
import java.util.List;

public class MyArrayList {
    private Object[] elementData;
    private int size;
    public MyArrayList(){
        elementData = new Object[10];
    }

    public void add(Object obj){
        if(size>=elementData.length){
            Object[]  temp = new Object[elementData.length*2];
            //数组的复制
            System.arraycopy(elementData,0,temp,0,size);
            elementData = temp;
        }
        elementData[size++]=obj;
    }

}
