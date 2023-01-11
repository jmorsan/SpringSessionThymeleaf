package es.iesjandula.springsessionthymeleaf.rest;

import es.iesjandula.springsessionthymeleaf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ThymeleafController
{
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String showForm (Model model)
    {
        model.addAttribute("user",new User());
        return "form.html";

    }

    @RequestMapping(method = RequestMethod.POST, value = "/submit")
    public String showUser (@ModelAttribute User user)
    {

        return "user.html";

    }

    @RequestMapping(method = RequestMethod.GET, value = "/otroEjemplo")
    public String getExampleHTML (Model model)
    {
        model.addAttribute("title", "UD2. El mundo de los microservicios");
        model.addAttribute("description", "<strong>Spring Boot</strong> y sus multiples usos");
        model.addAttribute("evaluacion", "3ªEvaluacion");
        model.addAttribute("curso", "<strong>2ºDesarrollo de Aplicaciones Multiplataforma</strong>");
        return "otroEjemplo.html";

    }


}
