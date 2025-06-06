package demo.webproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.webproject.Entity.CartItem;

@Repository
public interface CartRepository extends JpaRepository<CartItem, Long> {
    // Custom queries can be added here if needed
}
