package app.main;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="livre")
public class Livre {
	@Id private Integer id;
	@Column(name="TITRE", length=255,nullable=false)
	private String titre;
	@Column(name="AUTEUR", length=50,nullable=false)
	private String auteur;

	@ManyToMany
	@JoinTable(name="COMPO", joinColumns=@JoinColumn(name="ID_LIV", referencedColumnName="ID"), inverseJoinColumns=@JoinColumn(name="ID_EMP", referencedColumnName="ID"))
	private Set<Emprunt> emprunts;
	
	public Livre(){	
	}
	
	public String toString(){
		return this.id + " - " + this.titre + " - " + this.auteur;
	}
}
