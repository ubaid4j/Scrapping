package com.scrapper.vogaclosetScrapper.dao;

import com.scrapper.vogaclosetScrapper.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
}
