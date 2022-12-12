package de.tekup.jpademo.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class ViewCtrl  {
    @GetMapping({"/","/index"})
    public String landingPage(Model model){
        String today = LocalDate.now()
                .format(DateTimeFormatter.ofPattern("dd MMMM yyyy"));
        model.addAttribute("today",today);
        return "index";
    }

    @GetMapping("/about")
    public String aboutPage(){
        return "about";
    }

    //@RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error-404";
            }
        }
        return "error";
    }
}
