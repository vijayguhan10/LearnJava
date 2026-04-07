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
    for(n<-nums if n%2==0){
        println(s"for loop with filters : $n");
    }
    val result = for(n<-nums)yield n*2;
    println(s"Loop working with the Yield : $n");
  }
  def maps():Unit={
    nums=List(1,2,3)
    val result=nums.flatMap(x=>List(x,x*2))
    println(s"Nested Flatmaps : $result")
  }
  maps();
}
