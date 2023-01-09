package es.iesjandula.springsessionthymeleaf.rest;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
public final class MyRestController
{
    /**
     * Public Constructor
     */
    public MyRestController()
    {
        //Empty constructor
    }

    @RequestMapping(method = RequestMethod.GET, value = "/userVisits")
    public ResponseEntity<Integer> handleRequest(HttpSession session)
    {
        //Get the value of the session key(int)
        Integer userVisits = (Integer) session.getAttribute("userVisits");

        //Check if value is null to initialize it
        if(userVisits == null)
        {
            userVisits  = 0;
        }

        //Increment the value
        userVisits++;

        //Get the previus value
        System.out.println("User visits: " + userVisits);

        //Store in this session the current value
        session.setAttribute("userVisits", userVisits);

        //Return the value
        return ResponseEntity.ok().body(userVisits);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ordenarEnteros/{numeroEntero}")
    public ResponseEntity<List<Integer>> ordenarEnteros(HttpSession session, @PathVariable(value = "numeroEntero" )final Integer numeroEntero)
    {
        //Get the value of the session key(int)
        List<Integer> listaNumeros = (List<Integer>) session.getAttribute("numeroEntero");;


        //Check if value is null to initialize it
        if(listaNumeros == null)
        {
            listaNumeros  = new ArrayList<>();
        }

        listaNumeros.add(numeroEntero);

        Collections.sort(listaNumeros);



        //Get the previus value
        System.out.println("Lista numeros ordenados: " + listaNumeros);

        //Store in this session the current value
        session.setAttribute("numeroEntero", listaNumeros);

        //Return the value
        return ResponseEntity.ok().body(listaNumeros);
    }
}
