error id: file:///C:/Projects/LearnJava/Learn_Scala/OnlineStoreApp.scala:scala/Unit#
file:///C:/Projects/LearnJava/Learn_Scala/OnlineStoreApp.scala
empty definition using pc, found symbol in pc: scala/Unit#
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -Unit#
	 -scala/Predef.Unit#
offset: 561
uri: file:///C:/Projects/LearnJava/Learn_Scala/OnlineStoreApp.scala
text:
```scala
// Interface (Trait) - Abstraction
trait PaymentMethod {
  def pay(amount: Double): Unit
}

// Abstract Class - Partial Implementation
abstract class Payment(val methodName: String) extends PaymentMethod {

  // Encapsulation (protected data)
  protected var totalPaid: Double = 0

  // Concrete method
  def printReceipt(amount: Double): Unit = {
    totalPaid += amount
    println(s"$methodName payment of $$amount successful")
  }
}

// Concrete Class - Inheritance + Override
class UpiPayment extends Payment("UPI") {
  override def pay(amount: Double): Un@@it = {
    printReceipt(amount)
  }
}

// Concrete Class - Inheritance + Override
class CardPayment extends Payment("Card") {
  override def pay(amount: Double): Unit = {
    printReceipt(amount)
  }
}

// Business Logic Class - Encapsulation
class Order(private val orderId: Int, private val amount: Double) {

  // Polymorphism: depends on interface
  def processPayment(payment: PaymentMethod): Unit = {
    println(s"Processing order $orderId")
    payment.pay(amount)
  }
}

// Singleton Object - Program Entry Point
object OnlineStoreApp {

  def main(args: Array[String]): Unit = {

    val order = new Order(101, 500.0)

    val upi: PaymentMethod = new UpiPayment()
    val card: PaymentMethod = new CardPayment()
    
    order.processPayment(upi)
    order.processPayment(card)

  }
}


```


#### Short summary: 

empty definition using pc, found symbol in pc: scala/Unit#