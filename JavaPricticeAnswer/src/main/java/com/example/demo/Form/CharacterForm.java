package com.example.demo.Form;

import java.io.Serializable;

import lombok.Data;

@Data

public class CharacterForm implements Serializable {
	
	int id;
	String name;
	int enemy_flg;

}
