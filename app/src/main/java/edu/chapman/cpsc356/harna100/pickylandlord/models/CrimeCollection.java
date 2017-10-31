package edu.chapman.cpsc356.harna100.pickylandlord.models;

import java.util.ArrayList;
import java.util.List;

public class CrimeCollection {
	private List<CrimeModel> crimes;
	private static CrimeCollection singleton;

	private CrimeCollection(){
		crimes = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			CrimeModel cm = new CrimeModel();
			cm.setTitle("Crime # " + (i+1));
			cm.setSolved(i % 2 == 0);
			crimes.add(cm);

		}
	}

	public CrimeModel getCrime(String id){
		for (CrimeModel crime : crimes) {
			if(crime.getId().equals(id)){
				return crime;
			}
		}
		return null;
	}

	public void addCrime(CrimeModel cm){
		crimes.add(cm);
	}


	public static CrimeCollection getInstance(){
		if(singleton == null){
			singleton = new CrimeCollection();
		}

		return singleton;
	}
}
