object exercise {
  def product(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 1
    else f(a) * product(f)(a + 1, b)

  product(x => x * x)(3, 4)

  def fact(n: Int) = product(x => x)(1, n)

  fact(5)

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))

  def productNew(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b)

  productNew(x => x * x)(3, 4)


  val tolerance = 0.0001

  def abs(d: Double): Double =
    if (d < 0) -d else d

  def isCloseEnough(x: Double, y: Double) =
    abs((x - y) / x) / x < tolerance

  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      println("guess = " + guess)
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }

  fixedPoint(x => x/2 + 1)(1)

  def sqrt(x: Double) =
    fixedPoint(y => (y + x / y) / 2)(1.0)

  sqrt(2)

  def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2

  def sqrt2(x: Double): Double =
    fixedPoint(averageDamp(y => x/y))(1)

  sqrt2(2)


  class Rational(x: Int, y: Int) {

    require(y != 0, "Denominator must not be zero!")
    def this(x: Int) = this(x, 1)

    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    private val g = gcd(x, y)
    //val numer = x / gcd(x, y)
    //val denom = y / gcd(x, y)
    def numer = x / g
    def denom = y / g

    def + (that: Rational) =
      new Rational(
        numer * that.denom + that.numer * denom,
        denom * that.denom
      )

    def unary_- : Rational = new Rational(-numer, denom)
    def < (that: Rational) = numer * that.denom < that.numer * denom

    def - (that: Rational) = this + -that
    def max(that: Rational) = if (this < that) that else this

    override def toString = numer + "/" + denom

  }

  //val x = new Rational(1, 2)
  //x.numer
  //x.denom

  def addRational(r: Rational, s: Rational): Rational =
    new Rational(
      r.numer * s.denom + s.numer * r.denom,
      r.denom * s.denom
    )

  def makeString(r: Rational) =
    r.numer + "/" + r.denom

  makeString(addRational(new Rational(1,2), new Rational(2, 3)))

  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)
  x + y + -z
  x + y
  x < y
  x max y
  new Rational(2)
  new Rational(1,2).numer

}