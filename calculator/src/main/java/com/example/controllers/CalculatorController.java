package com.example.controllers;

import com.example.service.CalculateSimple;
import com.example.model.OperationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
public class CalculatorController {

    OperationModel operationModel = new OperationModel();

    @Autowired
    private CalculateSimple calculateSimple;

    @RequestMapping(value = "/calculator", method=RequestMethod.GET)
    public String getCalculatorPage(ModelMap model){
        model.addAttribute("operationModel",operationModel);
        return "calculator";
    }
    


    @RequestMapping(value="/calculator", params="add", method = RequestMethod.POST)
    public String add(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        model.addAttribute("result", calculateSimple.add(operationModel));
       
        return "calculator";
    }

    @RequestMapping(value="/calculator", params="subtract", method = RequestMethod.POST)
    public String subtract(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        model.addAttribute("result", calculateSimple.subtract(operationModel));
        return "calculator";
    }

    @RequestMapping(value="/calculator", params="multiply", method = RequestMethod.POST)
    public String multiply(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        model.addAttribute("result", calculateSimple.multiply(operationModel));
        return "calculator";
    }

    @RequestMapping(value="/calculator", params="divide", method = RequestMethod.POST)
    public String divide(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        model.addAttribute("result", calculateSimple.divide(operationModel));
        return "calculator";
    }

    @RequestMapping(value="/calculator", params="clearSimple", method = RequestMethod.POST)
    public String clearSimple(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        model.addAttribute("operationModel",  calculateSimple.clearSimple(operationModel));
        model.addAttribute("result", 0);
        return "calculator";
    }

    
}
