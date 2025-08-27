package labResult

object LabResult extends App:

    //Task 1 Hello World

    println("Task 1: Hello World")

    println("Hello World, but in scala")

    print("\n\n")

    //Task 2a Functions

    println("Task 2: Functions")

    //Task 2a a

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

    //Task 2a b

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

    //Task 2a c 

    val exampleStringGen: String = "giovanni"
    val emptyGen: (String => Boolean) = _ == ""
    val isEven: (Int => Boolean) = _ % 2 == 0

    def negative[X](predicate:(X => Boolean)) : (X => Boolean) =
        !predicate(_)

    
    println("apply negativeto empty")
    val negativeEmptyGen= negative(emptyGen)
    println("apply negativeEmpty to exampleString, result is: " + negativeEmptyGen(exampleStringGen))
    println("apply negativeEmpty to empty String, result is: " + negativeEmptyGen(""))

    println("apply negative to isEven")
    val negativeIsEven = negative(isEven)
    val exampleInt: Int = 4
    val exampleInt2: Int = 3
    println("apply negativeEmpty to exampleString, result is: " + negativeIsEven(exampleInt))
    println("apply negativeEmpty to empty String, result is: " + negativeIsEven(exampleInt2))

    //Task 2b 4 Currying

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

    //Task 2b 5 functional compositions

    def compose(f: Int => Int, g: Int => Int): Int => Int = (i: Int) => f(g(i))

    println("testing composition: " + compose(_ - 1, _ * 2)(5))

    def genericCompose[X](f: X => X, g: X => X): X => X = (i: X) => f(g(i))

    println("testing generic composition: " + genericCompose[Int](_ - 1, _ * 2)(5))

    print("\n\n")

    //Task 3 recursion

    println("Task 3: Recursion")

    import scala.math.pow

    def gcd(a: Double, b: Double): Double = 
        b match
            case 0 => a
            case _ => gcd(b, a % b)


    println("calculating gcd of 127 and 127*2: " + gcd(127, 127 * 2))
    println("calculating gcd of 127 and 127^2: " + gcd(127, pow(127, 2)))
        
    def gcdTail(a: Double, b: Double): Double = 
        @annotation.tailrec
        def _gcd(a: Double, b: Double, acc: Double): Double =
            b match
                case 0 => a * acc
                case _ => _gcd(b, a % b, acc)
        _gcd(a, b, 1)

    println("calculating gcdTail of 127 and 127*2: " + gcdTail(127, 127 * 2))
    println("calculating gcdTail of 127 and 127^2: " + gcdTail(127, pow(127, 2)))
    println("calculating gcdTail of 99 and 66: " + gcdTail(99, 66))

    print("\n\n")

    //Task 4 (sum types, product types, modules)

    println("Task 4: sum types, product types, modules")

    import scala.math.Pi
    import scala.math.pow
    import scala.math.sqrt

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
        
    println("Calculating perimeter of simple rectangle: " + perimeter(Shape.Square(DoublePair(1, 1), DoublePair(2,1), DoublePair(2, 2), DoublePair(1, 2))))
    val circle = Shape.Circle(DoublePair(0, 0), 1)
    println("Calculating perimeter of unit circle: " + perimeter(circle))
    println("Testing scale function, calculating perimeter of unit circle scaled by 2: " + perimeter(scale(circle, 2)))

    print("\n\n")
    
//Task 5 more functional combinators

object Optionals:
  /**
   * Optional is a type that represents a value that may or may not be present.
   * Similar to Optional in Java but using the ADT concept.
   * Therefore, an Optional is a sum type with two cases: Maybe and Empty.
   * Maybe contains the value, and Empty represents the absence of a value.
   *
   * @tparam A
   */
  enum Optional[+A]:
    case Maybe(value: A)
    case Empty()

  object Optional:
    /**
     * isEmpty returns true if the optional is Empty, false otherwise.
     * Example:
     *
     * isEmpty(Empty()) == true
     * isEmpty(Maybe(1)) == false
     *
     * @param optional the optional to check
     * @tparam A the type of the optional
     * @return true if the optional is Empty, false otherwise
     */
    def isEmpty[A](optional: Optional[A]): Boolean = optional match
      case Empty() => true
      case _ => false

    /**
     *
     * getOrElse returns the value of the optional if it is Maybe, otherwise it returns the default value.
     * Example:
     * orElse(Maybe(1), 0) == 1
     * orElse(Empty(), 0) == 0
     *
     * @param optional the optional to get the value from
     * @param default the default value to return if the optional is Empty
     * @tparam A the type of the optional
     * @tparam B the type of the default value
     * @return the value of the optional if it is Maybe, otherwise the default value
     */
    def orElse[A, B >: A](optional: Optional[A], default: B): B = optional match
      case Maybe(value) => value
      case Empty() => default

    /**
     * map applies the function f to the value of the optional if it is Maybe, otherwise it returns Empty.
     * Example:
     *
     * map(Maybe(1), (x: Int) => x + 1) == Maybe(2)
     * map(Empty(), (x: Int) => x + 1) == Empty()
     *
     *
     * @param optional the optional to apply the function to
     * @param f the function to apply to the value of the optional
     * @tparam A the type of the optional
     * @tparam B the type of the result of the function
     * @return the result of applying the function to the value of the optional if it is Maybe, otherwise Empty
     */
    def map[A, B](optional: Optional[A], f: A => B): Optional[B] = optional match
      case Maybe(value) => Maybe(f(value))
      case Empty() => Empty()

    /**
      * a function that keeps the value (if present, otherwise the output is Empty) only if it satisfies the given predicate
      *
      * @param optional the optional to apply the function to
      * @param f the predicate
      * @tparam A the type of the optional
      * @return optional or Empty depending on the result of the predicate applied to the Optional's value
      */
    def filter[A](optional: Optional[A], f: A => Boolean): Optional[A] = optional match
      case Maybe(value) => value match
        case n if f(n) => Maybe(value)
        case _ => Empty()
      case _ => Empty()