package yusuf.panel.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import yusuf.panel.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

}
