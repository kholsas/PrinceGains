package za.co.applications.princegains.shopping.shopping.service;

import za.co.applications.princegains.shopping.shopping.model.StockItem;

/**
 * Created by kholofelo on 2016/09/19.
 */
public interface StockItemManagerService {

    void createStockItem(StockItem stockItem);
    void updateStockItem(StockItem stockItem);
}
