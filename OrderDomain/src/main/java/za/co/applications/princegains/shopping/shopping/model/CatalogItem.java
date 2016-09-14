package za.co.applications.princegains.shopping.shopping.model;

import javax.persistence.*;

/**
 * Created by kholofelo on 2016/09/13.
 */


@Entity
@Table(name = "CatalogItems")
public class CatalogItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "stockItem_id", nullable = false)
    private StockItem stockItem;


    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "catalog")
    private Catalog order;

    @Column
    private int numberAvailable;

    @Column
    private int numberSold;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public StockItem getStockItem() {
        return stockItem;
    }

    public void setStockItem(StockItem stockItem) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CatalogItem that = (CatalogItem) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "CatalogItem{" +
                "id=" + id +
                ", numberAvailable=" + numberAvailable +
                ", numberSold=" + numberSold +
                '}';
    }
}
