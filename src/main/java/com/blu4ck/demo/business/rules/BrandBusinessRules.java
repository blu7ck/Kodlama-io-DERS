package com.blu4ck.demo.business.rules;

import com.blu4ck.demo.core.utilities.exceptions.BusinessException;
import com.blu4ck.demo.dataAccess.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandBusinessRules {
    private BrandRepository brandRepository;

    public void CheckIfBrandNameExists(String name){
        if(this.brandRepository.existsByName(name)){
            throw new BusinessException("Brand name already exist");
        }
    }
}
