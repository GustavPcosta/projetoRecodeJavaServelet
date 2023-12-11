

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



//import lorem.principal.Conexao;
//import lorem.principal.model.Usuario;
public class UsuarioDao {
	private static final Logger LOGGER = Logger.getLogger(UsuarioDao.class.getName());

	public void addUsuario(Usuario usuario) {
        try (Connection connection = Conexao.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO usuario (email, senha, dataCadastro, nome) VALUES (?, ?, ?, ?)")) {

            preparedStatement.setString(1, usuario.getEmail());
            preparedStatement.setString(2, usuario.getSenha());
            preparedStatement.setString(4, usuario.getNome());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }

    public List<Usuario> getAllUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();

        try (Connection connection = Conexao.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM usuario")) {

            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultSet.getInt("id"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setDataCadastro(resultSet.getDate("dataCadastro"));
                usuario.setNome(resultSet.getString("nome"));
                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            
        }

        return usuarios;
    }

    public Usuario getUsuarioById(int id) {
        Usuario usuario = null;

        try (Connection connection = Conexao.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM usuario WHERE id=?")) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    usuario = new Usuario();
                    usuario.setId(resultSet.getInt("id"));
                    usuario.setEmail(resultSet.getString("email"));
                    usuario.setSenha(resultSet.getString("senha"));
                    usuario.setDataCadastro(resultSet.getDate("dataCadastro"));
                    usuario.setNome(resultSet.getString("nome"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }


    
    	public void editarUsuario(Usuario usuario) {
            try (Connection connection = Conexao.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement("UPDATE usuario SET email=?, senha=?, nome=? WHERE id=?")) {

                preparedStatement.setString(1, usuario.getEmail());
                preparedStatement.setString(2, usuario.getSenha());
                preparedStatement.setString(3, usuario.getNome());
                preparedStatement.setInt(4, usuario.getId());

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    LOGGER.log(Level.INFO, "Usuário editado no banco de dados. ID: {0}", usuario.getId());
                } else {
                    LOGGER.log(Level.WARNING, "Nenhum usuário foi editado. ID: {0}", usuario.getId());
                }

            } catch (SQLException e) {
                LOGGER.log(Level.SEVERE, "Erro ao editar usuário no banco de dados.", e);
            }
        }


    	
    	 
    	
    public void deleteUsuario(int id) {
        try (Connection connection = Conexao.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM usuario WHERE id=?")) {

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
           
        }
    }
}
