
package br.com.sislivros.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Zilderlan
 */
public class Conexao {
    
    private static Connection conn = null;
    
    private static PreparedStatement stm = null;
    
    public static Connection conexao() throws ClassNotFoundException, SQLException{
        return (abrirConexao("localhost", "bancoPsd", "postgres", "12345"));
    }
    
    public static Connection abrirConexao(String server, String dataBase, String user, String password) throws ClassNotFoundException, SQLException{
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection("jdbc:postgresql://" + server + ":5432/" + dataBase, user, password);
        return conn;
    }
    
    public static void closeConnection(Connection conn){
        if (conn != null)
        try{
            conn.close();
        }catch(SQLException e){
              
        }    
    }
    
    	public static void closeConnection1(Connection conn){
		if (conn!= null)
			try{
			conn.close();
			} catch(SQLException e){
				
			}
	}
    
    public static PreparedStatement openStatement(String sql){
        try{
            stm = conn.prepareStatement(sql);
        }catch(SQLException e){
            System.out.println("Erro!" + e.getMessage());
            e.printStackTrace();
        }
        return stm;
    }
    
    public static boolean closeStatement(PreparedStatement stm){
        if (stm != null)
            try{
                stm.close();
                return true;
            }catch(SQLException e){
                System.out.println("Erro! "+e.getMessage());
                e.printStackTrace();
            }
        return false;
    }
    
}
