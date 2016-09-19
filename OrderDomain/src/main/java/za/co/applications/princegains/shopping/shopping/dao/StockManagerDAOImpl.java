package za.co.applications.princegains.shopping.shopping.dao;

import org.hibernate.Transaction;
import za.co.applications.princegains.shopping.shopping.model.StockItem;


/**
 * Created by kholofelo on 2016/09/19.
 */
public class StockManagerDAOImpl extends AbstractDao<Integer, StockItem> implements StockManagerDAO {

    private static final StockManagerDAO INSTANCE = new StockManagerDAOImpl();

    private StockManagerDAOImpl(){

    }
    public static StockManagerDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public void saveStockItem(StockItem stockItem) {
        Transaction transaction = getSession().beginTransaction();
        getSession().saveOrUpdate(stockItem);
        transaction.commit();

    }

    @Override
    public void updateStockItem(StockItem stockItem) {
        Transaction transaction = getSession().beginTransaction();
        getSession().update(stockItem);
        transaction.commit();
    }
}
