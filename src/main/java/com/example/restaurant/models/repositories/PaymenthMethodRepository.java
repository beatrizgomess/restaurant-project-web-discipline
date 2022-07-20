package com.example.restaurant.models.repositories;

import com.example.restaurant.models.entities.PaymentMethod;
import com.example.restaurant.models.repositorieGeneric.GenericRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PaymenthMethodRepository implements GenericRepository<PaymentMethod, Integer> {
    @Override
    public void create(PaymentMethod paymentMethod) {
        String sql = "insert into payment_method(description) values(?)";

        try {

            PreparedStatement pstm = com.example.restaurant.models.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
            pstm.setString(1, paymentMethod.getDescription());
            pstm.execute();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ClientRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<PaymentMethod> readAll() {
        String sql = "select * from payment_method";
        List<PaymentMethod> payment_method = new ArrayList<>();

        try{
            PreparedStatement preparedStatement = com.example.restaurant.models.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){
                PaymentMethod paymentMethod =  new PaymentMethod();
                paymentMethod.setId(Integer.parseInt(result.getString("id")));
                paymentMethod.setDescription(result.getString("description"));


                payment_method.add(paymentMethod);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaymentMethod.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PaymentMethod.class.getName()).log(Level.SEVERE, null, ex);
        }

        return payment_method;
    }

    @Override
    public PaymentMethod read(Integer t) {
        String sql = "select * from payment_method where id = ?";

        try {
            PreparedStatement pstm = com.example.restaurant.models.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);

            pstm.setInt(1, t);

            ResultSet r = pstm.executeQuery();

            if(r.next()){

                PaymentMethod v = new PaymentMethod();

                v.setId(r.getInt("id"));
                v.setDescription(r.getString("description"));

                return v;

            }

        } catch (SQLException ex) {
            Logger.getLogger(PaymenthMethodRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PaymenthMethodRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

