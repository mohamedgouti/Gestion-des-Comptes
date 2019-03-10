package org.sid;

import java.util.Date;

import org.sid.dao.ClientRepository;
import org.sid.dao.CompteRepository;
import org.sid.dao.OperationRepository;
import org.sid.entities.Client;
import org.sid.entities.Compte;
import org.sid.entities.CompteCourant;
import org.sid.entities.CompteEpargne;
import org.sid.entities.Retrait;
import org.sid.entities.Versement;
import org.sid.metier.IBanqueMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VotreBanqueApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private IBanqueMetier banqeMetier;

	public static void main(String[] args) {
		SpringApplication.run(VotreBanqueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {		
//		Client C1 = clientRepository.save(new Client("Med1", "Med1@esprit.tn"));
//		Client C2 = clientRepository.save(new Client("Med2", "Med2@esprit.tn"));
//
//		Compte cp1 = compteRepository.save(new CompteCourant("C1", new Date(), 9000, C1, 6000));
//		Compte cp2 = compteRepository.save(new CompteEpargne("C2", new Date(), 6000, C2, 5.5));
//
//		operationRepository.save(new Versement(new Date(), 9000, cp1));
//		operationRepository.save(new Versement(new Date(), 6000, cp1));
//		operationRepository.save(new Versement(new Date(), 2300, cp1));
//		operationRepository.save(new Retrait(new Date(), 9000, cp1));
//
//		operationRepository.save(new Versement(new Date(), 2300, cp2));
//		operationRepository.save(new Versement(new Date(), 400, cp2));
//		operationRepository.save(new Versement(new Date(), 2300, cp2));
//		operationRepository.save(new Retrait(new Date(), 3000, cp2));
//
//		banqeMetier.verser("c1", 111111);	
	}
}
