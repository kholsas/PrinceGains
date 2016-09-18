package za.co.applications.princegains.shopping.shopping.dto;

/**
 * Created by kholofelo on 2016/09/16.
 */

public class CatalogItemDTO {

    private long id;

    private StockItemDTO stockItem;

    private int numberAvailable;

    private int numberSold;
    private int quantity;

    public CatalogItemDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public StockItemDTO getStockItem() {
        return stockItem;
    }

    public void setStockItem(StockItemDTO stockItem) {
        this.stockItem = stockItem;
    }

    public int getNumberAvailable() {
        return numberAvailable;
    }

    public void setNumberAvailable(int numberAvailable) {
        this.numberAvailable = numberAvailable;
    }

    public int getNumberSold() {
        return numberSold;
    }

    public void setNumberSold(int numberSold) {
        this.numberSold = numberSold;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
