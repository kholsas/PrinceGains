package za.co.applications.princegains.shopping.shopping.service;

import org.junit.Before;
import org.junit.Test;
import za.co.applications.princegains.shopping.shopping.model.Catalog;
import za.co.applications.princegains.shopping.shopping.service.impl.CatalogServiceImpl;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by kholofelo on 2016/09/11.
 */
public class CatalogServiceTest {
private CatalogService catalogService;

    @Before
    public void setUp(){
        catalogService = CatalogServiceImpl.getInstance();
    }

    @Test
    public void testGetAllCatalogues() throws Exception {
        List<Catalog> catalogList = catalogService.getAllCatalogues();
        assertNotNull(catalogList);
        assertTrue(catalogList.isEmpty());
    }

    @Test
    public void testGetCatalogByCategory() throws Exception {

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