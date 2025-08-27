package task2

object Currying extends App:
    val p1: Int => Int => Int => Boolean = x => y => z => x<=y && y==z

    val p2 = (x: Int, y: Int, z: Int) => x<=y && y==z

    def p3(x: Int)(y: Int)(z: Int): Boolean = x<=y && y==z

    def p4(x: Int, y: Int, z:Int): Boolean = x<=y && y==z

    val x: Int = 1
    val y: Int = 2
    val z: Int = 3

    println("Testing p1: ")
    println(p1(x)(y)(y))
    println(p1(x)(y)(z))
    println("Testing p2: ")
    println(p2(x, y, y))
    println(p2(x, y, z))
    println("Testing p3: ")
    println(p3(x)(y)(y))
    println(p3(x)(y)(z))
    println("Testing p4: ")
    println(p4(x, y, y))
    println(p4(x, y, z))