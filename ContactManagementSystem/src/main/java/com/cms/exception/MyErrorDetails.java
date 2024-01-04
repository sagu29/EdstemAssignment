package com.cms.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MyErrorDetails {
	private LocalDateTime localDateTime;
	private String messege;
	private String discription;
	

}
