package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Form.IfStudyForm;

@Controller
public class IfTrainingController {

	@Autowired
	JdbcTemplate jdbc;

	@RequestMapping("/if_study")
    public String if_study(Model model) {
	
    	return "if_study";
    }
	
	@RequestMapping("if_study_answer")
	public String if_study_answer(@ModelAttribute IfStudyForm ifStudyForm, Model model) {
		
		String if_training;
		
			int if_answer = (int) ifStudyForm.getIf_answer();
			if(if_answer%3==0) {
				if_training = "3の倍数です";
			}else if(if_answer%5==0) {
				if_training = "５の倍数です";
			}else {
				if_training = "３の倍数でも、５の倍数でもありません";
			}
	
			
		model.addAttribute("if_training", if_training);
		return "if_study_answer";
	}
	
	

}