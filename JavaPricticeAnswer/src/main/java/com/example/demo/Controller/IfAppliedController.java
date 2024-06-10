package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.CharacterEntity;

@Controller
public class IfAppliedController {

	@Autowired
	JdbcTemplate jdbc;

	@RequestMapping("/if_applied")
	public String if_applied(Model model) {

		return "if_applied";
	}

	@RequestMapping("/if_applied_answer")
	public String if_applied_answer(Model model) {

		String sql = "SELECT * FROM characters";
		List<Map<String, Object>> list = jdbc.queryForList(sql);
		List<CharacterEntity> characterList = new ArrayList<CharacterEntity>();
		for (Map<String, Object> user : list) {
			if (user.get("enemy_flg").equals(0)) {
				CharacterEntity characterEntity = new CharacterEntity();
				characterEntity.setId(Integer.parseInt(user.get("id").toString()));
				characterEntity.setName((String) user.get("name"));
				characterEntity.setEnemy_flg((int) user.get("enemy_flg"));
				if (user.get("enemy_flg").equals(0)) {
					characterEntity.setEnemy_or_team("味方");
				} else {
					characterEntity.setEnemy_or_team("敵");
				}
				characterList.add(characterEntity);
			}
		}
		model.addAttribute("characterList", characterList);
		
		return "if_applied_answer";
	}

}