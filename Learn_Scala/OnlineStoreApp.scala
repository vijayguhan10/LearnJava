// Simple Payment class
class Payment(method: String) {

  def pay(amount: Double): Unit = {
    println(s"$method payment of $$amount successful")
  }
}

// Order class
class Order(orderId: Int, amount: Double) {
  def processPayment(payment: Payment): Unit = {
    println(s"Processing order $orderId")
    payment.pay(amount)
  }
}

// Entry point
object OnlineStoreApp {
  def main(args: Array[String]): Unit = {
    val order = new Order(101, 500.0)

    val upiPayment = new Payment("UPI")
    val cardPayment = new Payment("Card")

    order.processPayment(upiPayment)
    order.processPayment(cardPayment)
  }
}


// tODAY Array Bs-on answers 
// tmrw sql:stack
// friday ooops : queue
// saturday : LL /SCALA/HLD
// SUNDAY : JAVA SPRING //DP
// MOONDAY : NON-LINEAR//DP
// TUESDAY : REVISION ON DSA 
// WENESDAY REVISION ON OOPS SQL /
