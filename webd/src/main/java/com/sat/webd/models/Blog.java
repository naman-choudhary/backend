package com.sat.webd.models;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Blog {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String author;
    private LocalDate date;
    private LocalTime time;
    @Lob
    @Column(columnDefinition="LONGBLOB")
    private byte[] image;
    private String description;
    private String quote;
	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Blog(long id, String title, String author, LocalDate date, LocalTime time, byte[] image, String description,
			String quote) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.date = date;
		this.time = time;
		this.image = image;
		this.description = description;
		this.quote = quote;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getQuote() {
		return quote;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
}
