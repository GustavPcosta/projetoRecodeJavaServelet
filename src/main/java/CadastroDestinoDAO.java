


//import lorem.principal.model.Destino;

//import lorem.principal.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CadastroDestinoDAO {

    public void addCadastroDestino(Destino cadastroDestino) {
        try (Connection connection = Conexao.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cadastroDestino (nome, sobrenome, email, pagamento, estado, cep) VALUES (?, ?, ?, ?, ?, ?)")) {

            preparedStatement.setString(1, cadastroDestino.getNome());
            preparedStatement.setString(2, cadastroDestino.getSobrenome());
            preparedStatement.setString(3, cadastroDestino.getEmail());
            preparedStatement.setFloat(4, cadastroDestino.getPagamento());
            preparedStatement.setString(5, cadastroDestino.getEstado());
            preparedStatement.setString(6, cadastroDestino.getCep());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }

    public List<Destino> getAllCadastrosDestino() {
        List<Destino> cadastrosDestino = new ArrayList<>();

        try (Connection connection = Conexao.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM cadastroDestino")) {

            while (resultSet.next()) {
                Destino cadastro = new Destino();
                cadastro.setId(resultSet.getInt("id"));
                cadastro.setNome(resultSet.getString("nome"));
                cadastro.setSobrenome(resultSet.getString("sobrenome"));
                cadastro.setEmail(resultSet.getString("email"));
                cadastro.setPagamento(resultSet.getFloat("pagamento"));
                cadastro.setEstado(resultSet.getString("estado"));
                cadastro.setCep(resultSet.getString("cep"));
                cadastrosDestino.add(cadastro);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            
        }

        return cadastrosDestino;
    }

   
    
    public Destino getCadastroDestinoById(int id) {
        Destino cadastroDestino = null;

        try (Connection connection = Conexao.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM cadastroDestino WHERE id=?")) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    cadastroDestino = new Destino();
                    cadastroDestino.setId(resultSet.getInt("id"));
                    cadastroDestino.setNome(resultSet.getString("nome"));
                    cadastroDestino.setSobrenome(resultSet.getString("sobrenome"));
                    cadastroDestino.setEmail(resultSet.getString("email"));
                    cadastroDestino.setPagamento(resultSet.getFloat("pagamento"));
                    cadastroDestino.setEstado(resultSet.getString("estado"));
                    cadastroDestino.setCep(resultSet.getString("cep"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cadastroDestino;
    }


    public void updateCadastroDestino(Destino cadastroDestino) {
        try (Connection connection = Conexao.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE cadastroDestino SET nome=?, sobrenome=?, email=?, pagamento=?, estado=?, cep=? WHERE id=?")) {

            preparedStatement.setString(1, cadastroDestino.getNome());
            preparedStatement.setString(2, cadastroDestino.getSobrenome());
            preparedStatement.setString(3, cadastroDestino.getEmail());
            preparedStatement.setFloat(4, cadastroDestino.getPagamento());
            preparedStatement.setString(5, cadastroDestino.getEstado());
            preparedStatement.setString(6, cadastroDestino.getCep());
            preparedStatement.setInt(7, cadastroDestino.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
           
        }
    }

    public void deleteCadastroDestino(int id) {
        try (Connection connection = Conexao.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM cadastroDestino WHERE id=?")) {

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }
}
