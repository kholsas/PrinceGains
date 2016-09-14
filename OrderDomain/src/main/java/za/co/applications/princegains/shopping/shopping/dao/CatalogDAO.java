package za.co.applications.princegains.shopping.shopping.dao;


import za.co.applications.princegains.shopping.shopping.model.Catalog;
import za.co.applications.princegains.shopping.shopping.model.CatalogItem;
import za.co.applications.princegains.shopping.shopping.model.StockItem;

import java.util.List;
import java.util.Set;

public interface CatalogDAO {

    void saveCatalog(Catalog catalog);
    void updateCatalog(Catalog catalog);

    Set<Catalog> getAllCatalogues();

    Set<Catalog> getCatalogByName(String name);

    Set<CatalogItem> getAllCatalogItems();
}
