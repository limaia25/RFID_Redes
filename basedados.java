import java.rmi.RemoteException;
import java.sql.*;
import java.sql.Date;

import java.util.Calendar;
import java.util.List;
import java.util.Vector;
//import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import com.mysql.*;


public class basedados {
	Connection conn;
	public basedados ()
	{
//Neste construtor é efectuada a ligação à base de dados.
		
	   	String driver = "com.mysql.jdbc.Driver"; //Classe do driver JDBC
	   	String banco = "Tredes"; //Nome do BD criado
	   	String host = "127.0.0.1"; //Maquina onde está a bd
	   	String str_conn = "jdbc:mysql://" + host + ":3306/" + banco; //URL de conexão
	  	String user = "root"; //Usuário da bd
	   	String senha = "paulo";
	         
	   	try {
	   		String className = "com.mysql.jdbc.Driver";
			Class driverObject = Class.forName(className);
			System.out.println("Driver Installation Successful");

	             //Obtém a conexão com a bd
		 conn = DriverManager.getConnection(str_conn, user, senha);
	      } 
	      catch (ClassNotFoundException ex) {
	           System.out.println("Não foi possível ligar ao driver.");
	           ex.printStackTrace();
	      }
	      catch (SQLException ex) {
	           System.out.println("Problema com o SQL");
	           ex.printStackTrace();
	      }
		  catch (Exception e) {
		    	System.out.println("Driver Installation FAILED\n");
		    	System.out.println("Failed: Driver Error: " + e.getMessage());
		  }
	}	
	
		public Vector<String> consultamedicamentos()
		{
			Vector<String> med = new Vector<String> ();
			int i=0;
			String sql="select * from Tredes.Medicamentos";
			try {
				Statement stmt =(Statement) conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql);
				while(rs.next())
				{	
					med.add(rs.getString(2));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return med;
		}
		
		public String nomeMedicamento(int epcm){
			String nome=null;
			String sql="Select m.Medicamento from Tredes.Medicamentos m where m.EPCm="+epcm;
			try {
				Statement stmt =(Statement) conn.createStatement();
				
	            ResultSet rs=stmt.executeQuery(sql);
	            
	            while(rs.next()){
	            	nome=rs.getString(1);
	            }
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return nome;
		}
		
		public int EPCm(String medi){
			int medicamento=0;
			String sql="Select m.EPCm from Tredes.Medicamentos m where m.Medicamento='"+medi+"'";
			try {
				Statement stmt =(Statement) conn.createStatement();
				
	            ResultSet rs=stmt.executeQuery(sql);
	            
	            while(rs.next()){
	            	medicamento=rs.getInt(1);
	            }
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return medicamento;
		
		}
		
		public String nomeP(int iDp){
			String paciente=null;
			String sql="Select p.Nome from Tredes.Pacientes p where p.idPaciente="+iDp;
			try {
				Statement stmt =(Statement) conn.createStatement();
				
	            ResultSet rs=stmt.executeQuery(sql);
	            
	            while(rs.next()){
	            	paciente=rs.getString(1);
	            }
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return paciente;
		}
		
		public int idPaciente(String nome){
			int idP=0;
			String sql="Select p.idPaciente from Tredes.Pacientes p where p.Nome='"+nome+"'";
			try {
				Statement stmt =(Statement) conn.createStatement();
				
	            ResultSet rs=stmt.executeQuery(sql);
	            
	            while(rs.next()){
	            	idP=rs.getInt(1);
	            }
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return idP;
		}
		
		public String email(int idP){
			String mail=null;
			String sql="Select p.Email from Tredes.Pacientes p where p.idPaciente="+idP;
			try {
				Statement stmt =(Statement) conn.createStatement();
				
	            ResultSet rs=stmt.executeQuery(sql);
	            
	            while(rs.next()){
	            	mail=rs.getString(1);
	            }
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return mail;
		}
	
		public String nomeM(int iDm){
			String medico=null;
			String sql="Select me.Nome from Tredes.Medicos me where me.idMedico="+iDm;
			try {
				Statement stmt =(Statement) conn.createStatement();
				
	            ResultSet rs=stmt.executeQuery(sql);
	            
	            while(rs.next()){
	            	medico=rs.getString(1);
	            }
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return medico;
		}
		
		public int idMedico(String nome){
			int idM=0;
			String sql="Select p.idMedico from Tredes.Medicos p where p.Nome='"+nome+"'";
			try {
				Statement stmt =(Statement) conn.createStatement();
				
	            ResultSet rs=stmt.executeQuery(sql);
	            
	            while(rs.next()){
	            	idM=rs.getInt(1);
	            }
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return idM;
		}
		
		public String emailMedico(int idM){
			String maili=null;
			String sql="Select me.Email from Tredes.Medicos me where me.idMedico="+idM;
			try {
				Statement stmt =(Statement) conn.createStatement();
				
	            ResultSet rs=stmt.executeQuery(sql);
	            
	            while(rs.next()){
	            	maili=rs.getString(1);
	            }
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return maili;
		}
		
		public int maxReceita(){
			int maximo=0;
			String sql="select count(m.idReceita) from Tredes.Receita m";
			try {
				Statement stmt =(Statement) conn.createStatement();
				
	            ResultSet rs=stmt.executeQuery(sql);
	            
	            while(rs.next()){
	            	maximo=rs.getInt(1);
	            }
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return maximo;
		}
	
		
		void consultapacientes()
		{

			String sql="select * from Tredes.Pacientes";
			try {
				Statement stmt =(Statement) conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql);
				while(rs.next())
				{
					
					System.out.println(rs.getInt(1) +" "+ rs.getString(2));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		/*public String getDateTime() {	       
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	        Date date = new Date();
	        return dateFormat.format(date);
	    }*/
		public static java.sql.Date getCurrentJavaSqlDate() {
		    java.util.Date today = new java.util.Date();
		    return new java.sql.Date(today.getTime());
		  }



	void prescrever(int idm,int idp, int epcm, int h, int t)
	{   int idr=maxReceita()+1;
		
		Calendar cal = Calendar.getInstance();

		java.sql.Date date = getCurrentJavaSqlDate();
		//String data="DD/MM/YYYY HH:MI"+getDateTime();
	   		String sql = "insert into Tredes.Receita (idReceita,idMedico,idPaciente,EPCm,hora,tempo,data) values (?,?,?,?,?,?,?)";  
	   		try{  
	   			PreparedStatement pstmt = conn.prepareStatement(sql);  
	   			pstmt.setInt(1, idr);
	   			pstmt.setInt(2, idm);
	   			pstmt.setInt(3, idp);
	   			
	            pstmt.setInt(4, epcm);  
	            pstmt.setInt(5, h); 
	            pstmt.setInt(6, t);
	            pstmt.setDate(7, date);
	            pstmt.execute();  
	            pstmt.close();        
	        }  
	          catch (SQLException e){
	        	  System.out.println("Erro SQL");
	        }  
	      
	
	}
	
	void adiciona_medicamento(int epcm, String med ){        
   		String sql = "insert into Tredes.Medicamentos (EPCm,Medicamento) values (?,?)";  
   		try{  
   			PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setInt(1, epcm);  
            pstmt.setString(2, med);  
            pstmt.execute();  
            pstmt.close();        
        }  
          catch (SQLException e){
        	  System.out.println("Erro SQL");
        }  
      }  
void ver_med(int idPaciente)
{
		String sql = "select Tredes.Receitas.EPCm from Tredes.Receitas where idPacientes=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idPaciente); 	
		     pstmt.execute();  
	         pstmt.close(); 
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
		 

}

