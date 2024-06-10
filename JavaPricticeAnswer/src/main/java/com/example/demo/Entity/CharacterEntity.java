package com.example.demo.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;


@Data
@Component
public class CharacterEntity {
	
	@Id

    @Column(name = "id")

    @GeneratedValue(strategy = GenerationType.IDENTITY)

	Integer id;
	
	
	@Column(name = "name")
    private String name;

 

    @Column(name = "enemy_flg")
    private int enemy_flg;

 
    @Column(name = "name")
    private String enemy_or_team;
 

}
