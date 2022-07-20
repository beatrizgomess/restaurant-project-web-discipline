package com.example.restaurant.models.entities;

public class OrderRestaurant {

    private int id;
    private Long order_time;
    private double price;
    private String note;
    private String cpf_cliente;
    private String id_prato;
    private int id_formaPagamento;
    private Dish prato;
    private PaymentMethod pagamento;
    private Client cliente;


    public Client getCliente() {
        return cliente;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }

    public Dish getPrato() {
        return prato;
    }

    public void setPrato(Dish prato) {
        this.prato = prato;
    }

    public PaymentMethod getPagamento() {
        return pagamento;
    }

    public void setPagamento(PaymentMethod pagamento) {
        this.pagamento = pagamento;
    }

    public int getId_formaPagamento() {
        return id_formaPagamento;
    }

    public void setId_formaPagamento(int id_formaPagamento) {
        this.id_formaPagamento = id_formaPagamento;
    }

    public String getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }

    public String getId_prato() {
        return id_prato;
    }

    public void setId_prato(String id_prato) {
        this.id_prato = id_prato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Long order_time) {
        this.order_time = order_time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
