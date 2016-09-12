package za.co.applications.princegains.shopping.shopping.dao;


import za.co.applications.princegains.shopping.shopping.model.Catalog;
import za.co.applications.princegains.shopping.shopping.model.OrderItem;

import java.util.List;

public interface CatalogDAO {

    void saveCatalog(Catalog catalog);
    void updateCatalog(Catalog catalog);

    List<Catalog> getAllCatalogues();

    Catalog getCatalogByCategory(Catalog.CatalogCategory category);

    List<Catalog> getCatalogByName(String name);

    List<OrderItem> getAllCatalogItems();
}
