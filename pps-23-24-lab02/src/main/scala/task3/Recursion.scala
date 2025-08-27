package task3

import scala.math.pow

object Recursion extends App:
    def gcd(a: Double, b: Double): Double = 
        b match
            case 0 => a
            case _ => gcd(b, a % b)


    println(gcd(127, 127 * 2))
    println(gcd(127, pow(127, 2)))
        
    def gcdTail(a: Double, b: Double): Double = 
        @annotation.tailrec
        def _gcd(a: Double, b: Double, acc: Double): Double =
            b match
                case 0 => a * acc
                case _ => _gcd(b, a % b, acc)
        _gcd(a, b, 1)

    println(gcdTail(127, 127 * 2))
    println(gcdTail(127, pow(127, 2)))
    println(gcdTail(99, 66))
            