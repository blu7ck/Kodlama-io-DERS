package com.blu4ck.demo.business.abstracts;

import com.blu4ck.demo.business.requests.CreateBrandRequest;
import com.blu4ck.demo.business.requests.UpdateBrandRequest;
import com.blu4ck.demo.business.responses.GetAllBrandResponse;
import com.blu4ck.demo.business.responses.GetByIdBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandResponse> getAll();
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);
    GetByIdBrandResponse getById(int id);

}
