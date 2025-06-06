package demo.webproject.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import demo.webproject.Entity.CartItem;
import demo.webproject.service.CartService;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // GET: Fetch all items in the cart
    @GetMapping
    public List<CartItem> getCartItems() {
        return cartService.getCartItems();
    }

    // POST: Add a new item to the cart
    @PostMapping("/add")
    public void addToCart(@RequestBody CartItemRequest request) {
        CartItem item = new CartItem(request.getProductId(), request.getQuantity());
        cartService.addCartItem(item);
    }

    // Optional: Clear the cart (if needed)
    @DeleteMapping("/clear")
    public void clearCart() {
        cartService.clearCart();
    }

    // DTO class for receiving request payload
    public static class CartItemRequest {
        private Long productId;
        private int quantity;

        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
