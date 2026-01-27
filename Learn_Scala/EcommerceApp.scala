// ========================================
// 1. Trait = Pure Interface (Abstraction)
// ========================================
trait Payment {
  def pay(amount: Double): Unit
  def refund(amount: Double): Unit
}


// ========================================
// 2. Trait with Concrete Method (Mixin)
// ========================================
trait Logger {
  def log(message: String): Unit = {
    println("[LOG] " + message)
  }
}


// ========================================
// 3. Abstract Class (Partial Implementation)
// Encapsulation + Shared Business Data
// ========================================
abstract class Order(private var totalAmount: Double) {

  // Encapsulation (private field)
  def getAmount(): Double = totalAmount

  protected def updateAmount(newAmount: Double): Unit = {
    totalAmount = newAmount
  }

  // Abstract method (must override)
  def placeOrder(): Unit
}


// ========================================
// 4. Child Class 1 (Inheritance + Overriding)
// ========================================
class OnlineOrder(amount: Double)
  extends Order(amount)
    with Logger {

  override def placeOrder(): Unit = {
    log("Placing Online Order...")
    println(s"Online Order placed worth ₹${getAmount()}")
  }
}


// ========================================
// 5. Child Class 2 (Inheritance + Overriding)
// ========================================
class StoreOrder(amount: Double)
  extends Order(amount)
    with Logger {

  override def placeOrder(): Unit = {
    log("Placing Store Pickup Order...")
    println(s"Store Order placed worth ₹${getAmount()}")
  }
}


// ========================================
// 6. Payment Implementations (Polymorphism)
// ========================================
class UpiPayment extends Payment with Logger {

  override def pay(amount: Double): Unit = {
    log("UPI Payment Started")
    println(s"Paid ₹$amount using UPI")
  }

  override def refund(amount: Double): Unit = {
    println(s"Refunded ₹$amount back via UPI")
  }
}

class CardPayment extends Payment with Logger {

  override def pay(amount: Double): Unit = {
    log("Card Payment Started")
    println(s"Paid ₹$amount using Credit/Debit Card")
  }

  override def refund(amount: Double): Unit = {
    println(s"Refunded ₹$amount back to Card ")
  }
}


// ========================================
// 7. Business Logic Service (Composition)
// ========================================
class OrderService(order: Order, payment: Payment) {

  def checkout(): Unit = {

    println("\n===== CHECKOUT STARTED =====")

    // Place Order
    order.placeOrder()

    // Payment Process
    payment.pay(order.getAmount())

    println("✅ Checkout Completed Successfully!")
  }
}


// ========================================
// 8. Main App (Runtime Polymorphism)
// ========================================
object EcommerceApp {

  def main(args: Array[String]): Unit = {

    // Polymorphism: Order reference → OnlineOrder object
    val order1: Order = new OnlineOrder(2500)

    // Polymorphism: Payment reference → UpiPayment object
    val payment1: Payment = new UpiPayment()

    val service1 = new OrderService(order1, payment1)
    service1.checkout()


    // Another Example
    val order2: Order = new StoreOrder(5000)
    val payment2: Payment = new CardPayment()

    val service2 = new OrderService(order2, payment2)
    service2.checkout()
  }
}
