package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Carro;
import model.CarroDAO;

@WebServlet(name = "CarroController", urlPatterns = {"/CarroController"})
public class CarroController extends HttpServlet {
    private int cod;
    private String modelo;
    private String cor;
    private String placa;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //Verificando se há o recebimento do campo "cod"
        if(request.getParameter("cod") != null) {
            this.cod = Integer.parseInt(request.getParameter("cod"));
        }
        
        //Recebendo os valores enviados pelo formulário de cadastro
        this.modelo = request.getParameter("modelo");
        this.cor = request.getParameter("cor");
        this.placa = request.getParameter("placa");
        
        try {
        
            if(request.getParameter("cod") == null) {
                //Criando um novo objeto da classe Carro com os valores recebidos
                Carro objCarro = new Carro(
                        this.modelo,
                        this.cor,
                        this.placa
                );

                    CarroDAO dao = new CarroDAO();
                    dao.insertCarro(objCarro);
                    response.sendRedirect("lista.jsp");
            } else {
                Carro objCarro = new Carro(
                        this.cod,
                        this.modelo,
                        this.cor,
                        this.placa
                );
                
                CarroDAO dao = new CarroDAO();
                dao.updateCarro(objCarro);
                response.sendRedirect("lista.jsp");
            }
        } catch(ClassNotFoundException | SQLException erro) {
            
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Carros</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Ocorreu algum erro: " + erro + "</h1>");
                out.println("</body>");
                out.println("</html>");
            }
        }
        
    }//Fim do else

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
