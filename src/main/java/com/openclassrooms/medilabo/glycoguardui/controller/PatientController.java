package com.openclassrooms.medilabo.glycoguardui.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openclassrooms.medilabo.glycoguardui.beans.Patient;
import com.openclassrooms.medilabo.glycoguardui.proxies.NoteProxy;
import com.openclassrooms.medilabo.glycoguardui.proxies.PatientProxy;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class PatientController {
	private final PatientProxy patientProxy;
	private final NoteProxy noteProxy;

    @RequestMapping("/")
    public String recupererPatients(Model model) {
        // Appel au proxy avec les paramètres requis (numéro de page et tri).
        ResponseEntity<Page<Patient>> response = patientProxy.recupererPatients(0, "name");
        
        // Liste des patients vierge.
        // List<PatientBean> patients = Collections.emptyList();
        
        // Vérification de la réponse et extraction des données.
        // if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) patients = response.getBody().getContent();

        // Ajout de l'attribut et affichage.
        model.addAttribute("patients", response.getBody().getContent());
        return "patient/patients";
    }
    
	@RequestMapping("/patients/{id}")
	public String fichePatient(@PathVariable Long id, Model model) {
		Patient patient = patientProxy.recupererPatient(id);
		List<String> notes = noteProxy.recupererNotesPatient(id);

		model.addAttribute("patient", patient);
		model.addAttribute("notes", notes);

		return "patient/patient.fiche";
	}
}
