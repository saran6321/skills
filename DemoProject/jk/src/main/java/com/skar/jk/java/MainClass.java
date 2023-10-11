package com.skar.jk.java;

public class MainClass {
    MainInterface interfaceObject = null;
    private int INTEGER = 0;
    public MainClass(){
        // default constructor
    }

    public MainClass(int INTEGER){
        // this is used to access this instance of the class
        // constructor overloading
        this.INTEGER = INTEGER;
    }

    public void setMainClass(MainInterface mainClass){
        this.interfaceObject = mainClass;
    }

    public void callMainJavaMethod(){
        if (interfaceObject != null) {
            interfaceObject.interfaceMethod();
        }
    }

    public int getINTEGER() {
        return INTEGER;
    }

    public void setINTEGER(int INTEGER) {
        // encapsulation : getter and setter encapsulates instance attribute by making it private and makes sure it meets requirement.
        if (INTEGER > 0) {
            this.INTEGER = INTEGER;
        } else {
            // print invalid
        }
    }

    private static void mainClassStaticMethod(){

    }
}