package com.blu4ck.demo.business.abstracts;

import com.blu4ck.demo.business.requests.CreateBrandRequest;
import com.blu4ck.demo.business.responses.GetAllBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandResponse> getAll();
    void add(CreateBrandRequest createBrandRequest);

}
