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

    @Lob
    @Column(name="stockItem_image", columnDefinition="mediumblob")
    private byte[] image;




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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockItem stockItem = (StockItem) o;

        return id == stockItem.id;

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
