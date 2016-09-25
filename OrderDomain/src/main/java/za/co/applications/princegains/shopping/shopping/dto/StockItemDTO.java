package za.co.applications.princegains.shopping.shopping.dto;

/**
 * Created by kholofelo on 2016/09/16.
 */
public class StockItemDTO {

    private long id;

    private String name;

    private String description;

    private double price;

    private String imageFileName;

    private String stockItemCode;
    private String stockCategoty;
    public StockItemDTO() {
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getStockItemCode() {
        return stockItemCode;
    }

    public void setStockItemCode(String stockItemCode) {
        this.stockItemCode = stockItemCode;
    }

    public String getStockCategoty() {
        return stockCategoty;
    }

    public void setStockCategoty(String stockCategoty) {
        this.stockCategoty = stockCategoty;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "StockItemDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
