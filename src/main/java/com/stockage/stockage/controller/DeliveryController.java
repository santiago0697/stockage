package com.stockage.stockage.controller;

import com.stockage.stockage.exception.ResourceNotFoundException;
import com.stockage.stockage.model.delivery;
import com.stockage.stockage.model.delivery_status;
import com.stockage.stockage.model.products;
import com.stockage.stockage.repository.DeliveryRepository;
import com.stockage.stockage.repository.DeliveryStatusRepository;
import com.stockage.stockage.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    @Autowired
    DeliveryRepository deliveryRepository;
    @Autowired
    DeliveryStatusRepository deliveryStatusRepository;
    @Autowired
    ProductsRepository productsRepository;

    @GetMapping("/all")
    public List<delivery> getAll() {
        return deliveryRepository.findAll();
    }

    @PostMapping("/create/products_id/{products_id}/deliveryStatus/{delivery_status_id}")
    public delivery createDelivery(@PathVariable(value = "products_id") Integer products_id,
                                   @PathVariable(value = "delivery_status_id") Integer delivery_status_id,
                                   @Valid @RequestBody delivery delivery) {

        products p = productsRepository.findById(products_id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "products_id", products_id));
        delivery_status ds = deliveryStatusRepository.findById(delivery_status_id)
                .orElseThrow(() -> new ResourceNotFoundException("Delivewry Status", "deliveryk_status_id", delivery_status_id));

        delivery.setProducts_id(p);
        delivery.setDelivery_status_id(ds);

        return deliveryRepository.save(delivery);
    }

    @GetMapping("/get/{delivery_id}")
    public delivery getDelivery(@PathVariable(value = "delivery_id") Integer delivery_id) {
        return deliveryRepository.findById(delivery_id)
                .orElseThrow(() -> new ResourceNotFoundException("Delivery", "delivery_id", delivery_id));
    }

    @PutMapping("/updateStatus/{delivery_id}/delivery_status_id/{delivery_status_id}")
    public delivery updateDeliveryStatus(@PathVariable(value = "delivery_id") Integer delivery_id,
                                         @PathVariable(value = "delivery_status_id") Integer delivery_status_id) {

        delivery_status ds = deliveryStatusRepository.findById(delivery_status_id)
                .orElseThrow(() -> new ResourceNotFoundException("Delivewry Status", "deliveryk_status_id", delivery_status_id));

        delivery d = deliveryRepository.findById(delivery_id)
                .orElseThrow(() -> new ResourceNotFoundException("Delivery", "delivery_id", delivery_id));

        d.setDelivery_status_id(ds);

        return deliveryRepository.save(d);
    }
}
