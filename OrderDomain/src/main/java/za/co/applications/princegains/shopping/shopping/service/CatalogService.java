package za.co.applications.princegains.shopping.shopping.service;


import za.co.applications.princegains.shopping.shopping.model.Catalog;
import za.co.applications.princegains.shopping.shopping.model.CatalogItem;
import za.co.applications.princegains.shopping.shopping.model.StockItem;

import java.util.List;
import java.util.Set;

/**
 * Created by kholofelo on 2016/09/08.
 */
public interface CatalogService {

    Set<Catalog> getAllCatalogues();

    Set<Catalog> getCatalogByName(String name);

    void createCatalog(Catalog catalog);

    void updateCatalog(Catalog catalog);
    
    Set<CatalogItem> getAllCatalogItems();

}
