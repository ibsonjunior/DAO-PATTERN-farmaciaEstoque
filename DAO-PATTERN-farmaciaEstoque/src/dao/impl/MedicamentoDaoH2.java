package dao.impl;

import dao.ConfiguracaoJDBC;
import dao.IDao;
import entities.Medicamento;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MedicamentoDaoH2 implements IDao<Medicamento> {

    private ConfiguracaoJDBC configuracaoJDBC;
    final static Logger LOGGER = Logger.getLogger(MedicamentoDaoH2.class);

    public MedicamentoDaoH2(ConfiguracaoJDBC configuracaoJDBC){
        this.configuracaoJDBC = configuracaoJDBC;
    }

    @Override
    public Medicamento salvar(Medicamento medicamento) {

        Connection conecxao = configuracaoJDBC.conectarComBancoDeDados();
        Statement statement = null;

        String queryInsert = String.format("INSERT INTO medicamentos (nome, laboratorio, quantidade, preco) VALUES ('%s','%s','%s','%s')", medicamento.getNome(), medicamento.getLaboratorio(), medicamento.getQuantidade(), medicamento.getPreco());

        try{
            statement = conecxao.createStatement();
            statement.executeUpdate(queryInsert, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()){
                medicamento.setId(rs.getInt(1));
            }

            statement.close();
            conecxao.close();


        }catch (SQLException e){

        }


        return null;
    }
}
