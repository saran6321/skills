package com.skar.jk.java;

public class SecondClass {
    int secondClassVariable = 0;    // default modifier can be accessed within the same package
    private static SecondClass sc = null;

    private SecondClass(){      // this method is used to create a single ton class

    }

    public static SecondClass getInstance() {   // single ton object of a class can be get by static method
        if (SecondClass.sc == null) {
            SecondClass.sc = new SecondClass();
        }
        return SecondClass.sc;
    }

    SecondClass(int VALUE){             // once an manual constructor is declared there will be no default constructor

    }
}
