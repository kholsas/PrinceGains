package za.co.applications.princegains.shopping.shopping.service;


import za.co.applications.princegains.shopping.shopping.dto.CatalogDTO;
import za.co.applications.princegains.shopping.shopping.dto.CatalogItemDTO;
import za.co.applications.princegains.shopping.shopping.model.Catalog;

import java.util.List;

/**
 * Created by kholofelo on 2016/09/08.
 */
public interface CatalogService {

    List<CatalogDTO> getAllCatalogues();

    List<CatalogDTO> getCatalogByName(String name);

    void createCatalog(Catalog catalog);

    void updateCatalog(Catalog catalog);

    List<CatalogItemDTO> getAllCatalogItems();

    List<CatalogItemDTO> getCatalogItemsByCategory(String category);

}
