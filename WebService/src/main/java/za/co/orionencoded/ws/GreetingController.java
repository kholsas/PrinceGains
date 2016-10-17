package za.co.orionencoded.ws;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.applications.princegains.shopping.shopping.dto.CatalogDTO;
import za.co.applications.princegains.shopping.shopping.dto.CatalogItemDTO;
import za.co.applications.princegains.shopping.shopping.model.Order;
import za.co.applications.princegains.shopping.shopping.model.OrderItem;
import za.co.applications.princegains.shopping.shopping.model.SystemUser;
import za.co.applications.princegains.shopping.shopping.service.CatalogService;
import za.co.applications.princegains.shopping.shopping.service.OrderService;
import za.co.applications.princegains.shopping.shopping.service.UserService;
import za.co.applications.princegains.shopping.shopping.service.impl.CatalogServiceImpl;
import za.co.applications.princegains.shopping.shopping.service.impl.OrderServiceImpl;
import za.co.applications.princegains.shopping.shopping.service.impl.UserServiceImpl;
import za.co.orionencoded.converter.DTOTranslator;
import za.co.orionencoded.security.CustomWebSecurity;

import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController("/catalog")
public class GreetingController extends CustomWebSecurity {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private final CatalogService catalogService = CatalogServiceImpl.getInstance();
    private final OrderService orderService = OrderServiceImpl.getInstance();
    private final UserService userService = UserServiceImpl.getInstance();

    @CrossOrigin
    @GetMapping("/catalogs")
    public List<CatalogDTO> getAllCatalogs(@RequestParam(required = false, defaultValue = "World") String name) {
        System.out.println("==== in getAllCatalogs ====");
        return catalogService.getAllCatalogues();
    }

    //TODO: need to write a function to return ONE catalog
    @CrossOrigin
    @GetMapping("/organisedCatalog")
    public Map<Integer, List<CatalogItemDTO>> getOrganisedCatalogItems() {
        System.out.println("==== in organisedCatalog ====");
        Map<Integer, List<CatalogItemDTO>> items = getMappedCatalogItemsByPage();

        return items;
    }

    //TODO: need to write a function to return ONE catalog
    @CrossOrigin
    @GetMapping("/catalogItemsByPageNumber/{pageNumber}")
    public Map<Integer, List<CatalogItemDTO>> catalogItemsByPageNumber(@PathVariable String pageNumber) {
        System.out.println("==== in catalogItemsByPageNumber ====");
        System.out.println("==== in catalogItemsByPageNumber ==== pageNumber = " + pageNumber);
        Map<Integer, List<CatalogItemDTO>> items = getMappedCatalogItemsByPage();
        if (pageNumber != null || items.size() >= Integer.parseInt(pageNumber) + 1) {

            Map<Integer, List<CatalogItemDTO>> integerListHashMap = new HashMap<>();
            integerListHashMap.put(0, items.get(Integer.parseInt(pageNumber)));
            return integerListHashMap;
        }
        return null;
    }

    //TODO: need to write a function to return ONE catalog
    @CrossOrigin
    @GetMapping("/catalogItemsByCategory/{category}/{pageNumber}")
    public Map<Integer, List<CatalogItemDTO>> catalogItemsByCategory(@PathVariable String category, @PathVariable String pageNumber) {
        System.out.println("==== in catalogItemsByCategory ====");
        System.out.println("==== in catalogItemsByCategory ==== pageNumber = " + pageNumber + ", category = " + category);
        Map<Integer, List<CatalogItemDTO>> items = getMappedCatalogItemsByCategory(category);

        if (pageNumber != null || items.size() >= Integer.parseInt(pageNumber) + 1) {

            Map<Integer, List<CatalogItemDTO>> integerListHashMap = new HashMap<>();
            integerListHashMap.put(0, items.get(Integer.parseInt(pageNumber)));
            return integerListHashMap;
        }
        return null;
    }

    private Map<Integer, List<CatalogItemDTO>> getMappedCatalogItemsByCategory(String category) {
        Map<Integer, List<CatalogItemDTO>> items = new HashMap<>();
        int index = 0;
        int position = 0;
        List<CatalogItemDTO> catalogItemsByCategory = catalogService.getCatalogItemsByCategory(category);
        System.out.println("catalogItemsByCategory : found " + catalogItemsByCategory.size());
        for (CatalogItemDTO catalogItemDTO : catalogItemsByCategory) {
            if (index < 3) {
                index++;
                if (items.get(position) == null) {
                    items.put(position, new ArrayList<>());
                }
                items.get(position).add(catalogItemDTO);
            } else {
                position++;
                index = 0;
            }
        }
        return items;
    }

    private Map<Integer, List<CatalogItemDTO>> getMappedCatalogItemsByPage() {
        Map<Integer, List<CatalogItemDTO>> items = new HashMap<>();
        int index = 0;
        int position = 0;
        for (CatalogItemDTO catalogItemDTO : catalogService.getAllCatalogues().get(0).getCatalogItemDTOs()) {
            if (index < 3) {
                index++;
                if (items.get(position) == null) {
                    items.put(position, new ArrayList<>());
                }
                items.get(position).add(catalogItemDTO);
            } else {
                position++;
                index = 0;
            }
        }
        return items;
    }

    //TODO: need to write a function to return ONE catalog
    @CrossOrigin
    @GetMapping("/mainCatalog")
    public CatalogDTO getMainCatalog(@RequestParam(required = false, defaultValue = "World") String name) {
        System.out.println("==== in getAllCatalogs ====");
        return catalogService.getAllCatalogues().get(0);
    }

    //TODO: need to write a function to return ONE catalog
    @CrossOrigin
    @PostMapping("/makeOrder/{username}")
    public ResponseEntity<Map<Integer, List<CatalogItemDTO>>> makeOrder(@RequestBody Map<Integer, List<CatalogItemDTO>> catalogItemDTOList, @PathVariable String username) {
        // TODO: call persistence layer to update
        System.out.println("==== in makeOrder ==== username : " + username);
        Order order = new Order();
        List<OrderItem> orderItems = new ArrayList<>();
        if (catalogItemDTOList != null && !catalogItemDTOList.isEmpty()) {
            for (Map.Entry<Integer, List<CatalogItemDTO>> integerListEntry : catalogItemDTOList.entrySet()) {
                for (CatalogItemDTO catalogItemDTO : integerListEntry.getValue()) {
                    if (catalogItemDTO.getQuantity() > 0) {
                        OrderItem orderItem = new OrderItem();
                        orderItem.setQuantity(catalogItemDTO.getQuantity());
                        orderItem.setStockItem(DTOTranslator.stockItemToStockItemDTO(catalogItemDTO.getStockItem()));
                        orderItems.add(orderItem);
                    }
                }
            }

        }

        System.out.println("Order Items are : " + orderItems);
        SystemUser systemUser = userService.findBySso(username);
        if (!orderItems.isEmpty()) {
            order.setOrderItems(orderItems);
            order.setOrderTime(new Timestamp(new Date().getTime()));
            order.setSystemUser(systemUser);
            orderService.makeAnOrder(order);
        } else {
            System.out.println("No order made! List empty!");
        }
        return new ResponseEntity<Map<Integer, List<CatalogItemDTO>>>(catalogItemDTOList, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/getOrdersFor/{username}")
    public List<Order> getOrdersForUser(@PathVariable String username) {
        System.out.println("==== in getOrdersForUser: " + username + " ====");
        SystemUser systemUser = userService.findBySso(username);
        if (systemUser != null) {
            System.out.println("user is found");
            return orderService.getOrdersByPerson(systemUser);

        }
        return new ArrayList<>();
    }

}
