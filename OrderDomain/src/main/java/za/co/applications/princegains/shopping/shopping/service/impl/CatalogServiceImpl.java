package za.co.applications.princegains.shopping.shopping.service.impl;


import za.co.applications.princegains.shopping.shopping.dao.CatalogDAO;
import za.co.applications.princegains.shopping.shopping.dao.CatalogDAOImpl;
import za.co.applications.princegains.shopping.shopping.model.Catalog;
import za.co.applications.princegains.shopping.shopping.model.OrderItem;
import za.co.applications.princegains.shopping.shopping.service.CatalogService;

import javax.transaction.Transaction;
import java.util.List;

/**
 * Created by kholofelo on 2016/09/08.
 */
public class CatalogServiceImpl implements CatalogService {


    private CatalogDAO catalogDAO = CatalogDAOImpl.getInstance();

    private static final CatalogService INSTANCE = new CatalogServiceImpl();

    public static CatalogService getInstance() {
        return INSTANCE;
    }

    public List<Catalog> getAllCatalogues() {
        return catalogDAO.getAllCatalogues();
    }

    public Catalog getCatalogByCategory(Catalog.CatalogCategory category) {
        return catalogDAO.getCatalogByCategory(category);
    }

    public List<Catalog> getCatalogByName(String name) {
        return catalogDAO.getCatalogByName(name);
    }

    public void createCatalog(Catalog catalog) {
        catalogDAO.saveCatalog(catalog);
    }

    public void updateCatalog(Catalog catalog) {
        catalogDAO.updateCatalog(catalog);
    }

    public List<OrderItem> getAllCatalogItems() {
        return catalogDAO.getAllCatalogItems();
    }
}
