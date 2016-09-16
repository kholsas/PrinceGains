package za.co.applications.princegains.shopping.shopping.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by kholofelo on 2016/09/16.
 */
@XmlRootElement(name = "catalog")
public class CatalogDTO {

    private long id;

    private String name;
    private String description;
    private List<CatalogItemDTO> catalogItemDTOs;

    public CatalogDTO() {
    }

    @XmlAttribute
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement
    public List<CatalogItemDTO> getCatalogItemDTOs() {
        return catalogItemDTOs;
    }

    public void setCatalogItemDTOs(List<CatalogItemDTO> catalogItemDTOs) {
        this.catalogItemDTOs = catalogItemDTOs;
    }
}
