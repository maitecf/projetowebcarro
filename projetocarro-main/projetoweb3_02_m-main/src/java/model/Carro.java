package model;

public class Carro {
        private int idCarro;
        private String modelo;
        private String cor;
        private String placa;

    public Carro(){}    
        
    public Carro(String modelo, String cor, String placa) {
        this.modelo = modelo;
        this.cor = cor;
        this.placa = placa;
    }
    
    public Carro(int id, String modelo, String cor, String placa) {
        this.idCarro = id;
        this.modelo = modelo;
        this.cor = cor;
        this.placa = placa;
    }

    public int getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
        
        
}
