package in.pnkj.ecominventoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pnkj.ecominventoryservice.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
