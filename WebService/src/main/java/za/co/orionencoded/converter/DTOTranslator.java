package za.co.orionencoded.converter;

import za.co.applications.princegains.shopping.shopping.dto.StockItemDTO;
import za.co.applications.princegains.shopping.shopping.model.StockItem;

/**
 * Created by kholofelo on 2016/09/19.
 */
public class DTOTranslator {
    public static StockItem stockItemToStockItemDTO(StockItemDTO stockItemDTO) {
        StockItem stockItem = new StockItem();
        stockItem.setName(stockItemDTO.getName());
        stockItem.setPrice(stockItemDTO.getPrice());
        stockItem.setDescription(stockItemDTO.getDescription());
        return stockItem;
    }
}
