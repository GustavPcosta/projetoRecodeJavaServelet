

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import lorem.principal.Dao.UsuarioDao;
//import lorem.principal.model.Usuario;

import java.util.logging.Level;
import java.util.logging.Logger;
@WebServlet("/usuario/*")
public class UsuarioController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(UsuarioController.class.getName());
    UsuarioDao usuarioDao;
	
	@Override
    public void init() throws ServletException {
        super.init();
        usuarioDao = new UsuarioDao();
    }
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {
            listUsuarios(request, response);
        } else if (pathInfo.equals("/editar")) {
            showEditarForm(request, response);
        } else if (pathInfo.equals("/remover")) {
            removerUsuario(request, response);
        } else if (pathInfo.equals("/cadastrar")) {
            showCadastrarForm(request, response);
        }
    }
	
	
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();

        if (pathInfo.equals("/editar")) {
            editarUsuario(request, response);
        }
    }
    
    private void listUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Usuario> usuarios = usuarioDao.getAllUsuarios();
        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("/listar.jsp").forward(request, response);
    }

    private void showEditarForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        Usuario usuario = usuarioDao.getUsuarioById(userId);
        request.setAttribute("usuario", usuario);
        request.getRequestDispatcher("/editar.jsp").forward(request, response);
    }

    private void editarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int userId = Integer.parseInt(request.getParameter("id"));
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            String nome = request.getParameter("nome");

            LOGGER.log(Level.INFO, "Editando usuário. ID: {0}, Email: {1}, Senha: {2}, Nome: {3}",
                    new Object[]{userId, email, senha, nome});

            Usuario usuario = new Usuario();
            usuario.setId(userId);
            usuario.setEmail(email);
            usuario.setSenha(senha);
            usuario.setNome(nome);

            usuarioDao.editarUsuario(usuario);

            LOGGER.log(Level.INFO, "Usuário editado com sucesso.");

            response.sendRedirect(request.getContextPath() + "/usuario/");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao editar usuário.", e);
            throw new ServletException("Erro ao editar usuário.", e);
        }
    }

    
    private void cadastrarUsuario(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        try {
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            String nome = request.getParameter("nome");

            LOGGER.log(Level.INFO, "Cadastrando usuário. Email: {0}, Senha: {1}, Nome: {2}",
                    new Object[]{email, senha, nome});

            Usuario usuario = new Usuario();
            usuario.setEmail(email);
            usuario.setSenha(senha);
            usuario.setNome(nome);

            usuarioDao.addUsuario(usuario);

            LOGGER.log(Level.INFO, "Usuário cadastrado com sucesso.");

            response.sendRedirect(request.getContextPath() + "/usuario/");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao cadastrar usuário.", e);
            throw new ServletException("Erro ao cadastrar usuário.", e);
        }
    }

    
    private void showCadastrarForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Usuario usuario = new Usuario();
        request.setAttribute("usuario", usuario);
        request.getRequestDispatcher("/cadastrar.jsp").forward(request, response);
    }
    
    
    private void removerUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        usuarioDao.deleteUsuario(userId);

        response.sendRedirect(request.getContextPath() + "/usuario/");
    }
}
