package za.co.applications.princegains.client.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import za.co.applications.princegains.shopping.shopping.model.Catalog;
import za.co.applications.princegains.shopping.shopping.model.OrderItem;
import za.co.applications.princegains.shopping.shopping.service.CatalogService;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import za.co.applications.princegains.shopping.shopping.service.impl.CatalogServiceImpl;


@Controller
public class OrderManagerController {


    private CatalogService catalogService = CatalogServiceImpl.getInstance();

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        model.addAttribute("user", getPrincipal());


        Catalog catalog = catalogService.getCatalogByCategory(Catalog.CatalogCategory.ALL);

        model.addAttribute("catalog", catalog);
        return "welcome";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "admin";
    }

    @RequestMapping(value = "/confirmList", method = RequestMethod.POST)
    public String confirmList(@ModelAttribute Catalog catalog) {
        System.out.println("\n\n------>catalog = " + catalog);
        List<OrderItem> selectedItems = new ArrayList<OrderItem>();
        for (OrderItem orderItem : catalog.getOrderItems()) {
            if (orderItem.isAddedToCart()) {
                selectedItems.add(orderItem);
            }
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