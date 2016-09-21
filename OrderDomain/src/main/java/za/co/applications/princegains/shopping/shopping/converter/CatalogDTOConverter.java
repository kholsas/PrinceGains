package za.co.applications.princegains.shopping.shopping.converter;

import za.co.applications.princegains.shopping.shopping.dto.CatalogDTO;
import za.co.applications.princegains.shopping.shopping.dto.CatalogItemDTO;
import za.co.applications.princegains.shopping.shopping.dto.StockItemDTO;
import za.co.applications.princegains.shopping.shopping.model.Catalog;
import za.co.applications.princegains.shopping.shopping.model.CatalogItem;
import za.co.applications.princegains.shopping.shopping.model.StockItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kholofelo on 2016/09/16.
 */
public class CatalogDTOConverter {
    public static List<CatalogDTO> toCatalogDTOList(List<Catalog> allCatalogues) {
        List<CatalogDTO> catalogDTOs = new ArrayList<>();
        for (Catalog catalog : allCatalogues) {
            catalogDTOs.add(toCatalogDTO(catalog));
        }
        return catalogDTOs;
    }

    public static CatalogDTO toCatalogDTO(Catalog catalog) {
        CatalogDTO catalogDTO = new CatalogDTO();
        catalogDTO.setId(catalog.getId());
        catalogDTO.setName(catalog.getName());
        catalog.setDescription(catalog.getDescription());
        catalogDTO.setCatalogItemDTOs(toCatalogItemList(catalog.getCatalogItems()));

        return catalogDTO;
    }

    public static List<CatalogItemDTO> toCatalogItemList(List<CatalogItem> catalogItems) {
        List<CatalogItemDTO> catalogItemDTOs = new ArrayList<>();

        for (CatalogItem catalogItem : catalogItems) {
            catalogItemDTOs.add(toCatalogItem(catalogItem));
        }
        return catalogItemDTOs;
    }

    public static CatalogItemDTO toCatalogItem(CatalogItem catalogItem) {
        CatalogItemDTO catalogItemDTO = new CatalogItemDTO();
        catalogItemDTO.setId(catalogItem.getId());
        catalogItem.setNumberAvailable(catalogItem.getNumberAvailable());
        catalogItem.setNumberSold(catalogItem.getNumberSold());
        catalogItemDTO.setQuantity(catalogItem.getQuantity());
        catalogItemDTO.setStockItem(toStockItemDTO(catalogItem.getStockItem()));
        return catalogItemDTO;
    }

    public static StockItemDTO toStockItemDTO(StockItem stockItem) {
        StockItemDTO stockItemDTO = new StockItemDTO();
        stockItemDTO.setId(stockItem.getId());
        stockItemDTO.setName(stockItem.getName());
        stockItemDTO.setDescription(stockItem.getDescription());
        stockItemDTO.setPrice(stockItem.getPrice());
        stockItemDTO.setImageFileName(stockItem.getImageFileName());
        return stockItemDTO;
    }
}
