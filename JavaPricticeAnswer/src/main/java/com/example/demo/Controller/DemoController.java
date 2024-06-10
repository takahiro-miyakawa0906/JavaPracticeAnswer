package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    
	@Autowired
	JdbcTemplate jdbc;
	
    @GetMapping("/index")
    public String index(Model model) {
    	    			
        return "index";
    }
}