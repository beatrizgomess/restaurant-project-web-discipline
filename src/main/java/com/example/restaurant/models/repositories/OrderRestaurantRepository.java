package com.example.restaurant.models.repositories;

import com.example.restaurant.models.entities.Client;
import com.example.restaurant.models.entities.Dish;
import com.example.restaurant.models.entities.OrderRestaurant;
import com.example.restaurant.models.entities.PaymentMethod;
import com.example.restaurant.models.repositorieGeneric.GenericRepository;
import org.aspectj.weaver.ast.Or;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderRestaurantRepository implements GenericRepository<OrderRestaurant, Integer> {

    public OrderRestaurantRepository(){

    }
    @Override
    public void create(OrderRestaurant orderRestaurant) {
        String sql = "insert into order_restaurant(order_time,note,cpf_cliente,id_prato, id_pagamento) values(?,?,?,?,?)";

        try {

            PreparedStatement pstm = com.example.restaurant.models.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
            pstm.setString(1, String.valueOf((orderRestaurant.getOrder_time())));
            pstm.setString(2, (orderRestaurant.getNote()));
            pstm.setString(3, (orderRestaurant.getCpf_cliente()));
            pstm.setString(4, (orderRestaurant.getId_prato()));
            pstm.setInt(5,    (orderRestaurant.getPagamento().getId()));



            pstm.execute();

        } catch (SQLException ex) {
            Logger.getLogger(OrderRestaurantRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderRestaurantRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<OrderRestaurant> readAll() {
        String sql = "select * from order_restaurant";

        List<OrderRestaurant> pedidos = new ArrayList<>();

        try {

            PreparedStatement pstm = com.example.restaurant.models.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);


            ResultSet r = pstm.executeQuery();

            while(r.next()){

                OrderRestaurant v = new OrderRestaurant();

                v.setId(r.getInt("id"));
                v.setNote(r.getString("note"));

                ClientRepository cliente = new ClientRepository();
                Client c = cliente.read(String.valueOf(r.getInt("cpf_cliente")));
                v.setCliente(c);


                PaymenthMethodRepository pagamento = new PaymenthMethodRepository();
                PaymentMethod p = pagamento.read(r.getInt("id_pagamento"));
                v.setPagamento(p);


                RepositoryDish prato = new RepositoryDish();
                Dish m = prato.read(String.valueOf(r.getInt("id_prato")));
                v.setPrato(m);


                pedidos.add(v);


            }

        } catch (SQLException ex) {
            Logger.getLogger(OrderRestaurantRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderRestaurantRepository.class.getName()).log(Level.SEVERE, null, ex);
        }


        return pedidos;
    }


    @Override
    public OrderRestaurant read(Integer t) {
        return null;
    }
}
