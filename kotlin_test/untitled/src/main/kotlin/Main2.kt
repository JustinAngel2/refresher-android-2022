import java.util.Collections.singleton
import kotlin.concurrent.thread
//import kotlinx.coroutines.*

fun main(args: Array<String>) {
    //letThemEatCake();
   // lambda()
  //  single()
//    threading();
 //   coro();
    checks();
}




fun checks() {
    require(2 < 1) { "foo"}
    check(2 < 1) { "bar" }
    assert(2 < 1) { "baz"}
}




fun coro() {

}

object myStaticClass {
    fun myStaticMethod() { println("foo") }
    var myStaticProperty = listOf("bar", "baz")
}

class myClassWithStaticMembers() {
    companion object {
        fun myStaticMethod() { println("foo") }
        var myStaticProperty = listOf("bar", "baz")
    }
}


interface myInteraceWithDefaults {
    fun foo() { println("foo") }

    val bar: String?
        get() = "bar"
}








fun threading() {
    thread (start = true, name = "other") {
        for (i in 1..100) {
            println("thread $i");
        }
    }

    for (i in 1..100) {
        println("main $i");
    }
}

class myClass2 {
    companion object Factory {
        fun create() : myClass2 {
            return myClass2()
        }
    }
}

fun singletons() {
    myObj.myCollection.add("foo")
    myObj.myCollection.add("bar")
    myObj.myCollection.add("baz")
    println(myObj.myCollection.size)

    val myInstance = myClass2.create()

}

object myObj {
    val myCollection = mutableListOf<String>()
}

fun lambda() {
    val lambda = { a: Int, b: Int ->
        a + b
    }

    println(lambda(1,2))

    var foo = listOf(1..10)
   // foo.sortedWith({ compareBy {  it } })

}

fun letThemEatCake() {
    var nullableStr : String? = "let them eat cake"
    nullableStr?.let {
        println("them eat cake") }
}

class myClass(var myStr: String, var myInt: Int = 0) {
    /*

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as myClass

        if (myInt != other.myInt) return false
        if (myStr != other.myStr) return false

        return true
    }

    override fun hashCode(): Int {
        var result = myInt
        result = 31 * result + myStr.hashCode()
        return result
    }*/
/*

    override fun toString(): String {
        return "myClass(myInt=$myInt, myStr='$myStr')"
    }
*/


}