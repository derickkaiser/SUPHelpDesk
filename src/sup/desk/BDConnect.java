package sup.desk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class BDConnect {

	
	
	Connection connection = null;
	
	public Connection getConexao() throws Exception { 
	 try
       {
           //Class.forName ("com.mysql.jdbc.Driver");
		     Class.forName("oracle.jdbc.driver.OracleDriver");
       }
	 	catch (ClassNotFoundException e)
       {
           throw new Exception ("Driver Not Found");
       }
	 
	 connection = DriverManager.getConnection
			   ("jdbc:oracle:thin:@FS1-CEATEC:1521/ORCL", "bdim26", "ff82");
	 Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY);
	 System.out.println("Conectado com sucesso!");
	 
	 return connection;
	 }
	
	 public void update (String cmdSQL) throws Exception
	    {
	        Statement comando = null;
	        try
	        {
	            comando = connection.createStatement
	                     (ResultSet.TYPE_SCROLL_INSENSITIVE,
	                      ResultSet.CONCUR_READ_ONLY);

	            comando.executeUpdate (cmdSQL);
	        }
	        catch (SQLException e)
	        {
	            throw new Exception ("execucao comando: "+e);
	        }

	    }

	    public ResultSet query (String qrySQL) throws Exception
	    {
	        ResultSet resultado = null;
	        Statement comando = null;

	        try
	        {
	            comando = connection.createStatement
	                     (ResultSet.TYPE_SCROLL_INSENSITIVE,
	                      ResultSet.CONCUR_READ_ONLY);
	            resultado = comando.executeQuery (qrySQL);
	        }
	        catch (SQLException e)
	        {
	            throw new Exception ("execucao consulta: " + e);
	        }

	        return resultado;
	    }

	 
	    public void fecharConexao () throws Exception
	    {
	        try
	        {
	            connection.close ();
	            connection = null;
	            System.out.println("Conecx�o Fechada!");
	        }
	        catch (SQLException nada)
	        {
	        }
	    }
	
	
}
