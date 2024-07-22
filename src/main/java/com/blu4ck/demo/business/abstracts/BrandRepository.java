package com.blu4ck.demo.business.abstracts;

import com.blu4ck.demo.dataAccess.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Integer> {

}
