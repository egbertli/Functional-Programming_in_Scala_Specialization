object intsets {
  println("Welcome to the scala worksheet")
}

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean = {
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  }

  def incl(x: Int): IntSet = {
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this
  }

  override def toString = "{" + left + elem + right + "}"
  def union(other: IntSet): IntSet = ((left union right) union other) incl elem
}

class Empty extends IntSet {
  def contains(x: Int): Boolean = false

  def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)

  override def toString = "."
  def union(other: IntSet): IntSet = other

  trait List[T] {
    def isEmpty: Boolean
    def head: T
    def trail: List[T]
  }

  class Cons[T](val head: T, val tail: List[T]) extends List[T] {
    def isEmpty: Boolean = false
  }

  class Nil[T] extends List[T] {
    def isEmpty: Boolean = true
    def head = throw new NoSuchElementException("Nil.head")
    def tail = throw new NoSuchElementException("Nil.tail")
  }

  def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])
  singleton[Int](1)
  singleton[Boolean](true)

 object nth {
   def nth[T](n: Int, xs: List[T]): T =
     if (xs.isEmpth) throw new IndexOutOfBoundsException
     else if (n == 0) xs.head
     else nth(n - 1, xs.tail)
 }
}