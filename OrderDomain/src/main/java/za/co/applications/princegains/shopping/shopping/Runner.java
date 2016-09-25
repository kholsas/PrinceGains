package za.co.applications.princegains.shopping.shopping;

import za.co.applications.princegains.shopping.shopping.model.Catalog;
import za.co.applications.princegains.shopping.shopping.model.CatalogItem;
import za.co.applications.princegains.shopping.shopping.model.StockItem;
import za.co.applications.princegains.shopping.shopping.service.CatalogService;
import za.co.applications.princegains.shopping.shopping.service.StockItemManagerService;
import za.co.applications.princegains.shopping.shopping.service.impl.CatalogServiceImpl;
import za.co.applications.princegains.shopping.shopping.service.impl.StockItemManagerServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kholofelo on 2016/09/19.
 */
public class Runner {
    public static void main(String[] args) {
        StockItemManagerService stockItemManagerService = StockItemManagerServiceImpl.getInstance();
        CatalogService catalogService = CatalogServiceImpl.getInstance();
        Catalog catalog = new Catalog();
        catalog.setName("All Items");
        catalog.setDescription("Serves for all items on stock");


        List<CatalogItem> listOfCatalogItems = new ArrayList<>();
        String netVestYellow = "net vest yellow.jpg";
        String netVestBlue = "net vest blue.jpg";
        String netVestRed = "Net vest red.jpg";
        String netVestBlack = "net vest black.jpg";
        String netVestWhite = "net vest white.jpg";
        String netVestGreen = "net vest green.jpg";

        String meshVestWhite = "mesh vest white.jpg";
        String meshVestRoyalBlue = "mesh vest royal blue.jpg";
        String meshVestNavyBlue = "mesh vest navy blue.jpg";
        String meshVestSkyBlue = "mesh vest sky blue.jpg";

        String hoodie = "camo hoodie 2.jpg";

        String lunchBag = "Meal prep bag with lunchboxes and ice packs.jpg";
        String foodContainers = "Meal prep 7 piece containers with food portion guide.jpg";

        listOfCatalogItems.add(createCatalogItem("Mesh Vest", "Small White", 3, 3, 150, meshVestWhite, StockItem.StockCategory.TOP, "00001"));
        listOfCatalogItems.add(createCatalogItem("Mesh Vest", "Small Royal blue", 3, 3, 150, meshVestRoyalBlue, StockItem.StockCategory.TOP, "00002"));
        listOfCatalogItems.add(createCatalogItem("Mesh Vest", "Small Navy blue", 3, 3, 150, meshVestNavyBlue, StockItem.StockCategory.TOP, "00003"));
        listOfCatalogItems.add(createCatalogItem("Mesh Vest", "Small Sky blue", 3, 3, 150, meshVestSkyBlue, StockItem.StockCategory.TOP, "00004"));

        listOfCatalogItems.add(createCatalogItem("Net Vest", "Medium Yellow", 3, 3, 200, netVestYellow, StockItem.StockCategory.TOP, "00005"));
        listOfCatalogItems.add(createCatalogItem("Net Vest", "Medium Blue", 3, 3, 200, netVestBlue, StockItem.StockCategory.TOP, "00006"));
        listOfCatalogItems.add(createCatalogItem("Net Vest", "Medium Green", 3, 3, 200, netVestGreen, StockItem.StockCategory.TOP, "00007"));
        listOfCatalogItems.add(createCatalogItem("Net Vest", "Medium White", 3, 3, 200, netVestWhite, StockItem.StockCategory.TOP, "00008"));
        listOfCatalogItems.add(createCatalogItem("Net Vest", "Medium Red", 2, 2, 200, netVestRed, StockItem.StockCategory.TOP, "00009"));
        listOfCatalogItems.add(createCatalogItem("Net Vest", "Medium Black", 1, 1, 200, netVestBlack, StockItem.StockCategory.TOP, "00010"));
        listOfCatalogItems.add(createCatalogItem("Net Vest", "Medium Red", 1, 1, 200, netVestRed, StockItem.StockCategory.TOP, "00011"));
        listOfCatalogItems.add(createCatalogItem("Net Vest", "Small Green", 3, 3, 200, netVestGreen, StockItem.StockCategory.TOP, "00012"));


        listOfCatalogItems.add(createCatalogItem("Net Vest", "Small Red", 2, 2, 200, netVestRed, StockItem.StockCategory.TOP, "00013"));
        listOfCatalogItems.add(createCatalogItem("Net Vest", "Small Yellow", 2, 2, 200, netVestYellow, StockItem.StockCategory.TOP, "00014"));
        listOfCatalogItems.add(createCatalogItem("Net Vest", "Small Black", 2, 2, 200, netVestBlack, StockItem.StockCategory.TOP, "00015"));
        listOfCatalogItems.add(createCatalogItem("Net Vest", "Large Yellow", 2, 2, 200, netVestYellow, StockItem.StockCategory.TOP, "00016"));
        listOfCatalogItems.add(createCatalogItem("Net Vest", "Large Red", 2, 2, 200, netVestRed, StockItem.StockCategory.TOP, "00017"));

        listOfCatalogItems.add(createCatalogItem("Camo hoodie tank top", "camouflage small", 1, 1, 450, hoodie, StockItem.StockCategory.TOP, "00018"));
        listOfCatalogItems.add(createCatalogItem("Camo hoodie tank top", "camouflage medium", 1, 1, 450, hoodie, StockItem.StockCategory.TOP, "00019"));
        listOfCatalogItems.add(createCatalogItem("Camo hoodie tank top", "camouflage large", 1, 1, 450, hoodie, StockItem.StockCategory.TOP, "00020"));


        //food containers
        listOfCatalogItems.add(createCatalogItem("Lunchbox Bags", "Meal prep bag with lunchboxes and ice packs grey", 1, 1, 1300, lunchBag, StockItem.StockCategory.ACCESSORIES, "00021"));
        listOfCatalogItems.add(createCatalogItem("Food containers", "Meal prep 7 piece containers with food portion guide black", 1, 1, 500, foodContainers, StockItem.StockCategory.ACCESSORIES, "00022"));

/*Second Stock*/
//Mens stringer hooded tank top 	blue	medium	1	300

        listOfCatalogItems.add(createCatalogItem("Net Vest", "Large Blue", 2, 2, 200, netVestBlue, StockItem.StockCategory.ACCESSORIES, "00023"));
        listOfCatalogItems.add(createCatalogItem("Men's Stringer", "Large Blue", 2, 2, 200, netVestBlue, StockItem.StockCategory.ACCESSORIES, "00024"));


        catalog.setCatalogItems(listOfCatalogItems);
        catalogService.createCatalog(catalog);

    }

    private static CatalogItem createCatalogItem(String stockItemName, String description,
                                                 int quantity, int available, double price, String fileName, StockItem.StockCategory stockCategory, String stockItemCode) {

        CatalogItem catalogItem = new CatalogItem();
        StockItem stockItem = new StockItem();
        stockItem.setName(stockItemName);
        stockItem.setDescription(description);
        stockItem.setPrice(price);
        stockItem.setImageFileName(getProcessedImageFileName(fileName));
        stockItem.setStockCategory(stockCategory);
        stockItem.setStockItemCode(stockItemCode);

        catalogItem.setStockItem(stockItem);
        catalogItem.setQuantity(quantity);
        catalogItem.setNumberAvailable(available);

        return catalogItem;
    }

    private static String getProcessedImageFileName(String fileName) {
        return fileName.replace(" ", "").trim();
    }

}
