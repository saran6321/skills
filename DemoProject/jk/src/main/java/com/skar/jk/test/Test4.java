package com.skar.jk.test;

import java.util.Arrays;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
//        String[] s = {"eat", "tea", "tan"};
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        String[] s = new String[size];
        for (int i=0;i<size;i++){
            s[i]=sc.next();
        }
        for (int i = 0; i < s.length; i++) {
            if (s[i] != " ") {
                System.out.println("["+s[i]);
                for (int j = i + 1; j < s.length; j++) {
                    if (checkAnagram(s[i], s[j])) {
                        System.out.println(s[j]);
                        s[j] = " ";
                    }
                }
                System.out.println("]");
            }
        }
    }

    private static boolean checkAnagram(String s1, String s2) {
        char[] sa1 = s1.toCharArray();
        char[] sa2 = s2.toCharArray();
        quickSort(sa1,0,s1.length()-1);
        quickSort(sa2,0,s2.length()-1);
        return checkEquals(sa1,sa2);
    }

    private static boolean checkEquals(char[] sa1, char[] sa2) {
        if (sa1.length == sa2.length){
            for (int i = 0; i < sa1.length; i++) {
                if (sa1[i]!=sa2[i]){
                    return false;
                }
            }
        }else {
            return false;
        }
        return true;
    }

    private static void quickSort(char[] a,int low,int high) {
        if (low < high) {
            int pi = quickSortPartition(a, low, high);
            quickSort(a, low, pi - 1);
            quickSort(a, pi + 1, high);
        }
    }

    private static int quickSortPartition(char[] a, int low, int high) {
        int pivot = a[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (a[j] < pivot) {
                i++;
                swapArray(a, j, i);
            }
        }
        swapArray(a, i+1, high);
        return i+1;
    }

    private static void swapArray(char[] a, int i, int j) {
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
