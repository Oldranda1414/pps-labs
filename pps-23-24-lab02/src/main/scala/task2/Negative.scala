package task2

object Negative extends App:
    val exampleString: String = "giovanni"
    def empty: (String) => Boolean = _ == ""

    val negativeVal: (String => Boolean) => (String => Boolean) = 
         pred => (i) => !pred(i)


    println("apply negativeVal to empty")
    val negativeEmptyVal = negativeVal(empty)
    println("apply negativeEmptyVal to exampleString, result is: " + negativeEmptyVal(exampleString))
    println("apply negativeEmptyVal to empty String, result is: " + negativeEmptyVal(""))


    def negative: (String => Boolean) => (String => Boolean) =
        pred => !pred(_)
    
    println("apply negativeVal to empty")
    val negativeEmpty= negative(empty)
    println("apply negativeEmpty to exampleString, result is: " + negativeEmpty(exampleString))
    println("apply negativeEmpty to empty String, result is: " + negativeEmpty(""))