package com.skar.jk.kotlin

class MainClass : MainInterface, ParentClass() {
  val STRING: String = "sarankumar"
  var name = ""
  var age = 0
    get() = field
    set(value) {
      field = value
    }

  companion object {
    fun companionStaticFunction(){
      // static like methods
    }
  }

  override fun interfaceMethod() {
    // main class action
  }

  override fun parentAbstractMethod() {

  }

  init {
    parentInterfaceMethod(this)
  }


}