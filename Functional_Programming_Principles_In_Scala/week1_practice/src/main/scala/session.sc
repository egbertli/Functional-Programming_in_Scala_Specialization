object session {
  1 + 2
  def abs(x: Double) = if (x < 0) -x else x
  def sqrt(x: Double) = {
    def sqrtItr(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtItr(improve(guess))

    def isGoodEnough(guess: Double) =
      abs(guess * guess - x) / x < 0.001

    def improve(guess: Double): Double =
      (guess + x / guess) / 2

    sqrtItr(1.0)
  }

  sqrt(2)
  sqrt(4)
  sqrt(0.1e-20)
  sqrt(1e20)

  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  gcd(14, 21)
  gcd(21, 14)

  def factorial(n: Int): Int =
    if (n == 0) 1 else n * factorial(n - 1)

  factorial(6)
}