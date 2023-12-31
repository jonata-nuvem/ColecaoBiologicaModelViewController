package cb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cb.basica.Especie;
import cb.model.RNEspecieSalvar;

/**
 * Funciona como MAIN - Servlet implementation class EspecieController
 */
@WebServlet("/EspecieController")
public class EspecieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at GET: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Salvar os dados no BD
		if(request.getParameter("action").equals("salvar")){
			Especie nomeespecie = new Especie();
			nomeespecie.setNomeespecie(request.getParameter("nomeespecie"));
			nomeespecie.setLote(request.getParameter("lote"));
			nomeespecie.setEspecimes(request.getParameter("especimes"));
			
			
			RNEspecieSalvar rn = new RNEspecieSalvar();
			try {
				rn.salvar(nomeespecie);
			} catch (Exception e) {
				response.getWriter().append("ERR: " + e.getMessage()).append(request.getContextPath());			}
		}
	}

}
