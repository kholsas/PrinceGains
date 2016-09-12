package za.co.applications.princegains.shopping.shopping.dao;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import za.co.applications.princegains.shopping.shopping.model.Catalog;
import za.co.applications.princegains.shopping.shopping.model.OrderItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kholofelo on 2016/09/08.
 */

public class CatalogDAOImpl extends AbstractDao<Integer, Catalog> implements CatalogDAO {

    private static final CatalogDAO INSTANCE = new CatalogDAOImpl();

    public static CatalogDAO getInstance() {
        return INSTANCE;
    }

    public void saveCatalog(Catalog catalog) {
        Transaction transaction = getSession().beginTransaction();
        getSession().save(catalog);
        transaction.commit();
    }

    public void updateCatalog(Catalog catalog) {
        Transaction transaction = getSession().beginTransaction();
        getSession().update(catalog);
        transaction.commit();
    }

    public List<Catalog> getAllCatalogues() {
        Transaction transaction = getSession().beginTransaction();
        Criteria criteria = createEntityCriteria();
        List list =  criteria.list();
        transaction.commit();

        return list;
    }

    public Catalog getCatalogByCategory(Catalog.CatalogCategory category) {
        Transaction transaction = getSession().getTransaction();
        transaction.begin();
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("category", category.getValue()));
        Catalog catalog = (Catalog) criteria.uniqueResult();
        transaction.commit();
        return catalog;
    }

    public List<Catalog> getCatalogByName(String name) {
        Transaction transaction = getSession().beginTransaction();
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("name", name));
        List<Catalog> list = criteria.list();
        transaction.commit();
        return list;
    }

    public List<OrderItem> getAllCatalogItems() {
        Transaction transaction = getSession().beginTransaction();
        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        Criteria criteria = createEntityCriteria();

        for (Catalog catalog : (List<Catalog>) criteria.list()) {
            orderItems.addAll(catalog.getOrderItems());
        }
        transaction.commit();
        return orderItems;
    }
}
