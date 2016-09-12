package za.co.applications.princegains.shopping.shopping.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kholofelo on 2016/09/08.
 */

@Entity
@Table(name = "Catalogs")
public class Catalog {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;
    @Column
    private String category;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "catalog")
    private List<OrderItem> orderItems;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Catalog catalog = (Catalog) o;

        if (id != catalog.id) return false;
        if (name != null ? !name.equals(catalog.name) : catalog.name != null) return false;
        if (category != null ? !category.equals(catalog.category) : catalog.category != null) return false;
        return !(orderItems != null ? !orderItems.equals(catalog.orderItems) : catalog.orderItems != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (orderItems != null ? orderItems.hashCode() : 0);
        return result;
    }


    public enum CatalogCategory{
        ALL("ALL"),
        ELECTRONICS("ELECTRONICS"),
        SECOND("SECOND");
        private final String value;

        CatalogCategory(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

    @Override
    public String toString() {
        return "Catalog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", orderItems=" + orderItems +
                '}';
    }
}
