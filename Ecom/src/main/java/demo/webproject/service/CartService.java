package demo.webproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import demo.webproject.Entity.CartItem;
import demo.webproject.repository.CartRepository;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<CartItem> getCartItems() {
        return cartRepository.findAll();
    }

    public CartItem addCartItem(CartItem item) {
        // Optionally, add logic for checking existing product & updating quantity if needed
        return cartRepository.save(item);
    }

    public void removeCartItem(Long productId) {
        cartRepository.deleteById(productId);
    }

    public void clearCart() {
        cartRepository.deleteAll();
    }
}
