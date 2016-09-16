package za.co.applications.princegains.shopping.shopping.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by kholofelo on 2016/09/16.
 */

@XmlRootElement(name = "catalogItem")
public class CatalogItemDTO {

    private long id;

    private StockItemDTO stockItem;

    private int numberAvailable;

    private int numberSold;
    private int quantity;

    public CatalogItemDTO() {
    }

    @XmlAttribute
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @XmlElement
    public StockItemDTO getStockItem() {
        return stockItem;
    }

    public void setStockItem(StockItemDTO stockItem) {
        this.stockItem = stockItem;
    }

    @XmlElement
    public int getNumberAvailable() {
        return numberAvailable;
    }

    public void setNumberAvailable(int numberAvailable) {
        this.numberAvailable = numberAvailable;
    }

    @XmlElement
    public int getNumberSold() {
        return numberSold;
    }

    public void setNumberSold(int numberSold) {
        this.numberSold = numberSold;
    }

    @XmlElement
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
