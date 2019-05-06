package com.zjky.webapps.controller;

import com.zjky.webapps.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/",  method = RequestMethod.GET)
public class HomeController {

    @Autowired
    HomeService homeService;

    //映射一个action
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView getHomePage(){
        //返回一个index.jsp这个视图
        ModelAndView mv= new ModelAndView("home", "todos", homeService.getTodos());
        return mv;
    }

    @RequestMapping(value = "/todo/creation", method = RequestMethod.POST)
    public ModelAndView addTodo(@RequestParam String todoName){
        homeService.addTodo(todoName);
        return new ModelAndView("redirect:/home");
    }

    @ResponseBody
    @RequestMapping(value = "/todo/update/{id}", method = RequestMethod.PUT)
    public String updateTodo(@PathVariable int id) {
        homeService.updateTodoStatus(id);
        return "Success";
    }

    @ResponseBody
    @RequestMapping(value = "/todo/deletion/{id}", method = RequestMethod.DELETE)
    public String deleteTodo(@PathVariable int id) {
        homeService.deleteTodo(id);
        return "Success";
    }

}