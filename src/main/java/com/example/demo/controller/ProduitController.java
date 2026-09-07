package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.ProduitNotFoundException;
import com.example.demo.entity.Produit;
import com.example.demo.service.ProduitService;

import jakarta.validation.Valid;


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
 public Optional <Produit> getAfficherParId(@PathVariable Integer id){
	 return this.produitService.TrouverParId(id);
 }
 /*@ExceptionHandler(ProduitNotFoundException.class)
 public ResponseEntity<String>handleProduitNotFound(ProduitNotFoundException ex){
	 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
 }*/
 @PostMapping("/Produit")
 public ResponseEntity <Produit> AjouterProduit(@Valid @RequestBody Produit produit) {
	 Produit nouveauProduit=produitService.createProduit(produit);
  return ResponseEntity.status(HttpStatus.CREATED).body(nouveauProduit) ;
 }
 @DeleteMapping("/Produit/{id}")
   public ResponseEntity<Void>delete(@PathVariable Integer id) {
	 this.produitService.deleteProduit(id);
	 return ResponseEntity.noContent().build();
 }
 @PutMapping("/Produit/{id}")
 public Produit modifierProduit(@RequestBody Produit produit ,@PathVariable Integer  id) {
	 return this.produitService.modifier(produit,id);
 }
}
