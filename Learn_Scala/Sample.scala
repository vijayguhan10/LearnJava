case class User(name: String, age: Int)

object Sample extends App {
  val u1 = User("vijay", 20)
  val u2 = u1.copy(age = 22)

  println(u1)
  println(u2)
}