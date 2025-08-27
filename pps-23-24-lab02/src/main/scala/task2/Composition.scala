package task2

object Composition extends App:
    def compose(f: Int => Int, g: Int => Int): Int => Int = (i: Int) => f(g(i))

    println(compose(_ - 1, _ * 2)(5))

    def genericCompose[X](f: X => X, g: X => X): X => X = (i: X) => f(g(i))

    println(genericCompose[Int](_ - 1, _ * 2)(5))