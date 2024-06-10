package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.CharacterEntity;
import com.example.demo.Form.CharacterForm;

@Controller
public class UpdateTrainingController {

	@Autowired
	JdbcTemplate jdbc;

	@RequestMapping("/update_study")
    public String update_study(Model model) {
		
		String sql = "SELECT * FROM characters";
		List<Map<String, Object>> list = jdbc.queryForList(sql);
		List<CharacterEntity> characterList = new ArrayList<CharacterEntity>();
		for(Map<String, Object> user : list) {
			CharacterEntity characterEntity = new CharacterEntity();
			characterEntity.setId(Integer.parseInt(user.get("id").toString()));
			characterEntity.setName((String) user.get("name"));		
			characterEntity.setEnemy_flg((int) user.get("enemy_flg"));
			if(user.get("enemy_flg").equals(0)) {
				characterEntity.setEnemy_or_team("味方");
			}else{
				characterEntity.setEnemy_or_team("敵");
			}
			
			characterList.add(characterEntity);

		}
		
		
		model.addAttribute("characterForm", characterList);
		
	
    	return "update_study";
    }
	
	@RequestMapping("update_study02/{id}")
	public String getEdit(@PathVariable("id") int id, Model model) {
		
		String sql = "SELECT * FROM characters WHERE id = ?";
		List<Map<String, Object>> list = jdbc.queryForList(sql, id);
		List<CharacterEntity> characterList = new ArrayList<CharacterEntity>();
		for(Map<String, Object> user : list) {
			CharacterEntity characterEntity = new CharacterEntity();
			characterEntity.setId(Integer.parseInt(user.get("id").toString()));
			characterEntity.setName((String) user.get("name"));		
			characterEntity.setEnemy_flg((int) user.get("enemy_flg"));
			if(user.get("enemy_flg").equals(0)) {
				characterEntity.setEnemy_or_team("味方");
			}else{
				characterEntity.setEnemy_or_team("敵");
			}
			
			characterList.add(characterEntity);

		}
		CharacterEntity updateData = new CharacterEntity();
		updateData.setId(characterList.get(0).getId());
		updateData.setName(characterList.get(0).getName());
		updateData.setEnemy_flg(characterList.get(0).getEnemy_flg());
		model.addAttribute("characterForm", updateData);
		
		return "update_study02";
	}
	
	@RequestMapping("update_study_answer")
	public String update_study_answer(CharacterForm characterForm, Model model) {
		
		String sql_update = "UPDATE characters SET name=?, enemy_flg=? where id = ?";
    	jdbc.update(sql_update, characterForm.getName(), characterForm.getEnemy_flg(), characterForm.getId());
    	
    	String sql_select = "SELECT * FROM characters";
		List<Map<String, Object>> list = jdbc.queryForList(sql_select);
		List<CharacterEntity> characterList = new ArrayList<CharacterEntity>();
		for(Map<String, Object> user : list) {
			CharacterEntity characterEntity = new CharacterEntity();
			characterEntity.setId(Integer.parseInt(user.get("id").toString()));
			characterEntity.setName((String) user.get("name"));		
			characterEntity.setEnemy_flg((int) user.get("enemy_flg"));
			if(user.get("enemy_flg").equals(0)) {
				characterEntity.setEnemy_or_team("味方");
			}else{
				characterEntity.setEnemy_or_team("敵");
			}
			
			characterList.add(characterEntity);

		}
		
		model.addAttribute("characterForm", characterList);
		

		return "update_study_answer";
	}
	
	

}