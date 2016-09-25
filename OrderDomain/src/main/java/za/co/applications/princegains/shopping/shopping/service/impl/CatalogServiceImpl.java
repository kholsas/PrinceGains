package za.co.applications.princegains.shopping.shopping.service.impl;


import za.co.applications.princegains.shopping.shopping.converter.CatalogDTOConverter;
import za.co.applications.princegains.shopping.shopping.dao.CatalogDAO;
import za.co.applications.princegains.shopping.shopping.dao.CatalogDAOImpl;
import za.co.applications.princegains.shopping.shopping.dto.CatalogDTO;
import za.co.applications.princegains.shopping.shopping.dto.CatalogItemDTO;
import za.co.applications.princegains.shopping.shopping.model.Catalog;
import za.co.applications.princegains.shopping.shopping.model.CatalogItem;
import za.co.applications.princegains.shopping.shopping.service.CatalogService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kholofelo on 2016/09/08.
 */
public class CatalogServiceImpl implements CatalogService {


    private CatalogDAO catalogDAO = CatalogDAOImpl.getInstance();

    private static final CatalogService INSTANCE = new CatalogServiceImpl();

    public static CatalogService getInstance() {
        return INSTANCE;
    }

    public List<CatalogDTO> getAllCatalogues() {
        return CatalogDTOConverter.toCatalogDTOList(catalogDAO.getAllCatalogues());
    }


    public List<CatalogDTO> getCatalogByName(String name) {
        return CatalogDTOConverter.toCatalogDTOList(catalogDAO.getCatalogByName(name));
    }

    public void createCatalog(Catalog catalog) {
        catalogDAO.saveCatalog(catalog);
    }

    public void updateCatalog(Catalog catalog) {
        catalogDAO.updateCatalog(catalog);
    }

    public List<CatalogItemDTO> getAllCatalogItems() {
        return CatalogDTOConverter.toCatalogItemList(catalogDAO.getAllCatalogItems());
    }

    @Override
    public List<CatalogItemDTO> getCatalogItemsByCategory(String category) {
        List<CatalogItem> catalogItems = catalogDAO.getAllCatalogItems();
        List<CatalogItem> itemListToReturn = catalogItems.stream().filter(catalogItem -> catalogItem.getStockItem().getStockCategory().getValue().equalsIgnoreCase(category)).collect(Collectors.toList());
        return CatalogDTOConverter.toCatalogItemList(itemListToReturn);
    }
}
