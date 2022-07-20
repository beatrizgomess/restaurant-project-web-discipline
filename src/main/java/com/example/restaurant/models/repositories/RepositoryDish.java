package com.example.restaurant.models.repositories;

import com.example.restaurant.models.entities.Client;
import com.example.restaurant.models.entities.Dish;
import com.example.restaurant.models.repositorieGeneric.GenericRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RepositoryDish implements GenericRepository<Dish, String> {

    public RepositoryDish() {
    }

    @Override
    public void create(Dish dish) {
        String sql = "insert into dish(name,description,price) values(?,?,?)";

        try {

            PreparedStatement pstm = com.example.restaurant.models.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
            pstm.setString(1, dish.getName());
            pstm.setString(2, dish.getDescription());
            pstm.setString(3, String.valueOf(dish.getPrice()));
            pstm.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ClientRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Dish> readAll() {
        String sql = "select * from dish";
        List<Dish> dishes = new ArrayList<>();

        try{
            PreparedStatement preparedStatement = com.example.restaurant.models.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){
                Dish dish =  new Dish();
                dish.setId(Integer.parseInt(result.getString("id")));
                dish.setName(result.getString("name"));
                dish.setDescription(result.getString("description"));
                dish.setPrice(Double.valueOf(result.getString("price")));

                dishes.add(dish);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dishes;
    }

    @Override
    public Dish read(String t) {
        String sql = "select * from dish where id=?";

        try {
            PreparedStatement pstm = com.example.restaurant.models.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
            pstm.setString(1, t);

            ResultSet result = pstm.executeQuery();

            if(result.next()){
                Dish dish =  new Dish();
                dish.setId(Integer.parseInt(result.getString("id")));
                dish.setName(result.getString("name"));
                dish.setDescription(result.getString("description"));
                dish.setPrice(Double.valueOf(result.getString("price")));

                return dish;
            }



        } catch (SQLException ex) {
            Logger.getLogger(RepositoryDish.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RepositoryDish.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }


    public static void main(String args[]) {

        /*Carro c = new Carro();

        c.setPlaca("kct-3323");
        c.setModelo("opala");
        c.setCor("bege");
        c.setFabricante("chevorusut");*/

        RepositoryDish repositoryDish = new RepositoryDish();

    }

}
