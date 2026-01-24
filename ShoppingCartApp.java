import java.util.ArrayList;
import java.util.List;

// ===== Product =====
class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

// ===== Cart Item =====
class CartItem {
    Product product;
    int quantity;

    CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    double getTotal() {
        return product.price * quantity;
    }
}

// ===== Shopping Cart =====
class ShoppingCart {
    List<CartItem> items = new ArrayList<>();

    void addItem(Product product, int quantity) {
        items.add(new CartItem(product, quantity));
    }

    double calculateTotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getTotal();
        }
        return total;
    }
}

// ===== Main =====
public class ShoppingCartApp {
    public static void main(String[] args) {

        Product phone = new Product(1, "Phone", 15000);
        Product laptop = new Product(2, "Laptop", 50000);

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(phone, 2);
        cart.addItem(laptop, 1);

        System.out.println("Total Amount = ₹" + cart.calculateTotal());
    }
}
