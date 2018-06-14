package com.stockage.stockage.controller;

import com.stockage.stockage.exception.ResourceNotFoundException;
import com.stockage.stockage.model.*;
import com.stockage.stockage.repository.DeliveryStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/delivery_status")
public class DeliveryStatusController {

    @Autowired
    DeliveryStatusRepository deliveryStatusRepository;

    @GetMapping("/all")
    public List<delivery_status> getAllDeliveryLocations() {
        return deliveryStatusRepository.findAll();
    }

    @PostMapping("/insert")
    public delivery_status createDeliveryStatus(@Valid @RequestBody delivery_status deliveryStatus) {
        return deliveryStatusRepository.save(deliveryStatus);
    }

    @GetMapping("/get/{id}")
    public delivery_status getDeliveryStatusById(@PathVariable(value = "id") Integer delivery_status_id) {
        return deliveryStatusRepository.findById(delivery_status_id)
                .orElseThrow(() -> new ResourceNotFoundException("Delivery Status", "delivery_status_id", delivery_status_id));
    }

    @GetMapping("getByRewrite/{rewrite}")
    public delivery_status getDeliveryStatusByRewrite(@PathVariable(value = "rewrite") String rewrite) {
        return deliveryStatusRepository.getByRewrite(rewrite)
                .orElseThrow(() -> new ResourceNotFoundException("Delivery Status", "delivery_status_id", rewrite));
    }

    @PutMapping("/update/{id}")
    public delivery_status updateDeliveryStatus(@PathVariable(value = "id") Integer delivery_status_id, @Valid @RequestBody delivery_status deliveryStatus) {
        delivery_status ds = deliveryStatusRepository.findById(delivery_status_id)
                .orElseThrow(() -> new ResourceNotFoundException("Delivery Status", "delivery_status_id", delivery_status_id));

        ds.setDelivery_rewrite(deliveryStatus.getDelivery_rewrite());
        ds.setDelivery_description(deliveryStatus.getDelivery_description());

        return deliveryStatusRepository.save(ds);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDeliveryStatus(@PathVariable(value = "id") Integer delivery_status_id) {
        delivery_status ds = deliveryStatusRepository.findById(delivery_status_id)
                .orElseThrow(() -> new ResourceNotFoundException("Delivery Status", "delivery_status_id", delivery_status_id));

        deliveryStatusRepository.delete(ds);

        return ResponseEntity.ok().build();
    }
}
