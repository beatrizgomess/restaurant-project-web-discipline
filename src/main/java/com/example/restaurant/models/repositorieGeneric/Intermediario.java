package com.example.restaurant.models.repositorieGeneric;

import com.example.restaurant.models.entities.Client;
import com.example.restaurant.models.entities.Dish;
import com.example.restaurant.models.entities.OrderRestaurant;
import com.example.restaurant.models.entities.PaymentMethod;
import com.example.restaurant.models.repositories.ClientRepository;
import com.example.restaurant.models.repositories.OrderRestaurantRepository;
import com.example.restaurant.models.repositories.PaymenthMethodRepository;
import com.example.restaurant.models.repositories.RepositoryDish;

import java.util.List;

public class Intermediario {

    private static Intermediario myself = null;

    private GenericRepository<Client, String> clientRepository = null;
    private GenericRepository<PaymentMethod, Integer> paymentMethodRepository = null;
    private GenericRepository<Dish, String> dishRepository = null;
    private GenericRepository<OrderRestaurant, Integer> orderRestaurantRepository= null;


    private Intermediario(){
        this.clientRepository = new ClientRepository();
        this.paymentMethodRepository = new PaymenthMethodRepository();
        this.dishRepository = new RepositoryDish();
        this.orderRestaurantRepository = new OrderRestaurantRepository();
    }

    public static Intermediario getCurrentInstance(){
        if(myself == null){
            myself = new Intermediario();
        }
        return myself;
    }

    public void create(Client client){
        this.clientRepository.create(client);
    }

    public void create(PaymentMethod paymentMethod){
        this.paymentMethodRepository.create(paymentMethod);
    }

    public void create(Dish dish){
        this.dishRepository.create(dish);
    }

    public void create(OrderRestaurant orderRestaurant){
        this.orderRestaurantRepository.create(orderRestaurant);
    }

    public List<Dish> readAllDish(){
        return this.dishRepository.readAll();

    }

    public List<Client> readAllClientes() {
        return this.clientRepository.readAll();
    }
    public List<OrderRestaurant> readAllOOrderRestaurant(){
        return this.orderRestaurantRepository.readAll();
    }


    public Dish read(String id){
        return this.dishRepository.read(id);
    }

    public PaymentMethod read(int id){
        return this.paymentMethodRepository.read(id);
    }


    public List<PaymentMethod> readAllPaymentMethod(){
        return this.paymentMethodRepository.readAll();
    }


}
