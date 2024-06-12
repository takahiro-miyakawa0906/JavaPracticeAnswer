package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.CharacterEntity;
import com.example.demo.Form.CharacterForm;

@Controller
public class RegisterTrainingController {

	@Autowired
	JdbcTemplate jdbc;

	@RequestMapping("/register_study")
	public String register_study(Model model) {


		return "register_study";
	}
	
	@RequestMapping("/register_study_answer")
	public String register_study(@ModelAttribute CharacterForm characterForm, Model model) {

		
//		↓↓↓↓↓↓↓↓↓↓↓↓↓↓答え↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
		
		
		String sql_register = "INSERT INTO characters(id, name, enemy_flg) VALUES(" + null + ",?,?)";
		
		
		
//		↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
		
		
		
		
		
		jdbc.update(sql_register, characterForm.getName(), characterForm.getEnemy_flg());
		
		String sql_select = "SELECT * FROM characters";
		List<Map<String, Object>> list = jdbc.queryForList(sql_select);
		List<CharacterEntity> characterList = new ArrayList<CharacterEntity>();
		for(Map<String, Object> user : list) {
			CharacterEntity characterEntity = new CharacterEntity();
			characterEntity.setName((String) user.get("name"));		
			characterEntity.setEnemy_flg((int) user.get("enemy_flg"));
			if(user.get("enemy_flg").equals(0)) {
				characterEntity.setEnemy_or_team("味方");
			}else {
				characterEntity.setEnemy_or_team("敵");
			}
			characterList.add(characterEntity);

		}
		model.addAttribute("characterList", characterList);

		return "register_study_answer";
	}

}