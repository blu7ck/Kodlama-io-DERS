package com.blu4ck.demo.dataAccess;

import com.blu4ck.demo.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Integer> {
}
