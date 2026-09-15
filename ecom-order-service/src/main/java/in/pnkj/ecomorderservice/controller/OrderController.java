package in.pnkj.ecomorderservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pnkj.ecomorderservice.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/{ProductId}")
    public ResponseEntity<String> placeOrder(@PathVariable String ProductId) {
        return ResponseEntity.ok(orderService.placeOrder(ProductId));
    }
}
