package com.skar.jk.java;

abstract public class AbstractClass {
    // cannot create instance for abstract class
    // abstract methods must be implemented by the child class
    private void privateMethod(){}

    // abstract private void fub();     private method cannot be abstract

    abstract protected void abstractProtectedMethod();  //definition is not allowed for abstract methods

    protected void methodOverloading(){}        // inherited class instance can overload this method

    protected void methodOverloading(int INTEGER){}
}
