package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Produit;
import com.example.demo.service.ProduitService;

@RestController
public class ProduitController {
 private final ProduitService produitService;
  
 public ProduitController(ProduitService produitService) {
	 this.produitService=produitService;
 }
 @GetMapping("/Produit")
 public List <Produit> getAfficher(){
	return this.produitService.TrouverProduit();
 }
 @GetMapping("/Produit/{id}")
 public Optional<Produit>getAfficherParId(Integer id){
	 return this.produitService.TrouverParId(id);
 }
 @PostMapping("/Produit")
 public Produit AjouterProduit(@RequestBody Produit produit) {
	 return this.produitService.createProduit(produit);
 }
 @DeleteMapping("/Produit/{id}")
   public void delete(@PathVariable Integer id) {
	 this.produitService.deleteProduit(id);
 }
 @PutMapping("/Produit/{id}")
 public Produit modifierProduit(@RequestBody Produit produit ,@PathVariable Integer  id) {
	 return this.produitService.modifier(produit,id);
 }
}
