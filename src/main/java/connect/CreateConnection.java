package connect;

import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import virtuoso.rdf4j.driver.VirtuosoRepository;

public class CreateConnection {
	private final String url = "jdbc:virtuoso://localhost:1111";
	private final String user = "dba";
	private final String passW = "dba";
	private final Repository myR = new VirtuosoRepository(url, user, passW);

	public RepositoryConnection connect() {
		myR.initialize();
		RepositoryConnection conn = myR.getConnection();
		if(conn.equals(null)) {
			System.out.println("Connect error!");
		}
		else {
			System.out.println("connection are ready!");
		}
		return conn;
	}

}
