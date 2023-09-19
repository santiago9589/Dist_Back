package com.app.app.service;
import com.app.app.model.ProductoResponse;
import com.app.app.model.Productos;
import com.app.app.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServices {

    private final ProductRepository ProductRepository;
    public Productos createProduct(Productos product) {
        return ProductRepository.save( product);
    }

    public List<ProductoResponse> getProducts() {
        List<Productos> products = ProductRepository.findAll();

        List<ProductoResponse> productsResponse = products.stream()
                
                .map(product -> {
                    try {

                        String imageName = product.getImage();
                        Resource imageResource = new ClassPathResource("static/"+ imageName);

                        return new ProductoResponse(
                                product.getIdProduct(),
                                product.getNombre(),
                                product.getDescripcion(),
                                Files.readAllBytes(imageResource.getFile().toPath()),
                                product.getCategoria()
                        );
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());

        return productsResponse;
    }
    public List<Productos> getProductsTest() {
        return ProductRepository.findAll();
    }


}


