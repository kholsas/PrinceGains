package za.co.applications.princegains.shopping.shopping;

import za.co.applications.princegains.shopping.shopping.model.Catalog;
import za.co.applications.princegains.shopping.shopping.model.CatalogItem;
import za.co.applications.princegains.shopping.shopping.model.StockItem;
import za.co.applications.princegains.shopping.shopping.service.CatalogService;
import za.co.applications.princegains.shopping.shopping.service.StockItemManagerService;
import za.co.applications.princegains.shopping.shopping.service.impl.CatalogServiceImpl;
import za.co.applications.princegains.shopping.shopping.service.impl.StockItemManagerServiceImpl;

import java.io.*;
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

        listOfCatalogItems.add(createCatalogItem("Mesh Vest", "Small White", 3, 3, 150, meshVestWhite));
        listOfCatalogItems.add(createCatalogItem("Mesh Vest", "Small Royal blue", 3, 3, 150, meshVestRoyalBlue));
        listOfCatalogItems.add(createCatalogItem("Mesh Vest", "Small Navy blue", 3, 3, 150, meshVestNavyBlue));
        listOfCatalogItems.add(createCatalogItem("Mesh Vest", "Small Sky blue", 3, 3, 150, meshVestSkyBlue));

        listOfCatalogItems.add(createCatalogItem("Net Vest", "Medium Yellow", 3, 3, 200, netVestYellow));
        listOfCatalogItems.add(createCatalogItem("Net Vest", "Medium Blue", 3, 3, 200, netVestBlue));
        listOfCatalogItems.add(createCatalogItem("Net Vest", "Medium Green", 3, 3, 200, netVestGreen));
        listOfCatalogItems.add(createCatalogItem("Net Vest", "Medium White", 3, 3, 200, netVestWhite));
        listOfCatalogItems.add(createCatalogItem("Net Vest", "Medium Red", 2, 2, 200, netVestRed));
        listOfCatalogItems.add(createCatalogItem("Net Vest", "Medium Black", 1, 1, 200, netVestBlack));
        listOfCatalogItems.add(createCatalogItem("Net Vest", "Medium Red", 1, 1, 200, netVestRed));
        listOfCatalogItems.add(createCatalogItem("Net Vest", "Small Green", 3, 3, 200, netVestGreen));


        listOfCatalogItems.add(createCatalogItem("Net Vest", "Small Red", 2, 2, 200, netVestRed));
        listOfCatalogItems.add(createCatalogItem("Net Vest", "Small Yellow", 2, 2, 200, netVestYellow));
        listOfCatalogItems.add(createCatalogItem("Net Vest", "Small Black", 2, 2, 200, netVestBlack));
        listOfCatalogItems.add(createCatalogItem("Net Vest", "Large Yellow", 2, 2, 200, netVestYellow));
        listOfCatalogItems.add(createCatalogItem("Net Vest", "Large Red", 2, 2, 200, netVestRed));

        listOfCatalogItems.add(createCatalogItem("Camo hoodie tank top", "camouflage small", 1, 1, 450, hoodie));
        listOfCatalogItems.add(createCatalogItem("Camo hoodie tank top", "camouflage medium", 1, 1, 450, hoodie));
        listOfCatalogItems.add(createCatalogItem("Camo hoodie tank top", "camouflage large", 1, 1, 450, hoodie));


        //food containers
        listOfCatalogItems.add(createCatalogItem("Lunchbox Bags", "Meal prep bag with lunchboxes and ice packs grey", 1, 1, 1300, lunchBag));
        listOfCatalogItems.add(createCatalogItem("Food containers", "Meal prep 7 piece containers with food portion guide black", 1, 1, 500, foodContainers));


        catalog.setCatalogItems(listOfCatalogItems);


        catalogService.createCatalog(catalog);

    }

    private static CatalogItem createCatalogItem(String stockItemName, String description,
                                                 int quantity, int available, double price, String fileName) {
        byte[] image = new byte[0];
        try {
            image = readBytesFromFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        CatalogItem catalogItem = new CatalogItem();
        StockItem stockItem = new StockItem();
        stockItem.setName(stockItemName);
        stockItem.setDescription(description);
        stockItem.setPrice(price);
        stockItem.setImage(image);
        catalogItem.setStockItem(stockItem);
        catalogItem.setQuantity(quantity);
        catalogItem.setNumberAvailable(available);

        return catalogItem;
    }


    private static void saveBytesToFile(String filePath, byte[] fileBytes) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(filePath);
        outputStream.write(fileBytes);
        outputStream.close();
    }

    private static byte[] readBytesFromFile(String filePath) throws IOException {

        InputStream inputStream = Runner.class.getClassLoader().getResourceAsStream(  filePath);
 //        FileInputStream inputStream = new FileInputStream(inputFile);
        System.out.println("inputStream := " + inputStream);
        byte[] fileBytes = new byte[]{};
        inputStream.read(fileBytes);
        inputStream.close();

        return fileBytes;
    }


}
