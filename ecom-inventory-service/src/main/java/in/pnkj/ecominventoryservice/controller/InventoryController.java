package in.pnkj.ecominventoryservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pnkj.ecominventoryservice.entity.Inventory;
import in.pnkj.ecominventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService service;

    @GetMapping("/{productId}")
    public String InventoryQuantity(@PathVariable Long productId) {
        Inventory entity = service.InventoryQuantity(productId);

        return (entity.getQuantity() >= 10) ? "stock avaiable" : "out of stock";
    }

    @PostMapping("/item")
    public ResponseEntity<Inventory> postMethodName(@RequestBody Inventory entity) {
        Inventory inventory = service.addItem(entity);
        return ResponseEntity.ok(inventory);
    }

}
