case class User(name: String, age: Int)
case class Cust(userId: Int, name: String)
case class Orders(userId: Int, Product: String)

object Sample extends App {
  val u1 = User("vijay", 20)
  val u2 = u1.copy(age = 22)

  println(u1)
  println(u2)

  def greet(emp: User): String = emp match {
    case User("Vijay", age) => s"Vijay Is matched properly"
    case User(name, age)    => s"$name is printing"
  }
  println(greet(u1))

  val nums = List(1, 2, 3)

  def forloops(): Unit = {
    val nums = List(1, 2, 3, 4, 5)

    for (n <- nums) {
      println(s"Nubmers :$n")
    }

    for (n <- nums if n % 2 == 0) {
      println(s"for loop with filters : $n")
    }

    val result = for (n <- nums) yield n * 2
    println(s"Loop working with the Yield : $result")
  }

  def maps(): Unit = {
    val nums = List(1, 2, 3) // fixed reassignment issue
    val result = nums.flatMap(x => List(x, x * 2))
    println(s"Nested Flatmaps : $result")
  }
  maps()

  def for_comp(): Unit = {
    val customers = List(
      Cust(1, "Vijay"),
      Cust(2, "sabari"),
      Cust(3, "guhan"),
      Cust(3, "ragav"),
      Cust(4, "kumar"),
      Cust(5, "raj")
    )

    val products = List(
      Orders(1, "Laptop"),
      Orders(3, "Grinder")
    )

    val result = for {
      cust <- customers
      order <- products if cust.userId == order.userId
    } yield (cust.name, order.Product)

    println(result)
  }

  forloops()
  for_comp()
}
