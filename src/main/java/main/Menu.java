package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.impl.TreeModel;

import connect.ControllerDAO;
import createdata.EntitiesModel;
import entities.Country;
import entities.Event;
import entities.Location;
import entities.Organization;
import entities.Person;
import createdata.CreateCountry;
import createdata.CreateEvent;
import createdata.CreateLocaltion;
import createdata.CreateOrganization;
import createdata.CreatePerson;
import createdata.CreateRelation;

public class Menu {
	private ControllerDAO ct = new ControllerDAO();
	private EntitiesModel am = new EntitiesModel();
	private CreateRelation cr = new CreateRelation();
	private CreateEvent ce = new CreateEvent();
	private CreatePerson cp = new CreatePerson();
	private CreateCountry cc = new CreateCountry();
	private CreateLocaltion cl = new CreateLocaltion();
	private CreateOrganization co = new CreateOrganization();
	private Scanner sc = new Scanner(System.in);
	Random rd = new Random();

	public void menu() {
		System.out.println("--------------Lựa Chọn---------------");
		System.out.println("	1:Thêm dữ liệu				");
		System.out.println("	2:Truy vấn dữ liệu			");
		System.out.println("	3:Kết thúc! 				");
		System.out.println("------------------------------------");
		System.out.print("Lựa chọn là :");
		int choose = sc.nextInt();
		switch (choose) {
		case 1:
			menuAdd();
			menu();
			break;
		case 2:
			menuQuery();
			menu();
			break;
		case 3:
			System.out.println("Good bye!");
			ct.closeConnect();
			break;
		default:
			System.out.println("Lựa chọn k đúng!");
			menu();
			break;
		}

	}

	public void menuAdd() {
		System.out.print("Số thực thể cần thêm:");
		int numEntities = sc.nextInt();
		if (numEntities < 1) {
			System.err.println("Số không thỏa mãn.");
			return;
		}
		System.out.print("Số quan hệ cần thêm:");
		int numRela = sc.nextInt();
		if (numRela < 1) {
			System.err.println("Số không thỏa mãn.");
			return;
		}
		menuAddEntities(numEntities);
		menuRelation(numRela);

	}

	public void menuRelation(int numberRela) {
		int n = 0;
		do {
			Model m = new TreeModel();
			ArrayList<IRI> e1 = EntitiesModel.listE.get(rd.nextInt(4));
			ArrayList<IRI> e2 = EntitiesModel.listE.get(rd.nextInt(4));
			m = cr.rela(cr.getIRI(e1, e1.size()), cr.getIRI(e2, e2.size()));
			if (m.size() != 0) {
				ct.add(m);
				n++;
			}
		} while (n < numberRela);
	}

	public void menuQuery() {
		System.out.println("Input Query:");
		String query = "PREFIX p: <http://Person/>\r\n" + "PREFIX e: <http://Event/>\r\n"
				+ "PREFIX c: <http://Country/>\r\n" + "PREFIX l: <http://Localtion/>\r\n"
				+ "PREFIX o: <http://Organization/>\r\n" + "PREFIX rela: <http://relation.com/>\n";
		System.out.print(query + "=> ");
		sc.nextLine();
		String queryString = sc.nextLine();
		query += queryString;
		try {
			ct.query(query);
		} catch (Exception e) {
			System.err.println("Truy vấn không đúng!");
		}
	}

	public void menuAddEntities(int numberEntities) {
		int nP = rd.nextInt(numberEntities);
		int nE = rd.nextInt(numberEntities - nP);
		int nL = rd.nextInt(numberEntities - nP - nE);
		int nO = rd.nextInt(numberEntities - nP - nE - nL);
		int nC = numberEntities - nP - nE - nL - nO;
		for (int i = 0; i < nP; i++) {
			Person p = (Person) cp.get();
			ct.add(am.entites(p));
			System.out.println(i);
		}
		for (int i = 0; i < nE; i++) {
			Event e = (Event) ce.get();
			ct.add(am.entites(e));
			System.out.println(nP + i);
		}
		for (int i = 0; i < nL; i++) {
			Location l = (Location) cl.get();
			ct.add(am.entites(l));
			System.out.println(nP + nE + i);
		}
		for (int i = 0; i < nO; i++) {
			Organization o = (Organization) co.get();
			ct.add(am.entites(o));
			System.out.println(nP + nE + nO + i);
		}
		for (int i = 0; i < nC; i++) {
			Country c = (Country) cc.get();
			ct.add(am.entites(c));
			System.out.println(numberEntities - nC + i);
		}
		System.out.println("Sô thực thể đã thêm :" + numberEntities);
		System.out.println("Trong đó có:");
		System.out.println("Người:" + nP);
		System.out.println("Event:" + nE);
		System.out.println("Localtion:" + nL);
		System.out.println("Country:" + nC);
		System.out.println("Organzation:" + nO);
	}

}
