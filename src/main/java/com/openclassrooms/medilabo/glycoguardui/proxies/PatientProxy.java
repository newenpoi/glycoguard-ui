package com.openclassrooms.medilabo.glycoguardui.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.openclassrooms.medilabo.glycoguardui.beans.Patient;

@FeignClient(name = "microservice-gateway", url = "localhost:9103")
public interface PatientProxy {
	
    @GetMapping("/patients")
    ResponseEntity<Page<Patient>> recupererPatients(@RequestParam("page") int numPage, @RequestParam("sort") String sort);

    @GetMapping("/patients/{id}")
    Patient recupererPatient(@PathVariable("id") Long id);
}
