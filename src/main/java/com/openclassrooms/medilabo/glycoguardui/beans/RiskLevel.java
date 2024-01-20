package com.openclassrooms.medilabo.glycoguardui.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RiskLevel {
	NONE("None"),
	BORDERLINE("Borderline"),
	INDANGER("In Danger"),
	EARLYONSET("Early Onset");
	
	private final String description;
}
