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
        getSession().save(catalog);
        transaction.commit();
    }

    public void updateCatalog(final Catalog catalog) {
        Transaction transaction = getSession().beginTransaction();
        getSession().update(catalog);
        transaction.commit();
    }

    public Set<Catalog> getAllCatalogues() {
        Transaction transaction = getSession().beginTransaction();
        Criteria criteria = createEntityCriteria();
        Set<Catalog> catalogs = new HashSet<>(criteria.list());
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

    public Set<Catalog> getCatalogByName(final String name) {
        Transaction transaction = getSession().beginTransaction();
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("name", name));
        Set<Catalog> list = new HashSet<>(criteria.list());
        transaction.commit();
        return list;
    }

    public Set<CatalogItem> getAllCatalogItems() {
        Transaction transaction = getSession().beginTransaction();
        Set<CatalogItem> catalogItems = new HashSet<>();
        Criteria criteria = createEntityCriteria();

       /* for (Catalog catalog : (List<Catalog>) criteria.list()) {
            catalogItems.addAll(catalog.getCatalogItems());
        }*/
        transaction.commit();
        return catalogItems;
    }
}
