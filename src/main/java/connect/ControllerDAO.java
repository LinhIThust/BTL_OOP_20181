package connect;

import java.util.List;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.model.Model;

public class ControllerDAO {
	private final RepositoryConnection conn = new CreateConnection().connect();

	public void add(Model model) {
		try {
			conn.add(model);
		} catch (Exception e) {
			System.err.println("Lỗi đẩy lên server!");
		}
	}

	public void query(String query) {
		//long lStartTime = System.currentTimeMillis();
		TupleQuery tupleQuery = conn.prepareTupleQuery(query);
		long lStartTime = System.currentTimeMillis();
		try (TupleQueryResult result = tupleQuery.evaluate()) {
			long lEndTime = System.currentTimeMillis();
			printResult(result, lEndTime - lStartTime);
			result.close();
		}
	}

	public void closeConnect() {
		conn.close();
	}

	public void printResult(TupleQueryResult result, long timeQuery) {
		System.out.println("result...");
		List<String> bindingNames = result.getBindingNames();
		int size = bindingNames.size();
		int count = 0;
		while (result.hasNext()) {
			count++;
			BindingSet solution = result.next();
			System.out.print("KQ " + count + ": ");
			for (int i = 0; i < size; i++) {
				String kq = solution.getValue(bindingNames.get(i)).toString();
				int check = kq.indexOf("^");
				if (check > 0)
					System.out.print(kq.substring(0, check) + "\t");
				else {
					System.out.print(kq + "\t");
				}
			}
			System.out.println();
		}
		System.out.println("=================================");
		System.out.println("SỐ KẾT QUẢ:		" + count);
		System.out.println("THỜI GIAN TRUY VẤN:	" + timeQuery + "(ms)");
		System.out.println("=================================");
	}
}
