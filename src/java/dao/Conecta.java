package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conecta {
    public static Connection getConexao() throws Exception {
        Connection con = null;
        
        // Configurar servidor de banco de dados e nome do banco
        String serverName = "localhost";
        String myDataBase = "alunos";
        
        //login e senha do banco
        String userName = "root";
        String password = "24017878";
        
        //carregar o JDBC Drive
        String driverName = "com.mysql.jdbc.Driver";
        Class.forName(driverName);
        
        //criar a conexão com o Banco de Dados
        String url = "jdbc:mysql//" + serverName + "/" + myDataBase; // url jdbc
        con = DriverManager.getConnection(url, userName, password);
        
        return con;
    }
}
