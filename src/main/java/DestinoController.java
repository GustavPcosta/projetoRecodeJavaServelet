

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import lorem.principal.Dao.CadastroDestinoDAO;
//import lorem.principal.model.Destino;

@WebServlet("/cadastroDestino/*")
public class DestinoController  extends HttpServlet {
	private CadastroDestinoDAO cadastroDestinoDao;
	
	
	 @Override
	    public void init() throws ServletException {
	        super.init();
	        cadastroDestinoDao = new CadastroDestinoDAO();
	    }
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String pathInfo = request.getPathInfo();

	        if (pathInfo == null || pathInfo.equals("/")) {
	            listCadastrosDestino(request, response);
	        } else if (pathInfo.equals("/editar")) {
	            showEditarForm(request, response);
	        } else if (pathInfo.equals("/remover")) {
	            removerCadastroDestino(request, response);
	        }
	    }
	 
	 
	 
	 private void editarCadastroDestino(HttpServletRequest request, HttpServletResponse response) {
		    String idString = request.getParameter("id");
		    String nome = request.getParameter("nome");
		    

		    int id = Integer.parseInt(idString);
		    
		    
		    Destino destinoExistente = cadastroDestinoDao.getCadastroDestinoById(id);

		    if (destinoExistente != null) {
		        
		        destinoExistente.setNome(nome);
		        

		        
		        cadastroDestinoDao.updateCadastroDestino(destinoExistente);
		    }

		   
		    //response.sendRedirect(request.getContextPath() + "/cadastroDestino");
		}

	 private void showEditarForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    String idParam = request.getParameter("id");

		    if (idParam != null && !idParam.isEmpty()) {
		        int id = Integer.parseInt(idParam);
		        Destino destino = cadastroDestinoDao.getCadastroDestinoById(id);

		        if (destino != null) {
		            request.setAttribute("destino", destino);
		            request.getRequestDispatcher("/editarCadastroDestino.jsp").forward(request, response);
		            return;
		        }
		    }

		    
		    response.sendRedirect(request.getContextPath() + "/cadastroDestino");
		}


	 private void removerCadastroDestino(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String pathInfo = request.getPathInfo();

	        if (pathInfo.equals("/editar")) {
	            editarCadastroDestino(request, response);
	        }
	    }
	 
	 
	 
	private void listCadastrosDestino(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        List<Destino> cadastrosDestino = cadastroDestinoDao.getAllCadastrosDestino();
	        request.setAttribute("cadastrosDestino", cadastrosDestino);
	        request.getRequestDispatcher("/listarCadastroDestino.jsp").forward(request, response);
	    }

	 
	 
	
	
}
