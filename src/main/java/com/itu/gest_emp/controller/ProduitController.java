package com.itu.gest_emp.controller;

import servlet.ModelView;
import servlet.annotations.Controller;
import servlet.annotations.Url;

@Controller
public class ProduitController {

    // Test : ModelView avec une liste de produits
    @Url("/produits")
    public ModelView listeProduits() {
        ModelView mv = new ModelView();
        mv.setView("/pages/produits.jsp");
        mv.addItem("titre", "Liste des produits");
        mv.addItem("produit1", "Riz");
        mv.addItem("prix1", 5000);
        mv.addItem("produit2", "Pain");
        mv.addItem("prix2", 2000);
        mv.addItem("produit3", "Lait");
        mv.addItem("prix3", 3500);
        mv.addItem("total", 3);
        return mv;
    }

    // Test : ModelView avec un seul produit
    @Url("/produit")
    public ModelView detailProduit() {
        ModelView mv = new ModelView();
        mv.setView("/pages/produits.jsp");
        mv.addItem("titre", "Detail produit");
        mv.addItem("produit1", "Riz de luxe");
        mv.addItem("prix1", 12000);
        mv.addItem("total", 1);
        return mv;
    }
}
