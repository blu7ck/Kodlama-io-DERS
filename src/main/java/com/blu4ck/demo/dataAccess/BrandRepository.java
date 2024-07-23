package com.blu4ck.demo.dataAccess;

import com.blu4ck.demo.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Integer> {
    boolean existsByName(String name);
}