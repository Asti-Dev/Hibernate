package isil.trabajo.hibernate.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import isil.trabajo.hibernate.dao.EdificioDao;
import isil.trabajo.hibernate.model.Edificio;

@WebServlet("/")
public class EdificioServlet extends HttpServlet {
	 
	
	 private static final long serialVersionUID = 1L;
	    private EdificioDao edificioDao;

	    public void init() {
	        edificioDao = new EdificioDao();
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	        doGet(request, response);
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	        String action = request.getServletPath();

	        try {
	            switch (action) {
	                case "/new":
	                    showNewForm(request, response);
	                    break;
	                case "/insert":
	                    insertEdificio(request, response);
	                    break;
	                case "/delete":
	                    deleteEdificio(request, response);
	                    break;
	                case "/edit":
	                    showEditForm(request, response);
	                    break;
	                case "/update":
	                    updateEdificio(request, response);
	                    break;
	                default:
	                    listEdificio(request, response);
	                    break;
	            }
	        } catch (SQLException e) {
	            throw new ServletException(e);
	        }
	    }

	    private void listEdificio(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, IOException, ServletException {
	        List < Edificio > listEdificio = edificioDao.getAllEdificio();
	        request.setAttribute("listEdificio", listEdificio);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("edificio-list.jsp");
	        dispatcher.forward(request, response);
	    }

	    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	        RequestDispatcher dispatcher = request.getRequestDispatcher("edificio-form.jsp");
	        dispatcher.forward(request, response);
	    }

	    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, ServletException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        Edificio existingEdificio = edificioDao.getEdificio(id);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("edificio-form.jsp");
	        request.setAttribute("edificio", existingEdificio);
	        dispatcher.forward(request, response);

	    }

	    private void insertEdificio(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, IOException {
	        String nombre = request.getParameter("nombre");
	        int cantidadPisos = Integer.parseInt(request.getParameter("cantidadPisos"));
	        double altura = Double.parseDouble(request.getParameter("altura"));
	        String direccion = request.getParameter("direccion");
	        Edificio newEdificio = new Edificio(nombre, cantidadPisos, altura, direccion);
	        edificioDao.saveEdificio(newEdificio);
	        response.sendRedirect("list");
	    }

	    private void updateEdificio(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        String nombre = request.getParameter("nombre");
	        int cantidadPisos = Integer.parseInt(request.getParameter("cantidadPisos"));
	        double altura = Double.parseDouble(request.getParameter("altura"));
	        String direccion = request.getParameter("direccion");
	        Edificio edificio = new Edificio(id, nombre, cantidadPisos, altura, direccion);

	        edificioDao.updateEdificio(edificio);
	        response.sendRedirect("list");
	    }

	    private void deleteEdificio(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        edificioDao.deleteEdificio(id);
	        response.sendRedirect("list");
	    }

}
