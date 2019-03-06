package com.how2java.dao;

public class quickSort {
    public static void main(String args[]) {
        int[] a = {5, 1, 3, 8, 4, 6, 7, 2, 9};
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        int start = 0;
        int end = a.length - 1;
        System.out.println("经过快速排序后，得出的结果");
        sort(a,start,end);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }



    }

     public static void sort(int[] a, int start, int end) {
        int low = start;
         int high = end;
        int key = a[start];
        int temp;
        int temp2;
        while(low<high){
            while(low<high&&a[high]>key){
                high--;
            }
            while(low<high&&a[low]<=key){
                low++;
            }
            temp=a[high];
            a[high]=a[low];
            a[low]=temp;
        }
        temp2=a[start];
        a[start] = a[low];
        a[low] =temp2;
       if(start<low) sort(a,start,low-1);
        if(high<end)sort(a,high+1,end);
    }



}
