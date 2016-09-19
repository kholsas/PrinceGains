package za.co.applications.princegains.shopping.shopping.service.impl;

import za.co.applications.princegains.shopping.shopping.dao.StockManagerDAO;
import za.co.applications.princegains.shopping.shopping.dao.StockManagerDAOImpl;
import za.co.applications.princegains.shopping.shopping.model.StockItem;
import za.co.applications.princegains.shopping.shopping.service.StockItemManagerService;

/**
 * Created by kholofelo on 2016/09/19.
 */
public class StockItemManagerServiceImpl implements StockItemManagerService {
    private static final StockManagerDAO STOCK_MANAGER_DAO = StockManagerDAOImpl.getInstance();

    private static final StockItemManagerService INSTANCE = new StockItemManagerServiceImpl();

    private StockItemManagerServiceImpl() {
    }

    public static StockItemManagerService getInstance() {
        return INSTANCE;
    }

    @Override
    public void createStockItem(StockItem stockItem) {
        STOCK_MANAGER_DAO.saveStockItem(stockItem);
    }

    @Override
    public void updateStockItem(StockItem stockItem) {
        STOCK_MANAGER_DAO.updateStockItem(stockItem);
    }
}
