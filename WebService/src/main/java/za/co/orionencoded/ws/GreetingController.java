package za.co.orionencoded.ws;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.applications.princegains.shopping.shopping.dto.CatalogDTO;
import za.co.applications.princegains.shopping.shopping.dto.CatalogItemDTO;
import za.co.applications.princegains.shopping.shopping.service.CatalogService;
import za.co.applications.princegains.shopping.shopping.service.impl.CatalogServiceImpl;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private final CatalogService catalogService = CatalogServiceImpl.getInstance();

    @CrossOrigin
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(required = false, defaultValue = "World") String name) {
        System.out.println("==== in greeting ====");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @CrossOrigin
    @GetMapping("/catalogs")
    public List<CatalogDTO> getAllCatalogs(@RequestParam(required = false, defaultValue = "World") String name) {
        System.out.println("==== in getAllCatalogs ====");
        return catalogService.getAllCatalogues();
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
    @PostMapping("/makeOrder")
    public ResponseEntity<List<CatalogItemDTO>> makeOrder(@RequestBody List<CatalogItemDTO> catalogItemDTOList) {
        // TODO: call persistence layer to update
        System.out.println("==== in makeOrder ==== catalogDTOList: " + catalogItemDTOList);

        return new ResponseEntity<List<CatalogItemDTO>>(catalogItemDTOList, HttpStatus.OK);
    }

    @GetMapping("/greeting-javaconfig")
    public Greeting greetingWithJavaconfig(@RequestParam(required = false, defaultValue = "World") String name) {
        System.out.println("==== in greeting ====");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}
