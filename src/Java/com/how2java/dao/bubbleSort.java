package com.how2java.dao;

public class bubbleSort {
    public static void main  (String args[]){
        int[] a = {10,22,30,56,89,45,26,46,78};
        int i,j;
        int temp ;
        for(i=0;i<a.length-1;i++){
            for(j=0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        for(i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
