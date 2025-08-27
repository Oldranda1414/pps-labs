package task2;

object NegativeGeneric extends App:
    val exampleString: String = "giovanni"
    val empty: (String => Boolean) = _ == ""
    val isEven: (Int => Boolean) = _ % 2 == 0

    def negative[X](predicate:(X => Boolean)) : (X => Boolean) =
        !predicate(_)

    
    println("apply negativeto empty")
    val negativeEmpty= negative(empty)
    println("apply negativeEmpty to exampleString, result is: " + negativeEmpty(exampleString))
    println("apply negativeEmpty to empty String, result is: " + negativeEmpty(""))

    println("apply negative to isEven")
    val negativeIsEven = negative(isEven)
    val exampleInt: Int = 4
    val exampleInt2: Int = 3
    println("apply negativeEmpty to exampleString, result is: " + negativeIsEven(exampleInt))
    println("apply negativeEmpty to empty String, result is: " + negativeIsEven(exampleInt2))