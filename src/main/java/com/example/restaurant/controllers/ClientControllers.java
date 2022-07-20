package com.example.restaurant.controllers;

import com.example.restaurant.models.entities.Client;
import com.example.restaurant.models.entities.Dish;
import com.example.restaurant.models.entities.OrderRestaurant;
import com.example.restaurant.models.entities.PaymentMethod;
import com.example.restaurant.models.repositorieGeneric.Intermediario;
import com.example.restaurant.models.repositories.ClientRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ClientControllers {

    /*
    @Autowired
    private ClientRepository clientRepository;

     */

    @RequestMapping("/telaLoginEntrar")
    public String telaLogin(Model m) {
        return "/telaLogin";
    }

    @RequestMapping("/telaLogin")
    public String login (Model m, String email, String password) {
        System.out.println(email);
        System.out.println(password);
        Client teste = ClientRepository.Login(email, password);

        System.out.println(teste);


        if (teste != null) {
            m.addAttribute("msg2", "Login com sucesso!");

            List<Dish> pratos = Intermediario.getCurrentInstance().readAllDish();
            m.addAttribute("prato", pratos);

            return "menu";
        } else {
            if (email.equals("root") && password.equals("root")) {
                return "/opAdm";
            } else {
                m.addAttribute("msg3", "E-mail ou senha incorretos!");
                return "telaLogin";
            }

        }

    }

    @RequestMapping("/telaCadastro")
    public String telaCadastro(Model m) {

        return "cadastro";
    }

    @RequestMapping("/cadastro")
    public String cadastro(Model m, Client c){
        Intermediario.getCurrentInstance().create(c);
        m.addAttribute("msg","Cliente cadastrado com sucesso");

        return "index";
    }


    @RequestMapping("/menu-modelPratos")
    public String exibirPratos(Model m){
        List<Dish> dishList = Intermediario.getCurrentInstance().readAllDish();
        m.addAttribute("prato", dishList);
        return "/menu";
    }

    @RequestMapping("/menu-modelPedido")
    public ModelAndView modelPedido(Model m){
        ModelAndView mv = new ModelAndView("fazerPedido");
        mv.addObject("realizar", "fazerPedido");
        List<PaymentMethod> listaPagamentos = Intermediario.getCurrentInstance().readAllPaymentMethod();
        m.addAttribute("pagamento", listaPagamentos);
        return mv;
    }

    @RequestMapping("/fazerPedido")
    public String fazerPedido(Model m, OrderRestaurant orderRestaurant, int id, PaymentMethod paymentMethod){
        orderRestaurant.setPagamento(Intermediario.getCurrentInstance().read(id));
        Intermediario.getCurrentInstance().create(orderRestaurant);
        m.addAttribute("msg", "Pedido Recebido!");
        System.out.println(orderRestaurant);
        System.out.println("--> ID " +id);
        List<OrderRestaurant> pedidos = Intermediario.getCurrentInstance().readAllOOrderRestaurant();
        m.addAttribute("pedido", pedidos);
        return "/historicoPedidosCliente";
    }
    @RequestMapping("/historicoPedidosCliente")
    public String telaHistorico(Model m, OrderRestaurant orderRestaurant){
        List<OrderRestaurant> pedidos = Intermediario.getCurrentInstance().readAllOOrderRestaurant();
        m.addAttribute("pedido", pedidos);
        return "/historicoPedidosCliente";
    }


















    /*
    @GetMapping
    public List<Client> readAll(){
        return clientRepository.findAll();
    }

    public Client getInfo(){
        Client client = new Client("123.456.789-00","João", "11 99999-9999", "joao@joao.com", "123456");
        return client;
    }


    @RequestMapping(method = {RequestMethod.POST})
    public void registration(@RequestBody Client client ){
        clientRepository.save(client);
    }





    @RequestMapping(method = {RequestMethod.PUT})
    public void update(@RequestBody Client client){
        clientRepository.save(client);
    }

    @DeleteMapping("/{cpf}")
    public void delete(@PathVariable String cpf){
        clientRepository.deleteById(cpf);
    }

    @GetMapping("/{cpf}")
    public Optional<Client> read(@PathVariable String cpf){
        return clientRepository.findById(cpf);
    }


*/


}
