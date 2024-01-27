package com.openclassrooms.medilabo.glycoguardui.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    
	@ExceptionHandler(NotFoundException.class)
	public String handleNotFoundException(NotFoundException ex, Model model) {
        model.addAttribute("error", ex.getMessage());
		return "error";
	}
	
	@ExceptionHandler(BadRequestException.class)
	public String handleBadRequestException(BadRequestException ex, Model model) {
        model.addAttribute("error", ex.getMessage());
		return "error";
	}
	
	@ExceptionHandler(CustomServerException.class)
    public String handleServerException(CustomServerException ex, Model model) {
        model.addAttribute("error", ex.getMessage());
        return "error";
    }
}
