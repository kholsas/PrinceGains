package za.co.applications.princegains.shopping.shopping.dto;

import java.util.List;

/**
 * Created by kholofelo on 2016/09/16.
 */
public class CatalogDTO {

    private long id;

    private String name;
    private String description;
    private List<CatalogItemDTO> catalogItemDTOs;

    public CatalogDTO() {
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

    public List<CatalogItemDTO> getCatalogItemDTOs() {
        return catalogItemDTOs;
    }

    public void setCatalogItemDTOs(List<CatalogItemDTO> catalogItemDTOs) {
        this.catalogItemDTOs = catalogItemDTOs;
    }

    @Override
    public String toString() {
        return "CatalogDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", catalogItemDTOs=" + catalogItemDTOs +
                '}';
    }
}
