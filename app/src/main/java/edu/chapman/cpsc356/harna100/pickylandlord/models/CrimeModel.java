package edu.chapman.cpsc356.harna100.pickylandlord.models;

import org.joda.time.DateTime;

import java.util.UUID;

public class CrimeModel {
	private String title;
	private boolean solved;
	private String id;
	private DateTime creationDate;


	public CrimeModel() {
		this.id = UUID.randomUUID().toString();
		this.creationDate = DateTime.now();
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isSolved() {
		return solved;
	}

	public void setSolved(boolean solved) {
		this.solved = solved;
	}

	public DateTime getCreationDate() {
		return creationDate;
	}
}
