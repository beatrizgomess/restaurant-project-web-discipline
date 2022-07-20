package com.example.restaurant.controllers;
import com.example.restaurant.models.entities.Client;
import com.example.restaurant.models.entities.Dish;
import com.example.restaurant.models.entities.PaymentMethod;
import com.example.restaurant.models.repositories.ClientRepository;
import com.example.restaurant.models.repositorieGeneric.Intermediario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdmController {

    @RequestMapping("/telaAdm")
    public String telaAdm(Model m){
        return "opAdm";
    }

    @RequestMapping("/opAdm-model")
    public ModelAndView opAdm(Model m){
        ModelAndView mv = new ModelAndView("cadastrarPrato");
        mv.addObject("cadastro", "cadastrarPrato");
        return mv;

    }

    @RequestMapping("/cadastrarPrato")
    public String cadastrarPrato(Model m, Dish dish){
        Intermediario.getCurrentInstance().create(dish);
        System.out.println(dish.getName());
        m.addAttribute("msg","Prato cadastrado com sucesso");
        return "opAdm";
    }


    @RequestMapping("/opAdm")
    public String visualizarClientes(Model m) {
        List<Client> cliente1 = Intermediario.getCurrentInstance().readAllClientes();
        m.addAttribute("cliente", cliente1);
        return "/visuClientes";

    }

    @RequestMapping("/opAdm-modelPaymenth")
    public ModelAndView modelPaymenth(Model m){
        ModelAndView modelAndView = new ModelAndView("cadastrarPagamento");
        modelAndView.addObject("cadastrarPagamento", "cadastrarPagamento");
        return modelAndView;

    }

    @RequestMapping("/cadastrarPagamento")
    public String cadastrarPagamento(Model m, PaymentMethod paymentMethod){
        Intermediario.getCurrentInstance().create(paymentMethod);
        m.addAttribute("msg","Forma de Pagamento cadastrado com sucesso");
        return "opAdm";
    }



/*
    @GetMapping("/visuClientes")
    public ModelAndView visuClientes(Model m){
        List<Client> clientes = this.clientRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("visuClientes");
        modelAndView.addObject("clientes", clientes);
        return modelAndView;
    }

 */



}
