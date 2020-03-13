package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TelefoneUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 
	private Long id;
	 
	
	@Column (nullable = false)
	private String tipo;
	
	@Column (nullable = false)
	private String numero;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private UsuarioPessoa usuarioPessoa;
	
	
	
	
}