package com.skar.jk.kotlin

fun main(){
  tableOfContents()
}

fun tableOfContents() {
  kotlinFacts()
  basics()
  oops()
  stringNotes()
  arrays()
  dataStructures()
  algorithms()
  problems()
}

fun problems() {

}

fun algorithms() {

}

fun dataStructures() {

}

fun arrays() {
  val l = listOf(1,2,3,4,5)
  l.size
  l.forEach {
    it.toString()
  }
  l.firstOrNull()
  l.filter { it == 2 }
  l.lastOrNull()
  for (i in l){
    i
  }
}

fun stringNotes() {
  val s = "saran"
  val k = "kumar"
  val sk = "$s $k"  // string concatination

  s.length
  s.plus("k")
  s.replace("saran","skar",true)
  s.reversed()
  s[0]
  s.forEach {
    it
  }
}

fun oops() {
  val mainClass = MainClass().apply {
    name = "sarankumar"
    age = 22
  }
  with(mainClass){
    name = "sarankumar k"
    age = 23
  }
  mainClass.parentAbstractMethod()
  MainClass.companionStaticFunction()
  // open - only open classes can be inherited or overridden
  // classes are final by default in kotlin
}

fun basics() {
  // can use all the java functionalities
  // declaration
  val INTEGER: Int = 5
  var VARIABLE = 6
  VARIABLE = 7
  var BOOLEAN: Boolean = true
  val STRING: String = "sarankumar"
  val LIST: List<String> = listOf("saran", "kumar")

  // operators
  INTEGER + INTEGER
  //p(STRING + STRING)

  var n:Int? = null
  n = 5
  n?.let {

  }

  // CONDITIONAL STATEMENTS
  // IF ELSE
  if (INTEGER > 0) {
    // POSITIVE
  } else if (INTEGER == 0) {
    // VALUE EQUAL TO 0
  } else {
    // VALUE IS NEGATIVE
  }

  // WHEN SWITCH
  when (INTEGER) {
    'a'.code -> {}
    6 -> {}
    else -> {}
  }

  when {
    INTEGER == INTEGER -> {}
    INTEGER > 0 -> {}
  }


  // LOOPING

  // WHILE
  var i = 0
  while (i < 10) {
    // EXPRESSION
    i++
  }

  // DO WHILE
  i = 0
  do {
    // EXPRESSION
    i++
  } while (i < 10)

  // FOR LOOPING
  for (i in 0..5){
    // statement
  }
  for (i in LIST){
    // p(i)
  }

  try {
    // try block
  } catch (e: Exception) {
    // runs on exception
  } finally {
    // runs on final after any case
  }

}

fun kotlinFacts() {
    /*
    * can execute kotlin without jvm
    *
    *
    *
    *
    *
    * */
}


