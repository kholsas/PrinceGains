package za.co.applications.princegains.shopping.shopping.dao;


import za.co.applications.princegains.shopping.shopping.model.Catalog;
import za.co.applications.princegains.shopping.shopping.model.CatalogItem;
import za.co.applications.princegains.shopping.shopping.model.StockItem;

import java.util.List;
import java.util.Set;

public interface CatalogDAO {

    void saveCatalog(Catalog catalog);
    void updateCatalog(Catalog catalog);

    List<Catalog> getAllCatalogues();

    List<Catalog> getCatalogByName(String name);

    List<CatalogItem> getAllCatalogItems();

    List<CatalogItem> getAllCatalogItemsByCategory(String category);
}
