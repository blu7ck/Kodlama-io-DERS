package com.blu4ck.demo.webApi.controllers;

import com.blu4ck.demo.business.abstracts.BrandService;
import com.blu4ck.demo.business.requests.CreateBrandRequest;
import com.blu4ck.demo.business.responses.GetAllBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
    private final BrandService brandService;

    @GetMapping("getAll")
    public List<GetAllBrandResponse> getAll(){
        return brandService.getAll();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody()CreateBrandRequest createBrandRequest){
        this.brandService.add(createBrandRequest);
    }
}
