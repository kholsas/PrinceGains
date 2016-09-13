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
import za.co.applications.princegains.shopping.shopping.model.Order;
import za.co.applications.princegains.shopping.shopping.model.OrderItem;
import za.co.applications.princegains.shopping.shopping.model.SystemUser;
import za.co.applications.princegains.shopping.shopping.service.CatalogService;
import za.co.applications.princegains.shopping.shopping.service.OrderService;
import za.co.applications.princegains.shopping.shopping.service.UserService;
import za.co.applications.princegains.shopping.shopping.service.UserServiceImpl;
import za.co.applications.princegains.shopping.shopping.service.impl.CatalogServiceImpl;
import za.co.applications.princegains.shopping.shopping.service.impl.OrderServiceImpl;

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

        Catalog catalog = null;
     /*   if (model.get("catalog") != null) {
            catalog = (Catalog) model.get("catalog");
        } else */
        {
            catalog = catalogService.getCatalogByCategory(Catalog.CatalogCategory.ALL);
        }
        model.addAttribute("catalog", catalog);
        return "welcome";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "admin";
    }

    @RequestMapping(value = "/confirmOrderItemList", method = RequestMethod.POST)
    public String confirmOrderList(Catalog catalog) {

        List<OrderItem> selectedItems = new ArrayList<OrderItem>();
        for (OrderItem orderItem : catalog.getOrderItems()) {
            if (orderItem.getQuantity() > 0) {
                orderItem.setCatalog(catalog);
                selectedItems.add(orderItem);
            }
        }

        SystemUser systemUser = userService.findBySso(getPrincipal());

        Order order = new Order();
        order.setOrderItems(selectedItems);
        order.setOrderTime(new Timestamp(new Date().getTime()));

        if (systemUser != null) {
            order.setSystemUser(systemUser);
        }
        orderService.makeAnOrder(order);
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