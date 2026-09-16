package in.pnkj.ecominventoryservice.dto;

import in.pnkj.ecominventoryservice.entity.Inventory;

public record InventoryDtoResponse(
                Long productId,
                String productName,
                Long quantity)

{
        public static InventoryDtoResponse fromEntity(Inventory entity) {
                return new InventoryDtoResponse(entity.getProductId(), entity.getProductName(), entity.getQuantity());
        }
}
