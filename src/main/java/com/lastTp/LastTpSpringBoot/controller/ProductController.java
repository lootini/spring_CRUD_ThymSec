package com.lastTp.LastTpSpringBoot.controller;

import com.lastTp.LastTpSpringBoot.entity.Product;
import com.lastTp.LastTpSpringBoot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @Secured(value = {"ROLE_ADMIN", "ROLE_SUPERVISEUR"})
    @RequestMapping(value = "/products")
    public String allProducts(Model model) {
        model.addAttribute("Products", productService.allProducts());
        return "All Products";
    }

    @RequestMapping(value = "/index")
    public String index(Model model, Principal principal) {
        model.addAttribute("name", principal.getName());
        return "index";
    }

    @Secured(value = {"ROLE_ADMIN", "ROLE_SUPERVISEUR", "ROLE_VISISTEUR"})
    @RequestMapping(value = "/find")
    public String find() {
        return "find";
    }

    @Secured(value = {"ROLE_ADMIN", "ROLE_SUPERVISEUR", "ROLE_VISITEUR"})
    @RequestMapping(value = "/findproduct")
    public String findProduct(@RequestParam String idProduct, Model model){
        boolean etat = true;
        try {
            Product product = productService.getProduct(Integer.parseInt(idProduct));

            if (product.getName() != null) {
                etat = true;
                model.addAttribute("Product", product);
                model.addAttribute("Etat",etat);
                return "findProduct";
            }
        } catch (Exception e) {
            etat = false;
            model.addAttribute("etat", etat);
            return "findProduct";
        }
        return idProduct;
    }
}
