package com.skar.jk.test;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int size = sc.nextInt();
//        int[] a = new int[size];
//        for (int i=0;i<size;i++){
//            a[i]=sc.nextInt();
//        }

        int[] a = {1, 3, 4, 2, 2};
        int val = a[0];
        for (int i = 1; i < a.length; i++) {
            val ^= a[i];
        }
        System.out.println(val);
    }
}
