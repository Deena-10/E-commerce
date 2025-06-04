package demo.webproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.webproject.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
