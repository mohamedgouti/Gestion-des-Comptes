package org.sid.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("R")
public class Retrait  extends Operation{

	public Retrait() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Retrait(Date dateOperations, double montant, Compte compte) {
		super(dateOperations, montant, compte);
		// TODO Auto-generated constructor stub
	}

	
}
