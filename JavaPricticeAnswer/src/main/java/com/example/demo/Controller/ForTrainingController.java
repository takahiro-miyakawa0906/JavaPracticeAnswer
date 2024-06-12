package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Form.ForStudyForm;

@Controller
public class ForTrainingController {

	@Autowired
	JdbcTemplate jdbc;

	@RequestMapping("/for_study")
	public String for_study(Model model) {

		return "for_study";
	}

	@RequestMapping("for_study_answer")
	public String for_study_answer(@ModelAttribute ForStudyForm forStudyForm, Model model) {

		List<Integer> for_answer_list = new ArrayList<>();

		int for_answer = (int) forStudyForm.getFor_answer();
		
		
//		↓↓↓↓↓↓↓↓↓答え↓↓↓↓↓↓↓↓↓↓
		
		
		for (int i = 1; i <= for_answer; i++) {
			for_answer_list.add(i);
		}
		
		
		
//		↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

		model.addAttribute("for_training", for_answer_list);
		return "for_study_answer";
	}

}