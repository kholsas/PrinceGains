package za.co.applications.princegains.shopping.shopping.service;


import za.co.applications.princegains.shopping.shopping.model.Catalog;
import za.co.applications.princegains.shopping.shopping.model.OrderItem;

import java.util.List;

/**
 * Created by kholofelo on 2016/09/08.
 */
public interface CatalogService {

    List<Catalog> getAllCatalogues();

    Catalog getCatalogByCategory(Catalog.CatalogCategory category);

    List<Catalog> getCatalogByName(String name);

    void createCatalog(Catalog catalog);

    void updateCatalog(Catalog catalog);
    
    List<OrderItem> getAllCatalogItems();

}
