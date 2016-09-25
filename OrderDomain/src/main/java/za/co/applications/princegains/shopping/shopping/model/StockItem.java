package za.co.applications.princegains.shopping.shopping.model;

import javax.persistence.*;

/**
 * Created by kholofelo on 2016/09/08.
 */

@Entity
@Table(name = "StockItems")
public class StockItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;
    @Column
    private String description;
    @Column
    private double price;

    @Column
    private String imageFileName;


    @Column
    @Enumerated(EnumType.STRING)
    private StockCategory stockCategory;

    @Column
    private String stockItemCode;

    public String getStockItemCode() {
        return stockItemCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockItem stockItem = (StockItem) o;

        return id == stockItem.id;

    }

    public StockCategory getStockCategory() {
        return stockCategory;
    }

    public void setStockCategory(StockCategory stockCategory) {
        this.stockCategory = stockCategory;
    }

    public void setStockItemCode(String stockItemCode) {
        this.stockItemCode = stockItemCode;
    }

    public enum StockCategory {
        TOP("Top"),
        BOTTOM("Bottom"),
        UNDERWEAR("Underwear"),
        ACCESSORIES("Accessory");
        private final String name;

        StockCategory(final String name) {
            this.name = name;
        }
    }


    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "StockItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }


}
