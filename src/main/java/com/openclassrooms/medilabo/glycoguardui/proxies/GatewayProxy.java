package com.openclassrooms.medilabo.glycoguardui.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.openclassrooms.medilabo.glycoguardui.beans.Note;
import com.openclassrooms.medilabo.glycoguardui.beans.Patient;
import com.openclassrooms.medilabo.glycoguardui.beans.RiskLevel;

@FeignClient(name = "microservice-gateway", url = "localhost:9103")
public interface GatewayProxy {
	
    @GetMapping("/patients")
    ResponseEntity<Page<Patient>> recupererPatients(@RequestParam("page") int numPage, @RequestParam("sort") String sort);

    @GetMapping("/patients/{id}")
    Patient recupererPatient(@PathVariable("id") Long idPatient);
    
	@GetMapping("/notes/{id}")
    List<Note> recupererNotesPatient(@RequestParam("id") Long numPatient);
	
	@PostMapping("/notes/add")
	Note ajouterNote(@RequestBody Note note);
	
	@GetMapping("/evaluator/{id}")
	RiskLevel evaluate(@PathVariable("id") Long idPatient);
}
