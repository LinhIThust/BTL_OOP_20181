package createdata;

import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.impl.TreeModel;

import java.util.ArrayList;
import java.util.Random;

import org.eclipse.rdf4j.model.IRI;
import relation.NameRelation;

public class CreateRelation {
	private final Random rd = new Random();
	private static int n = 1;
	Model flag = new TreeModel();

	public IRI getIRI(ArrayList<IRI> E, int n) {
		if (n > 1)
			return E.get(rd.nextInt(n - 1));
		if (n == 1)
			return E.get(0);
		return null;
	}

	public Model rela(IRI e1, IRI e2) {
		Model m = new TreeModel();
		if (e1 == null || e2 == null) {
			return flag;
		} else {
			if (e1.toString().equals(e2.toString())) {
				return flag;
			}
		}

		if (e1.toString().contains("Person")) {
			if (e2.toString().contains("Person")) {
				m.add(e1, NameRelation.p2P[rd.nextInt(4)], e2);
				System.out.println("Quan hệ Thành công " + n);
				n++;
				return m;
			}
			if (e2.toString().contains("Event")) {
				m.add(e1, NameRelation.p2E[rd.nextInt(2)], e2);
				System.out.println("Quan hệ Thành công " + n);
				n++;
				return m;
			}
			if (e2.toString().contains("Country") || e2.toString().contains("Localtion")) {
				m.add(e1, NameRelation.p2CorL[rd.nextInt(3)], e2);
				System.out.println("Quan hệ Thành công " + n);
				n++;
				return m;
			}
			if (e2.toString().contains("Organization")) {
				m.add(e1, NameRelation.p2O[rd.nextInt(1)], e2);
				System.out.println("Quan hệ Thành công " + n);
				n++;
				return m;
			}
		}

		if (e1.toString().contains("Event")) {

			if (e2.toString().contains("Event")) {
				m.add(e1, NameRelation.AFTER, e2);
				System.out.println("Quan hệ Thành công " + n);
				n++;
				return m;
			}
			if (e2.toString().contains("Country") || e2.toString().contains("Localtion")) {
				m.add(e1, NameRelation.e2CorL[rd.nextInt(1)], e2);
				System.out.println("Quan hệ Thành công " + n);
				n++;
				return m;
			}

		}

		if (e1.toString().contains("Organization")) {
			if (e2.toString().contains("Event")) {
				m.add(e1, NameRelation.ORGANIZE, e2);
				System.out.println("Quan hệ Thành công " + n);
				n++;
				return m;
			}
			if (e2.toString().contains("Organization")) {
				m.add(e1, NameRelation.CO_OPERATE, e2);
				System.out.println("Quan hệ Thành công " + n);
				n++;
				return m;
			}
			if (e2.toString().contains("Country") || e2.toString().contains("Localtion")) {
				m.add(e1, NameRelation.FROM, e2);
				System.out.println("Quan hệ Thành công " + n);
				n++;
				return m;
			}

		}

		if (e1.toString().contains("Country") && e2.toString().contains("Country")) {
			m.add(e1, NameRelation.NEXT_TO, e2);
			System.out.println("Quan hệ Thành công " + n);
			n++;
			return m;
		}
		if (e1.toString().contains("Localtion")) {
			if (e2.toString().contains("Location")) {
				m.add(e1, NameRelation.NEXT_TO, e2);
				System.out.println("Quan hệ Thành công " + n);
				n++;
				return m;
			}
			if (e2.toString().contains("Country")) {
				m.add(e1, NameRelation.PLACE, e2);
				System.out.println("Quan hệ Thành công " + n);
				n++;
				return m;
			}
		}

		return flag;
	}
}
