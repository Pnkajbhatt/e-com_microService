package in.pnkj.ecomorderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import in.pnkj.ecomorderservice.dto.InventoryDtoResponse;

@FeignClient(name = "ecom-inventory-service")
public interface InventoryClient {

    @GetMapping("/inventory/{productId}")
    InventoryDtoResponse getInventory(@PathVariable Long productId);

    @PatchMapping("/inventory/{productId}")
    InventoryDtoResponse decreaseStock(@PathVariable("productId") Long productId,
            @RequestParam("requiredStock") Long requiredStock);
}
