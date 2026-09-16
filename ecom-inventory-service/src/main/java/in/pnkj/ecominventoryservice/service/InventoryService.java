package in.pnkj.ecominventoryservice.service;

import org.springframework.stereotype.Service;

import in.pnkj.ecominventoryservice.entity.Inventory;
import in.pnkj.ecominventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public Inventory InventoryQuantity(Long productId) {
        return inventoryRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Item not found with id: " + productId));
    }

    public Inventory addItem(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }
}
