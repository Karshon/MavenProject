package com.how2java.controller;

import com.how2java.service.impl.categoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/categoryname")
public class CategoryController {
    @Autowired
    private categoryServiceImpl cateService;
    @RequestMapping("/getcategoryname")
    public ModelAndView hello(ModelAndView mv,@RequestParam String id){
        String name = cateService.getCategoryName(id);
        mv.addObject("categoryname",name);
        mv.setViewName("categoryname");
        return mv;
    }
}
