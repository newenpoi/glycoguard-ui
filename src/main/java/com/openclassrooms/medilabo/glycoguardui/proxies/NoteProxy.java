package com.openclassrooms.medilabo.glycoguardui.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "microservice-gateway", url = "localhost:9103")
public interface NoteProxy {
    
	@GetMapping("/notes/{patId}")
    List<String> recupererNotesPatient(@RequestParam("patId") Long numPatient);
}
