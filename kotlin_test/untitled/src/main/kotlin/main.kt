/*


import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun main() {
//    println("foo")
//    println(myFunc(3,4))
//    p("foo")
//	vars()
//	nulls()
//	lists()
//	whens()
    //  classes()
//	linq()
// collections()
    // functions()
// 	extensions()
    //lazys();
    // myLateinit()
// interfaced()
//moreDataClass()
//delegationProp()
    infixed()
}

fun myFunc(a: Int, b: Int): Int {
    return a + b
}

fun p(str: String) = println(str)

fun vars() {
    var x = 1
    x++
    println(x)
    val y = 2
    // y++
    println(y)
}

fun nulls() {
    var x : Int?
    x = 1
    if (x != null) {
        println(x!!)
    }

    var y : String? = null
    println(y?.length ?: "foo")
}

fun lists() {
    var x = listOf("foo", "bar", "baz")
    for (y in x) {
        p(y)
    }
}

fun whens() {
    var x = 2
    when (x) {
        2 -> p("two")
        else -> p("not two")
    }

    when {
        x>0 -> p("wow")
        else -> p("boo")
    }
}

fun classes() {
    val x = myDataClass(2, "foo")
    println(x)
    val x2 = myDataClass(2, "foo")

    val y = myClass(3, "bar")
    println(y.computedProp)
    y.justGetterAndSetter = "don't print me"
    println(y.justGetterAndSetter)

    val y2 = myClass(3, "bar")
    println(y == y2)
    println(x == x2)

    println(y.hashCode())
    println(y2.hashCode())
    println(x.hashCode())
    println(x2.hashCode())

    var z = mySubClass(4, "goo")
    z.myOpenFun()
}

open class myClass {
    constructor(myInt: Int, myStr: String) {
        this.myInt = myInt
        this.myStr = myStr
    }
    val myInt: Int
    var myStr: String

    val computedProp
        get() = "$myStr baz"

    var justGetterAndSetter
        get() = "foo"
        set(value) = println(value)


    open fun myOpenFun() {
        println("superclass")
    }

}

class mySubClass : myClass {
    constructor(myInt: Int, myStr: String) : super(myInt, myStr) {
    }

    override fun myOpenFun() {
        println("subclass")
    }
}

data class myDataClass(val myInt: Int, val myStr: String)


fun linq() {
    var x = listOf(1, 2, 3)
    x = List(10) { it + 2}
    //  println(
    x.filter { it > 2 }
        .map { it * 2}
        .onEach { println(it) }
        //.fold(0) { acc:Int, i: Int -> acc + i }
        .forEach { println(it) }
    //  	.reduce { acc: Int, i: Int -> acc + i }
    // )
    //  .fold(Int(0)) { acc, i -> acc + i }
    //
    var y = mutableListOf(myClass(0, "foo"), myClass(1, "bar"))

}

fun collections() {
    val myDict = mapOf(1 to "A", 2 to "B", 3 to "C")
    var myMutableDict = mutableMapOf<Int, String>()
    for (i in 1..10) {
        myMutableDict[i] = "STR $i"
    }
    println(myMutableDict)
}

fun functions() {
    val literalFunction: (Int) -> Int = {
        it + 1
    }
    functions2(literalFunction)

}
fun functions2(myFunc: (Int) -> Int) {
    val myList = List(4) { it * 2}
    println(myList)
    myList.map { myFunc(it) }
        .forEach { println(it) }

}

fun extensions() {
    println(2.isOdd())
    println(3.isOdd())
    println(2.isEven)
    println(3.isEven)
}


fun Int.isOdd() =  this %2 == 0

val Int.isEven: Boolean
    get() = this %2 != 0

//var myClass.Dafuq: String
//	get() = "10"
//    set() = { println(value) }

//fun Int.isEven =

fun lazys() {
    val x by lazy { println("pre2"); 10 }
    println("pre")
    println("$x")

    println( myLazyClass().x )
}

class myLazyClass {

    val x by lazy { "foo" }


}

fun myLateinit() {
    val instance = myLateinitClass()
    instance.check()
}

class myLateinitClass {
    lateinit var x : String

    fun check() {
        println(this::x.isInitialized)
        x = "bar"
        if (this::x.isInitialized) {
            p("foo")
        }
    }
}

interface myInterface {
    var myProp: String

    fun myFunc()
}

class myInterfacedClass() : myInterface {

    override var myProp: String = "foo"

    override fun myFunc() {
        println("Not yet implemented")
    }

}

fun interfaced() {
    val x = myInterfacedClass()

    val y = myPredicate { it > 10 }
    println(y.butIsIt(10))

}

fun interface myPredicate {
    fun butIsIt(myInt: Int): Boolean
}


data class myOtherDataClass(var foo: Int, var bar: String)

fun moreDataClass() {
    val (foo, bar) = myOtherDataClass(1, "foo")
    println("$foo $bar")
}

enum class myEnum {
    Foo {
        override fun myFunc(): myEnum {
            TODO("Not yet implemented")
        }

        override fun toString(): String {
            return "Foo()"
        }

    },
    Bar {
        override fun myFunc(): myEnum {
            TODO("Not yet implemented")
        }
    },
    Baz {
        override fun myFunc(): myEnum {
            TODO("Not yet implemented")
        }
    };

    abstract fun myFunc(): myEnum
}

fun delegationProp() {
    val instance = myDelegatedProp()
    instance.myProp = "foo"
    println(instance.myProp)
}

class myDelegatedProp {
    var myProp: String by myDelegate
}


object myDelegate : ReadWriteProperty<myDelegatedProp, String> {
    override fun getValue(thisRef: myDelegatedProp, property: KProperty<*>): String {
        return("getValue $property.name")
    }

    override fun setValue(thisRef: myDelegatedProp, property: KProperty<*>, value: String) {
        println("setValue $property.name $value")
    }
}

fun infixed() {
    1 bar 2 bar 3 bar 4
}

infix fun Int.bar(i: Int): Int {
    println("barbar infix: $this $i")
    return this + i
}

var x = 1
*/

