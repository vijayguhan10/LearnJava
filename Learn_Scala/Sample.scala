case class User(name: String, age: Int)

object Sample extends App {
  val u1 = User("vijay", 20)
  val u2 = u1.copy(age = 22)

  println(u1)
  println(u2)
//   def greet(user: User): String = {

//   User.unapply(user) match {

//     case Some(("Vijay", age)) =>
//       s"Admin Vijay, age $age"

//     case Some((name, age)) =>
//       s"Hello $name, age $age"
//   }
// }
  def greet(emp:User):String=emp match{
    case User("Vijay",age)=>s"Vijay Is matched properly"
    case User(name,age)=>s"$name is printing"
  }
  println(greet(u1))
}