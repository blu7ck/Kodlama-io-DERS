package com.blu4ck.demo.business.abstracts;

import com.blu4ck.demo.business.requests.CreateModelRequest;
import com.blu4ck.demo.business.responses.GetAllModelsResponse;


import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
    void create(CreateModelRequest createModelRequest);
//    void delete(int id);
//    void update(UpdateModelRequest updateModelRequest);
//    GetByIdModelResponse getById(int id);

}
