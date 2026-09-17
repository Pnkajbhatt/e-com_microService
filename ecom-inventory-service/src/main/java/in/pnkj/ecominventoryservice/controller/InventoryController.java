package in.pnkj.ecominventoryservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import in.pnkj.ecominventoryservice.dto.InventoryDtoResponse;
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
    public ResponseEntity<InventoryDtoResponse> Inventory(@PathVariable Long productId) {
        Inventory inventory = service.getItem(productId);
        return ResponseEntity.ok(InventoryDtoResponse.fromEntity(inventory));
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<InventoryDtoResponse> deductItem(@PathVariable Long productId,
            @RequestParam Long requiredStock) {
        Inventory inventory = service.deductItemQuantity(productId, requiredStock);
        return ResponseEntity.ok(InventoryDtoResponse.fromEntity(inventory));
    }

    @PostMapping("/item")
    public ResponseEntity<InventoryDtoResponse> AddItem(@RequestBody Inventory entity) {
        Inventory inventory = service.addItem(entity);
        return ResponseEntity.ok(InventoryDtoResponse.fromEntity(inventory));
    }

}
