package edu.ap.spring.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Joke {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String firstName;

	@Column
    private String lastName;
    
    @Column
    private String joke;

    public Joke() {}
    
    public Joke(String firstName, String lastName, String joke) {
	    	this.firstName = firstName;
	    	this.lastName = lastName;
	    	this.joke = joke;
    }
    
    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getJoke() {
		return this.joke;
	}

	public void setJoke(String joke) {
		this.joke = joke;
	}
}
