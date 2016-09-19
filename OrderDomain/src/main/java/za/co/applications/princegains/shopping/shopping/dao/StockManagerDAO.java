package za.co.applications.princegains.shopping.shopping.dao;

import za.co.applications.princegains.shopping.shopping.model.StockItem;

/**
 * Created by kholofelo on 2016/09/19.
 */
public interface StockManagerDAO {

    void saveStockItem(StockItem stockItem);
    void updateStockItem(StockItem stockItem);
}
