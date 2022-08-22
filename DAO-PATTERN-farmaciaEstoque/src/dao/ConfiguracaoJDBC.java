package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfiguracaoJDBC {
    private String jdbcDriver;
    private String dbUrl;
    private String usuario;
    private String senha;


    public ConfiguracaoJDBC(String jdbcDriver, String dbUrl, String usuario, String senha) {
        this.jdbcDriver = jdbcDriver;
        this.dbUrl = dbUrl;
        this.usuario = usuario;
        this.senha = senha;
    }

    public ConfiguracaoJDBC() {
        this.jdbcDriver = "org.h2.Driver";
        this.dbUrl = "jdbc:h2:mem:farmacia;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'create.sql'";
        this.usuario = "sa";
        this.senha = "";
    }

    public Connection conectarComBancoDeDados() {

        Connection conexao = null;

        try {

            conexao = DriverManager.getConnection(dbUrl, usuario, senha);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conexao;
    }
}