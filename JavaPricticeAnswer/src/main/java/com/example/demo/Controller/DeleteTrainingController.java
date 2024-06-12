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

@Controller
public class DeleteTrainingController {

	@Autowired
	JdbcTemplate jdbc;

	@RequestMapping("/delete_study")
    public String delete_study(Model model) {
		
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
		
    	return "delete_study";
    }
	
	@RequestMapping("delete_study_answer/{id}")
	public String getEdit(@PathVariable("id") int id, Model model) {
		
		
//		↓↓↓↓↓↓↓↓↓↓↓↓↓答え↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
		
		String sql_delete = "DELETE FROM characters WHERE id = ?";
		
		
//		↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
		
		
		
		jdbc.update(sql_delete, id);
		
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
	
		return "delete_study_answer";
	}
	

	
	

}