package Product;

import java.util.List;

public class WarehouseController {
    List<Warehouse> warehouseList;
    WarehouseSelectionStrategy warehouseSelectionStrategy;

    public WarehouseController(List<Warehouse> warehouses, WarehouseSelectionStrategy warehouseSelectionStrategy){
        this.warehouseList = warehouses;
        this.warehouseSelectionStrategy = warehouseSelectionStrategy;
    }

    public void addNewWarehouse(Warehouse warehouse){
        warehouseList.add(warehouse);
    }

    public void removeWarehouse(Warehouse warehouse){
        warehouseList.remove(warehouse);
    }

    public Warehouse selectWarehouse(WarehouseSelectionStrategy selectionStrategy){
        this.warehouseSelectionStrategy = selectionStrategy;
        return warehouseSelectionStrategy.selectWarehouse(warehouseList);
    }
}
