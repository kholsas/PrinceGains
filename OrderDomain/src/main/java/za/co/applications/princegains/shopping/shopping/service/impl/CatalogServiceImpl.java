package za.co.applications.princegains.shopping.shopping.service.impl;


import za.co.applications.princegains.shopping.shopping.dao.CatalogDAO;
import za.co.applications.princegains.shopping.shopping.dao.CatalogDAOImpl;
import za.co.applications.princegains.shopping.shopping.model.Catalog;
import za.co.applications.princegains.shopping.shopping.model.CatalogItem;
import za.co.applications.princegains.shopping.shopping.model.StockItem;
import za.co.applications.princegains.shopping.shopping.service.CatalogService;

import java.util.List;
import java.util.Set;

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


    public List<Catalog> getCatalogByName(String name) {
        return catalogDAO.getCatalogByName(name);
    }

    public void createCatalog(Catalog catalog) {
        catalogDAO.saveCatalog(catalog);
    }

    public void updateCatalog(Catalog catalog) {
        catalogDAO.updateCatalog(catalog);
    }

    public List<CatalogItem> getAllCatalogItems() {
        return catalogDAO.getAllCatalogItems();
    }
}
