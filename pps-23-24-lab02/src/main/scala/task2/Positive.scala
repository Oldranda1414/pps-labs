package task2

object Positive extends App:
    val positiveVal: (Int) => String = (i: Int) => i match
        case n if n >= 0 => "positive"
        case _ => "negative"
    

    println("1 is " + positiveVal(1))
    println("0 is " + positiveVal(0))
    println("-1 is " + positiveVal(-1))

    def positive: (Int) => String = (i: Int) => i match
        case n if n >= 0 => "positive"
        case _ => "negative"


    println("1 is " + positive(1))
    println("0 is " + positive(0))
    println("-1 is " + positive(-1))