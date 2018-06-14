package com.stockage.stockage.controller;

import com.stockage.stockage.exception.ResourceNotFoundException;
import com.stockage.stockage.model.locations;
import com.stockage.stockage.model.products;
import com.stockage.stockage.model.providers;
import com.stockage.stockage.reports.Reports;
import com.stockage.stockage.repository.LocationsRepository;
import com.stockage.stockage.repository.ProductsRepository;
import com.stockage.stockage.repository.ProvidersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    ProvidersRepository providersRepository;
    @Autowired
    LocationsRepository locationsRepository;

    // Get all providers
    @GetMapping("/all")
    public List<products> getAllProducts() {
        return productsRepository.findAll();
    }

    // Create new Provider
    @PostMapping("/insert/provider/{provider_id}/location/{location_id}")
    public products createProduct(@PathVariable(value = "provider_id") Integer provider_id,
                                  @PathVariable(value = "location_id") Integer location_id,
                                  @Valid @RequestBody products products) {
        providers provider = providersRepository.findById(provider_id)
                .orElseThrow(() -> new ResourceNotFoundException("Provider", "provider_id", provider_id));

        locations location = locationsRepository.findById(location_id)
                .orElseThrow(() -> new ResourceNotFoundException("Location", "id", location_id));

        products.setProvider(provider);
        products.setLocation(location);

        return productsRepository.save(products);
    }

    // Get single provider by ID
    @GetMapping("/get/{id}")
    public products getProductById(@PathVariable(value = "id") Integer product_id) {
        return productsRepository.findById(product_id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", product_id));
    }

    // Update provider
    @PutMapping("/update/{id}")
    public products updateProduct(@PathVariable(value = "id") Integer product_id, @Valid @RequestBody products newProduct) {
        products p = productsRepository.findById(product_id)
                .orElseThrow(() -> new ResourceNotFoundException("Products", "products_id", product_id));

        p.setProducts_name(newProduct.getProducts_name());
        p.setProducts_description(newProduct.getProducts_description());
        p.setProducts_date_added(newProduct.getProducts_date_added());
        p.setProducts_status(newProduct.getProducts_status());
        p.setProducts_image(newProduct.getProducts_image());
        p.setProducts_qty(newProduct.getProducts_qty());

        return productsRepository.save(p);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") Integer product_id) {
        products p = productsRepository.findById(product_id)
                .orElseThrow(() -> new ResourceNotFoundException("Products", "products_id", product_id));

        productsRepository.delete(p);

        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/stockreport", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> testReport() throws IOException {

        ByteArrayInputStream bis = Reports.stockReport(getAllProducts());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=test.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
