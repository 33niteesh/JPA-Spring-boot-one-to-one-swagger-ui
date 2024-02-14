package com.employeedb.jpa.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "contact")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String city;
    private String number;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}



	public Contact( String city, String number) {
		super();
		this.city = city;
		this.number = number;
	}

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}

