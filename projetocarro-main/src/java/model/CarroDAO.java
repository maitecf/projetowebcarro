package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarroDAO {
        private static Connection conn;
        
        public CarroDAO() throws ClassNotFoundException, SQLException {
            conn = MyConnection.getConnection();
        }
        
        //INSERT
        public void insertCarro(Carro mapa) throws SQLException{
           //Criando a query genérica
            String sql = "INSERT INTO carro(modelo, cor, placa)"
                                        + "VALUES (?, ?, ?)";
            
            //Instanciando o objeto de conexão informando a query
            PreparedStatement prep = conn.prepareStatement(sql);
            
            //Informando os parâmetros enviados para a query
            prep.setString(1, mapa.getModelo());
            prep.setString(2, mapa.getCor());
            prep.setString(3, mapa.getPlaca());
            
            prep.execute(); //Lançando o SQL pronto na base de dados
            prep.close();
        }//Fim do método insertCarro
        
        
        //SELECT
        public ArrayList<Carro> listCarro() throws SQLException {
            //Criação de uma lista vazia (específica de Carros)
            ArrayList<Carro> list = new ArrayList<>();
            
            String sql = "SELECT * FROM carro";
            PreparedStatement prep = conn.prepareStatement(sql);
            
            ResultSet result = prep.executeQuery();
            
            //Enquanto existirem registros, executará este laço de repetição
            while(result.next()) {
                //Criar um objeto vazio da classe Carro
                Carro mapa = new Carro();
                
                //Inserir os atributos a partir dos dados de cada coluna
                mapa.setIdCarro(result.getInt("cod"));
                mapa.setModelo(result.getString("modelo"));
                mapa.setCor(result.getString("cor"));
                mapa.setPlaca(result.getString("placa"));
                
                //Inserir o objeto preenchido na lista
                list.add(mapa);
            }
            
            return list;
        }//Fim do método listCarro
        
        
        //DELETE
        public void deleteCarro(int id) throws SQLException {
            String sql = "DELETE FROM carro WHERE cod = " + id;
            
            PreparedStatement prep = conn.prepareStatement(sql);
            
            prep.execute();
            prep.close();
        }//Fim do método deleteCarro
        
        
        //SELECT BY ID
        public Carro listOneCarro(int cod) throws SQLException {
             String query = "SELECT * FROM carro WHERE cod = " + cod;
             
             PreparedStatement prep = conn.prepareStatement(query);
             
             ResultSet result = prep.executeQuery();
             
             Carro mapa = new Carro();
             
             if(result.next()){
                mapa = new Carro(
                        result.getInt("cod"),
                        result.getString("modelo"),
                        result.getString("cor"),
                        result.getString("placa")
                );
             }             
             return mapa;
        }
        
        
        //UPDATE
        public void updateCarro(Carro mapa) throws SQLException {
            //Query genérica
            String query = "UPDATE carro SET modelo = ?, "
                    + "cor = ?, placa = ? "
                    + "WHERE cod = ?";
            
            //Preparando a query para executar no BD
            PreparedStatement prep = conn.prepareStatement(query);
            
            //Trocar as interrogações por valores do objeto enviado
            prep.setString(1, mapa.getModelo());
            prep.setString(2, mapa.getCor());
            prep.setString(3, mapa.getPlaca());
            prep.setInt(4, mapa.getIdCarro());
            
            //Executar query pronta
            prep.execute();
            prep.close();
        }
        
}//Fim da classe
