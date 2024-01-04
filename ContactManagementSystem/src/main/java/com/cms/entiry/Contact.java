package com.cms.entiry;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Contact {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "Please enter name")
	@NotBlank
	private String name;
	
	@NotNull(message = "Please enter address")
	@NotBlank
	private String address;
	
	@Column(unique= true)
	@NotNull(message = "Please enter Phonenumber")
	@NotBlank
	private String phoneNumber;
	
	@NotNull(message = "Please enter email")
	@NotBlank
	private String email;
	
	

}
