package com.skar.jk.test;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] a = s.toCharArray();
        for (int i=0;i<s.length();i++){
            if (a[i]!=' '){
                System.out.print(a[i]);
                int count = 1;
                for (int j=i+1;j<s.length();j++){
                    if (a[i]==a[j]){
                        count++;
                        a[j]=' ';
                    }
                }
                System.out.print(count);
            }
        }
    }
}
