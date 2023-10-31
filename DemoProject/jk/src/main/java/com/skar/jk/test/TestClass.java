package com.skar.jk.test;

import java.util.Arrays;
import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] a = new int[size];
        for (int i=0;i<size;i++){
            a[i]=sc.nextInt();
        }
        int cur=0;
        for (int i=0;i<a.length;i++){
            if (a[i] != 0) {
                if (cur!=i){
                    a[cur]=a[cur]+a[i];
                    a[i]=a[cur]-a[i];
                    a[cur]=a[cur]-a[i];
                }
                cur++;
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
