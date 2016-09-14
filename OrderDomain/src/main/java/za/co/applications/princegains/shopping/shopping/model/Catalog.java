package za.co.applications.princegains.shopping.shopping.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    private String description;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Catal_CatalItem",
            joinColumns = {@JoinColumn(name = "catalog_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "catalog_item_id", referencedColumnName = "id")})
    private Set<CatalogItem> catalogItems = new HashSet<>();

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

    public Set<CatalogItem> getCatalogItems() {
        return catalogItems;
    }

    public void setCatalogItems(Set<CatalogItem> catalogItems) {
        this.catalogItems = catalogItems;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", catalogItems=" + catalogItems +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Catalog catalog = (Catalog) o;

        return id == catalog.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
