package za.co.applications.princegains.client.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import za.co.applications.princegains.shopping.shopping.model.Catalog;
import za.co.applications.princegains.shopping.shopping.model.CatalogItem;
import za.co.applications.princegains.shopping.shopping.model.Order;
import za.co.applications.princegains.shopping.shopping.model.OrderItem;
import za.co.applications.princegains.shopping.shopping.service.CatalogService;
import za.co.applications.princegains.shopping.shopping.service.OrderService;
import za.co.applications.princegains.shopping.shopping.service.UserService;
import za.co.applications.princegains.shopping.shopping.service.impl.CatalogServiceImpl;
import za.co.applications.princegains.shopping.shopping.service.impl.OrderServiceImpl;
import za.co.applications.princegains.shopping.shopping.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class OrderManagerController {


    private CatalogService catalogService = CatalogServiceImpl.getInstance();
    private UserService userService = UserServiceImpl.getInstance();
    private OrderService orderService = OrderServiceImpl.getInstance();

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        model.addAttribute("user", getPrincipal());


        List<Catalog> catalogs = catalogService.getAllCatalogues();
        if (catalogs.isEmpty()) {
            model.addAttribute("errorMessage", "We had a problem loading the Catalog. We've got our techs right on it.<p> We apologise for the inconvenience");
        } else {
            model.addAttribute("catalog", catalogs.get(0));
        }
        return "welcome";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "admin";
    }

    @RequestMapping(value = "/confirmOrderItemList", method = RequestMethod.POST)
    public String confirmOrderList(Catalog catalog) {
        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        for (CatalogItem catalogItem : catalog.getCatalogItems()) {
            if (catalogItem.getQuantity() > 0) {
                OrderItem orderItem = new OrderItem();
                orderItem.setQuantity(catalogItem.getQuantity());
                orderItem.setStockItem(catalogItem.getStockItem());
                orderItems.add(orderItem);
            }
        }

        if(!orderItems.isEmpty()){
            Order order = new Order();
            order.setOrderItems(orderItems);
            order.setOrderTime(new Timestamp(new Date().getTime()));
            orderService.makeAnOrder(order);
        }
        return "welcome";
    }


    @RequestMapping(value = "/db", method = RequestMethod.GET)
    public String dbaPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "dba";
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

}