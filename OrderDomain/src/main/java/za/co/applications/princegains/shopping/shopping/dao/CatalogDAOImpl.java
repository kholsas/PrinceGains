package za.co.applications.princegains.shopping.shopping.dao;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import za.co.applications.princegains.shopping.shopping.model.Catalog;
import za.co.applications.princegains.shopping.shopping.model.CatalogItem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by kholofelo on 2016/09/08.
 */

public class CatalogDAOImpl extends AbstractDao<Integer, Catalog> implements CatalogDAO {

    private static final CatalogDAO INSTANCE = new CatalogDAOImpl();

    public static CatalogDAO getInstance() {
        return INSTANCE;
    }

    public void saveCatalog(final Catalog catalog) {
        Transaction transaction = getSession().beginTransaction();
        getSession().saveOrUpdate(catalog);
        transaction.commit();
    }

    public void updateCatalog(final Catalog catalog) {
        Transaction transaction = getSession().beginTransaction();
        getSession().update(catalog);
        transaction.commit();
    }

    public List<Catalog> getAllCatalogues() {
        Transaction transaction = getSession().beginTransaction();
        Criteria criteria = createEntityCriteria();
        List<Catalog> catalogs = criteria.list();
        transaction.commit();

        return catalogs;
    }

/*
    public Catalog getCatalogByCategory(final Catalog.CatalogCategory category) {
        Transaction transaction = getSession().getTransaction();
        transaction.begin();
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("category", category.getValue()));
        Catalog catalog = (Catalog) criteria.uniqueResult();
        transaction.commit();
        return catalog;
    }
*/

    public List<Catalog> getCatalogByName(final String name) {
        Transaction transaction = getSession().beginTransaction();
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("name", name));
        List<Catalog> list = criteria.list();
        transaction.commit();
        return list;
    }

    public List<CatalogItem> getAllCatalogItems() {
        Transaction transaction = getSession().beginTransaction();
        List<CatalogItem> catalogItems = new ArrayList<>();
        Criteria criteria = createEntityCriteria();

        for (Catalog catalog : (List<Catalog>) criteria.list()) {
            catalogItems.addAll(catalog.getCatalogItems());
        }
        transaction.commit();
        return catalogItems;
    }

    @Override
    public List<CatalogItem> getAllCatalogItemsByCategory(String category) {
        Transaction transaction = getSession().beginTransaction();
        List<CatalogItem> catalogItems = new ArrayList<>();
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("stockItem.stockCategory",category.toUpperCase()));
        for (Catalog catalog : (List<Catalog>) criteria.list()) {
            catalogItems.addAll(catalog.getCatalogItems());
        }
        transaction.commit();
        return catalogItems;    }
}
