package org.sid.metier;

import java.awt.print.Pageable;
import java.util.Date;

import javax.transaction.Transactional;
import org.sid.dao.CompteRepository;
import org.sid.dao.OperationRepository;
import org.sid.entities.Compte;
import org.sid.entities.CompteCourant;
import org.sid.entities.Operation;
import org.sid.entities.Retrait;
import org.sid.entities.Versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class BanqueMetierImpl implements IBanqueMetier {
    
	@Autowired
    private CompteRepository compteRepository;		
	@Autowired
	private OperationRepository operationRepository;
	
	@Override
	public Compte consulterCompte(String codeCpte) {      
		
		Compte cp = compteRepository.findById(codeCpte).orElse(null);
	    if (cp==null) throw new RuntimeException("Compte Introuvable");
		return cp;
		
	} 

	@Override
	public void verser(String codeCpte, double montant) {
	
	 Compte cp = consulterCompte(codeCpte);	
	 Versement v = new Versement(new Date(), montant, cp);
	 operationRepository.save(v);
	 cp.setSolde(cp.getSolde()+montant);
	 compteRepository.save(cp);
	 	 
	}

	@Override
	public void retirer(String codeCpte, double mobntant) {
	
		Compte cp = consulterCompte(codeCpte);
		double facilitesCaisse = 0;
		if(cp instanceof CompteCourant)
			facilitesCaisse = ((CompteCourant) cp).getDecouvert();
		if(cp.getSolde() + facilitesCaisse < mobntant)
			throw new RuntimeException("Solde insuffisant");
		Retrait r = new Retrait(new Date(), mobntant, cp);
		operationRepository.save(r);
		cp.setSolde(cp.getSolde() - mobntant);
		compteRepository.save(cp);
		
	}

	@Override
	public void virement(String codeCpte1, String codeCpte2, double montant) {
		if(codeCpte1.equals(codeCpte2)){
			throw new RuntimeException("Impossibile de faire un virement sur le meme compte");
		}		
		retirer(codeCpte1, montant);
		verser(codeCpte2, montant);	
	}

	@Override
	public Page<Operation> listOperation(String codeCpte, int page, int size) {		
		return operationRepository.listOperation
				(codeCpte, new PageRequest(page, size));					
	}

}
