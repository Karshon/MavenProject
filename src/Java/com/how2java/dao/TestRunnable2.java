package com.how2java.dao;

public  class TestRunnable2 {
    public static void main (String[] args){
        TestRunnable mTestRunnable = new TestRunnable();
        Thread mThread = new Thread(mTestRunnable);
        mThread.start();
    }
}
