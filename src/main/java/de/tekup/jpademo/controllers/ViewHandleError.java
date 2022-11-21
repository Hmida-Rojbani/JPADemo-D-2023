package de.tekup.jpademo.controllers;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ViewHandleError {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model){
        model.addAttribute("errorCode","400");
        model.addAttribute("errorMsg",e.getMessage());
        return "error";
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public String handleException(DataIntegrityViolationException e, Model model){
        model.addAttribute("errorCode","400");
        model.addAttribute("errorMsg","A Unique Value already Exist in DB");
        return "error";
    }
}
