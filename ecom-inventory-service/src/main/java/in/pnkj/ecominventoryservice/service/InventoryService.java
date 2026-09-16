package in.pnkj.ecominventoryservice.service;

import org.springframework.stereotype.Service;

import in.pnkj.ecominventoryservice.entity.Inventory;
import in.pnkj.ecominventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public Inventory getItem(Long productId) {
        return inventoryRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Item not found with id: " + productId));
    }

    public Inventory addItem(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public Inventory deductItemQuantity(Long productId, Long requireStock) {
        Inventory inventory = inventoryRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Item not found with id: " + productId));

        if (inventory.getQuantity() < requireStock) {
            throw new RuntimeException("Out of stock");
        }
        inventory.setQuantity(inventory.getQuantity() - requireStock);
        return inventoryRepository.save(inventory);
    }
}
