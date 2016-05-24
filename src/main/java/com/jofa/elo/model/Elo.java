package com.jofa.elo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "elo", uniqueConstraints = { 
		@UniqueConstraint(columnNames = "username")})
public class Elo implements java.io.Serializable {

	private static final long serialVersionUID = -972384603595328514L;
	
	private String username;
	private Integer elo;
	

	public Elo() {
	}

	public Elo(String username, Integer elo ) {
		super();
		this.username = username;
		this.elo = elo;		
	}

	@Id
	@GeneratedValue
	@Column(name = "username", unique = true, nullable = false, length = 44)
	public String getId() {
		return this.username;
	}

	public void setUser_Id(String username) {
		this.username = username;
	}

	
	@GeneratedValue
	@Column(name = "elo", nullable = true, length = 10)
	public Integer getElo() {
		return this.elo;
	}

	public void setElo(Integer elo) {
		this.elo = elo;
	}
	

	@Override
	public String toString() {
		return "Elo [user_id=" + username + ", elo=" + elo+ "]";
	}
}
