package com.skar.jk.kotlin

import java.lang.Exception

/*
* license
*
 */


class KotlinStyles {

}
                    // new line after functions
fun main() {        // new line after opening braces and closing braces
    val bool = false
    if (bool) return else 0     // single line possible must be single line

    when(bool){
        true -> 0       // no need braces if single line possible
        false -> 1
    }

    if (bool) {
        return          // new line statements must have braces
    }

    try {

    }catch (e:Exception){
    }       // empty statement braces must be in new line

}

fun notes(      // more parameters must have line breaks
    a: Int,
    b: Int,
    c: Int,
    d: Int,
    e: Int,
    f: Int,
    g: Int,
    h: Int,
    i: Int,
    j: Int,
    k: Int,
    l: Int
) {
    // indentation must have 4 spaces
    // column limit is 100 characters
    // break after operator or equal signs
}