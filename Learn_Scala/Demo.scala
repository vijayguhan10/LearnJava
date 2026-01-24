object Demo {
  def main(args: Array[String]): Unit = {
    val x = "vijay";
    println(x);
    val Numbers = List(1, 2, 3, 4, 5)
    Numbers.foreach(a => println(a))
    Numbers.filter(p => p > 1).foreach(println);
    Numbers.map(_ * 2).foreach(println)
    
    println("sum        = " + Numbers.sum) // sum        = 15
    println("product    = " + Numbers.product) // product    = 120
    println("min        = " + Numbers.min) // min        = 1
    println("max        = " + Numbers.max) // max        = 5

    println("size       = " + Numbers.size) // size       = 5
    println("count > 2  = " + Numbers.count(_ > 2)) // count > 2  = 3
    
    println("exists > 3 = " + Numbers.exists(_ > 3)) // exists > 3 = true
    println("forall > 0 = " + Numbers.forall(_ > 0)) // forall > 0 = true
    println("find > 3   = " + Numbers.find(_ > 3)) // find > 3   = Some(4)
    println("head       = " + Numbers.head) // head       = 1
    println("last       = " + Numbers.last) // last       = 5
    println("headOption = " + Numbers.headOption) // headOption = Some(1)
    println("lastOption = " + Numbers.lastOption) // lastOption = Some(5)

    println("reduce +   = " + Numbers.reduce(_ + _)) // reduce +   = 15
    println("fold +     = " + Numbers.fold(0)(_ + _)) // fold +     = 15

    println(
      "mkString   = " + Numbers.mkString("# ")
    ) // mkString   = 1, 2, 3, 4, 5\
    // METHOD (named function / method definition)
    // def aa(a: Int, b: Int): Int = {
    //   return a + b
    // }

// METHOD (expression-bodied method)
    // def aa(a: Int, b: Int): Int = a + b

// FUNCTION VALUE (lambda / anonymous function)
// Type: (Int, Int) => Int   === Function2[Int, Int, Int]
    val aa = (a: Int, b: Int) => a + b

    println(aa(1, 1)) // 2

  }
}
ld1
normali,j-coll,-btree,shardings,sortings,os-ba
l2
dsa,sql,java-colls


