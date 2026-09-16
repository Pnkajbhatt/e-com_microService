package in.pnkj.ecomorderservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pnkj.ecomorderservice.service.OrderService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/{ProductId}")
    public ResponseEntity<String> placeOrder(@PathVariable String ProductId) {
        return ResponseEntity.ok(orderService.placeOrder(ProductId));
    }

}
