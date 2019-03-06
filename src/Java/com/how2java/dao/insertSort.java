package com.how2java.dao;

public class insertSort{
    public static void main(String [] args){
        int[] a = {10,22,30,56,89,45,26,46,78};
        insertSort1(a);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }

    public static void insertSort1 (int a[]){
       int temp;
        for(int i = 1;i<a.length;i++){
             temp = a[i];
            int j=i-1;
            while( j>=0&&a[j]>temp){
                   a[j+1]=a[j];
                   j--;
            }
            a[j+1]=temp;
        }
    }
}
