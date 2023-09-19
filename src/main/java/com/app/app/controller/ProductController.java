package com.app.app.controller;

import com.app.app.model.ProductoResponse;
import com.app.app.model.Productos;
import com.app.app.service.ProductServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServices ProductServices;

    @PostMapping
    public Productos createProduct(@RequestBody Productos product){
        return ProductServices.createProduct(product);
    }
    @GetMapping
    public List<ProductoResponse> getProduct()  {
        return ProductServices.getProducts();
    }

    @GetMapping("/test")
    public ResponseEntity<String> testApi()  {
        return ResponseEntity.ok("good");
    }

}
