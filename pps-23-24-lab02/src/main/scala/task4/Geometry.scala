package task4

import scala.math.sqrt
import scala.math.pow
import scala.math.Pi

object Geometry extends App:
    case class DoublePair(x: Double, y: Double)

    def euclidianDistance(p: DoublePair, q: DoublePair): Double = p match
        case DoublePair(px, py) => q match
            case DoublePair(qx, qy) => sqrt(pow(qx - px, 2) + pow(qy - py, 2))
        

    enum Shape:
        case Rectangle(a: DoublePair, b: DoublePair, c: DoublePair, d: DoublePair)
        case Circle(center: DoublePair, radius: Double)
        case Square(a: DoublePair, b: DoublePair, c: DoublePair, d: DoublePair)


    def perimeter(s: Shape): Double = s match
        case Shape.Rectangle(a, b, c, d) => (euclidianDistance(a, b) + euclidianDistance(b, c)) * 2
        case Shape.Circle(_, r) => 2 * r * Pi
        case Shape.Square(a, b, _, _) => 4 * euclidianDistance(a, b)
        
    def scale(s: Shape, scale: Double): Shape = s match
        case Shape.Rectangle(DoublePair(xa, ya), DoublePair(xb, yb), DoublePair(xc, yc), DoublePair(xd, yd)) =>
            Shape.Rectangle(DoublePair(xa * scale, ya * scale), DoublePair(xb * scale, yb * scale), DoublePair(xc * scale, yc * scale), DoublePair(xd * scale, yd * scale))
        case Shape.Circle(c, r) => Shape.Circle(c, r * scale)
        case Shape.Square(DoublePair(xa, ya), DoublePair(xb, yb), DoublePair(xc, yc), DoublePair(xd, yd)) =>
            Shape.Square(DoublePair(xa * scale, ya * scale), DoublePair(xb * scale, yb * scale), DoublePair(xc * scale, yc * scale), DoublePair(xd * scale, yd * scale))
        
    println(perimeter(Shape.Square(DoublePair(1, 1), DoublePair(2,1), DoublePair(2, 2), DoublePair(1, 2))))
    val circle = Shape.Circle(DoublePair(0, 0), 1)
    println(perimeter(circle))
    println(perimeter(scale(circle, 2)))
    