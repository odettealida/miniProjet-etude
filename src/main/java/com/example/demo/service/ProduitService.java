package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Exception.ProduitNotFoundException;
import com.example.demo.entity.Produit;
import com.example.demo.repository.ProduitRepository;

@Service
public class ProduitService {
	private final ProduitRepository produitRepository ;
	
	public ProduitService (ProduitRepository produitRepository) {
		this.produitRepository= produitRepository;
	}
	public List <Produit>TrouverProduit(){
		return this.produitRepository.findAll();
		
	}
	public Optional <Produit> TrouverParId(Integer id){
		return this.produitRepository.findById(id);
	}
	public Produit createProduit(Produit produit) {
		return this.produitRepository.save(produit);
	}
	public void deleteProduit(Integer id) {
	  this.produitRepository.deleteById(id);
	}
	public Produit modifier(Produit produit ,Integer id) {
		Optional <Produit> ProduitExistant= this.produitRepository.findById(id);
		if(ProduitExistant.isPresent()) {
			Produit AncienProduit= ProduitExistant.get();
			AncienProduit.setNom(produit.getNom());
			AncienProduit.setPrix(produit.getPrix());
			AncienProduit.setQuantite(produit.getQuantite());
		 
			return this.produitRepository.save(AncienProduit);
	}
                return null;
	}

}
