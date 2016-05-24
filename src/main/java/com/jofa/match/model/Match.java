package com.jofa.match.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "match", uniqueConstraints = { 
		@UniqueConstraint(columnNames = "id")})
public class Match implements java.io.Serializable {

	private static final long serialVersionUID = -972384603595328514L;
	
	private Integer id;
	private String w_username;
	private String l_username;
	private Date play_date;

	public Match() {
	}

	public Match(Integer id, String w_username, String l_username, Date play_date) {
		super();
		this.id = id;
		this.w_username = w_username;
		this.l_username = l_username;
		this.play_date = play_date;
	}

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false, length = 9)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	@GeneratedValue
	@Column(name = "w_username", nullable = true, length = 10)
	public String getW_Id() {
		return this.w_username;
	}

	public void setW_Id(String w_id) {
		this.w_username = w_id;
	}
	
	
	@GeneratedValue
	@Column(name = "l_username", nullable = true, length = 10)
	public String getL_Id() {
		return this.l_username;
	}

	public void setL_Id(String l_id) {
		this.l_username = l_id;
	}
	
	
	@GeneratedValue
	@Column(name = "play_date", nullable = true)
	public Date getPlay_date() {
		return this.play_date;
	}

	public void setPlay_date(Date play_date) {
		this.play_date = play_date;
	}

	@Override
	public String toString() {
		return "Match [Winner id=" + w_username + ", Loser id=" + w_username + ", play date=" + play_date + "]";
	}
}
