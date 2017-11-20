package com.example.topcolleguesbackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.topcolleguesbackend.entite.Collegue;
import com.example.topcolleguesbackend.repository.CollegueRepository;


@RestController
@RequestMapping("/collegues")
@CrossOrigin(origins = {"http://localhost:4200", "*"})
public class CollegueController {
	/** colRep : CollegueRepository */
	@Autowired
	CollegueRepository colRep;

	/**
	 * Méthode get de listage des collegues
	 * 
	 * @return
	 */
	@GetMapping("")
	public List<Collegue> listerCollegue() {
		return this.colRep.findAll();
	}

	/**
	 * Méthode post d'ajout de collegue
	 * Un unique pseudo/collègue
	 * @param col
	 * @return
	 */
	@PostMapping("/ajouter")
	public Collegue ajouter(@RequestBody Collegue col) {
		System.out.println(col);
		Optional<Collegue> optCol = this.colRep.findAll().stream()
				.filter(collegue -> collegue.getPseudo() == col.getPseudo()).findAny();
		if (!optCol.isPresent()) {
			this.colRep.save(col);
		}
		return this.colRep.findOne(col.getId());
	}

	/**
	 * Méthode put de modification du score
	 * 
	 * @param col
	 * @param pseudo
	 * @return collegue
	 */
	@PutMapping("/{pseudo}/score")
	public Collegue update(@PathVariable String pseudo, @RequestBody String avis) {

		Collegue oldCol = this.colRep.findByPseudo(pseudo);
		if (avis.equals("jaime"))
			oldCol.setScore(oldCol.getScore() + 5);
		else if (avis.equals("jeDeteste"))
			oldCol.setScore(oldCol.getScore() - 5);

		this.colRep.save(oldCol);
		return oldCol;
	}

	@GetMapping("/{pseudo}")
	public Collegue getCollegueByPseudo(@PathVariable String pseudo) {

		return this.colRep.findByPseudo(pseudo);
	}

}
