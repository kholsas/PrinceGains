package za.co.applications.princegains.shopping.shopping.service;

import org.junit.Before;
import org.junit.Test;
import za.co.applications.princegains.shopping.shopping.dto.CatalogDTO;
import za.co.applications.princegains.shopping.shopping.model.Catalog;
import za.co.applications.princegains.shopping.shopping.service.impl.CatalogServiceImpl;

import java.util.List;

/**
 * Created by kholofelo on 2016/09/11.
 */
public class CatalogServiceTest {
    private CatalogService catalogService;

    @Before
    public void setUp() {
        catalogService = CatalogServiceImpl.getInstance();
    }

    @Test
    public void testGetAllCatalogues() throws Exception {
        List<CatalogDTO> catalogList = catalogService.getAllCatalogues();
        //    assertNotNull(catalogList);
        //  assertTrue(catalogList.isEmpty());
    }

    @Test
    public void testRetrieveByCategory() throws Exception {
        catalogService.getCatalogItemsByCategory("TOPS");
    }


    @Test
    public void testGetCatalogByName() throws Exception {

    }

    @Test
    public void testCreateCatalog() throws Exception {

    }

    @Test
    public void testUpdateCatalog() throws Exception {

    }

    @Test
    public void testGetAllCatalogItems() throws Exception {

    }
}