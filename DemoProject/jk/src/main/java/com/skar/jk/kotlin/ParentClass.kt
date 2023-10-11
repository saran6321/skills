package com.skar.jk.kotlin

abstract class ParentClass {
  lateinit var mainInterface: MainInterface
  abstract fun parentAbstractMethod()

  // a function with body cannot be abstract
  fun parentInterfaceMethod(mainClass: MainInterface) {
    // PARENT METHOD IMPLEMENTATION
    this.mainInterface = mainClass
  }

  fun callMainClassInterfaceMethod(){
    if (this::mainInterface.isInitialized){
      mainInterface.interfaceMethod()
    }
  }
}