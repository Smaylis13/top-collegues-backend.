package com.example.topcolleguesbackend.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Collegue {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String pseudo;
	@Column
	private String url;
	@Column
	private int score;
	
	public int getId() {
		return id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public String getUrl() {
		return url;
	}

	public int getScore() {
		return score;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Collegue() {
		// TODO Auto-generated constructor stub
	}

	public Collegue(String ps, String pUrl, int i) {
		
		this.pseudo = ps;
		
		this.url = pUrl;

		this.score = i;
	}
}
