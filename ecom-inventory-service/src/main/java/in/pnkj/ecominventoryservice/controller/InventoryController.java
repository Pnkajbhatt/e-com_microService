package in.pnkj.ecominventoryservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pnkj.ecominventoryservice.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService service;

    InventoryController(InventoryService service) {
        this.service = service;
    }

    @GetMapping("/{productId}")
    public long InventoryQuantity(@PathVariable String productId) {
        return service.InventoryQuantity(productId);
    }
}
