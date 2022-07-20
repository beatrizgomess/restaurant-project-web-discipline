package com.example.restaurant.models.repositories;

import com.example.restaurant.models.entities.Client;
import com.example.restaurant.models.repositorieGeneric.GenericRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientRepository implements GenericRepository<Client, String> {

    public ClientRepository(){

    }

    @Override
    public void create(Client client) {
            String sql = "insert into client(cpf,name,phone_contact,email,password) values(?,?,?,?,?)";

            try {

                PreparedStatement pstm = com.example.restaurant.models.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
                pstm.setString(1, String.valueOf(client.getCpf()));
                pstm.setString(2, client.getName());
                pstm.setString(3, client.getPhone_contact());
                pstm.setString(4, client.getEmail());
                pstm.setString(5, client.getPassword());
                pstm.execute();

            } catch (SQLException ex) {
                Logger.getLogger(ClientRepository.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClientRepository.class.getName()).log(Level.SEVERE, null, ex);
            }


    }


    @Override
    public List<Client> readAll() {
        String sql = "select * from client";

        List<Client> clientes = new ArrayList<>();

        try {

            PreparedStatement pstm = com.example.restaurant.models.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
            ResultSet result = pstm.executeQuery();

            while(result.next()){
                Client cliente =  new Client();
                cliente.setCpf(Integer.parseInt(result.getString("cpf")));
                cliente.setName(result.getString("name"));
                cliente.setPhone_contact(result.getString("phone_contact"));
                cliente.setEmail(result.getString("email"));

                clientes.add(cliente);
            }



        } catch (SQLException ex) {
            Logger.getLogger(ClientRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return clientes;


    }

    @Override
    public Client read(String t) {
        String sql = "select * from client where cpf=?";

        try {

            PreparedStatement pstm =  com.example.restaurant.models.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);

            pstm.setString(1, t);

            ResultSet result = pstm.executeQuery();

            if(result.next()){
                Client c =  new Client();
                c.setCpf(Integer.parseInt(t));
                c.setName(result.getString("name"));
                c.setPhone_contact(result.getString("phone_contact"));
                c.setEmail(result.getString("email"));
                c.setPassword(result.getString("password"));

                return c;
            }



        } catch (SQLException ex) {
            Logger.getLogger(ClientRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }


    public static Client Login(String email, String password) {
        String sql = "select * from client where email = ? and password = ?";

        try {

            PreparedStatement pstm = com.example.restaurant.models.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);

            pstm.setString(1, email);
            pstm.setString(2, password);

            ResultSet result = pstm.executeQuery();

            if(result.next()){
                Client c =  new Client();
                c.setEmail(result.getString("email"));
                c.setPassword(result.getString("password"));
                return c;

            }


        } catch (SQLException ex) {
            Logger.getLogger(ClientRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static void main(String args[]) {
        ClientRepository cr = new ClientRepository();

        }


    }




