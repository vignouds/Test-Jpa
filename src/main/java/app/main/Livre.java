package app.main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="livre")
public class Livre {
	@Id private Integer id;
	@Column(name="TITRE", length=255,nullable=false)
	private String titre;
	@Column(name="AUTEUR", length=50,nullable=false)
	private String auteur;
	
	public Livre(){	
	}
	
	public String toString(){
		return this.id + " - " + this.titre + " - " + this.auteur;
	}
}
