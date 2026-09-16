package in.pnkj.ecomorderservice.service;

import org.springframework.stereotype.Service;

import in.pnkj.ecomorderservice.client.InventoryClient;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    // private final RestClient restClient;
    private final InventoryClient inventoryClient;

    public String placeOrder(Long productId) {
        Long productQuantity = inventoryClient.getInventory(productId).quantity();
        if(productQuantity == null || productQuantity < 1 ){
            return "out of Stock" ;
        }
        
       inventoryClient.decreaseStock(productId, 1L);
       return "Order placed successfully";

    }
}
