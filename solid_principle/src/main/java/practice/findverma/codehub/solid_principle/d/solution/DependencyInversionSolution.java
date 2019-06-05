package practice.findverma.codehub.solid_principle.d.solution;

interface Database{
	public void connect();
	public void disconnect();
}
class MySqlDatabse implements Database{
	public void connect(){System.out.println("Connecting with MySql Server ...");}
	public void disconnect(){System.out.println("Disconnecting from MySql Server ...");}
}

class OracleDatabse implements Database{
	public void connect(){System.out.println("Connecting with Oracle Server ...");}
	public void disconnect(){System.out.println("Disconnecting from Oracle Server ...");}
}

class DatabseHandler{
	private Database mySqlDatabse;
	public DatabseHandler(Database database) {
		this.mySqlDatabse =database;  
	}
	public void getConnection(){mySqlDatabse.connect();}
	public void releaseConnect(){mySqlDatabse.disconnect();}
}
public class DependencyInversionSolution {

	public static void main(String[] args) {
		DatabseHandler handler  = new DatabseHandler(new MySqlDatabse());  // new OracleDatabse() if you want to change database 
		handler.getConnection();
		handler.releaseConnect();
	}

}
