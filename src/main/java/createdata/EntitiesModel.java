package createdata;

import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.model.impl.TreeModel;

import entities.Country;
import entities.Entity;
import entities.Event;
import entities.Location;
import entities.Organization;
import entities.Person;

import org.eclipse.rdf4j.model.BNode;
import org.eclipse.rdf4j.model.IRI;

import relation.NameRelation;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class EntitiesModel {
	public static ArrayList<IRI> listIRIP = new ArrayList<IRI>();
	public static ArrayList<IRI> listIRIE = new ArrayList<IRI>();
	public static ArrayList<IRI> listIRIC = new ArrayList<IRI>();
	public static ArrayList<IRI> listIRIL = new ArrayList<IRI>();
	public static ArrayList<IRI> listIRIO = new ArrayList<IRI>();
	public static ArrayList<ArrayList<IRI>> listE = new ArrayList<>(
			Arrays.asList(listIRIP, listIRIE, listIRIC, listIRIO, listIRIL));

	public Model entites(Entity e) {
		Model m = new TreeModel();
		ValueFactory vf = SimpleValueFactory.getInstance();
		BNode CitationOrigin = vf.createBNode();
		if (e instanceof Person) {
			IRI idP = vf.createIRI("http://Person/", e.getId());
			m.add(idP, NameRelation.NAME, vf.createLiteral(e.getLable()));
			m.add(idP, NameRelation.DESCRIPTION, vf.createLiteral(e.getDescription()));
			m.add(idP, NameRelation.POSITION, vf.createLiteral(((Person) e).getPosition()));
			m.add(idP, NameRelation.SOURCE, CitationOrigin);
			m.add(CitationOrigin, NameRelation.LINK_SOURCE, vf.createLiteral(e.getCo().getLink()));
			m.add(CitationOrigin, NameRelation.TIME_SOURCE, vf.createLiteral(e.getCo().getDate()));
			listIRIP.add(idP);
		}
		if (e instanceof Event) {
			IRI idE = vf.createIRI("http://Event/", e.getId());
			m.add(idE, NameRelation.NAME, vf.createLiteral(e.getLable()));
			m.add(idE, NameRelation.DESCRIPTION, vf.createLiteral(e.getDescription()));
			m.add(idE, NameRelation.TIME, vf.createLiteral(((Event) e).getTimDate()));
			m.add(idE, NameRelation.SOURCE, CitationOrigin);
			m.add(CitationOrigin, NameRelation.LINK_SOURCE, vf.createLiteral(e.getCo().getLink()));
			m.add(CitationOrigin, NameRelation.TIME_SOURCE, vf.createLiteral(e.getCo().getDate()));
			listIRIE.add(idE);
		}
		if (e instanceof Country) {
			IRI idC = vf.createIRI("http://Country/", e.getId());
			m.add(idC, NameRelation.NAME, vf.createLiteral(e.getLable()));
			m.add(idC, NameRelation.DESCRIPTION, vf.createLiteral(e.getDescription()));
			m.add(idC, NameRelation.SOURCE, CitationOrigin);
			m.add(CitationOrigin, NameRelation.LINK_SOURCE, vf.createLiteral(e.getCo().getLink()));
			m.add(CitationOrigin, NameRelation.TIME_SOURCE, vf.createLiteral(e.getCo().getDate()));
			listIRIC.add(idC);
		}
		if (e instanceof Location) {
			IRI idL = vf.createIRI("http://Localtion/", e.getId());
			m.add(idL, NameRelation.NAME, vf.createLiteral(e.getLable()));
			m.add(idL, NameRelation.DESCRIPTION, vf.createLiteral(e.getDescription()));
			m.add(idL, NameRelation.IN_COUNTRY, vf.createLiteral(((Location) e).getCountry()));
			m.add(idL, NameRelation.SOURCE, CitationOrigin);
			m.add(CitationOrigin, NameRelation.LINK_SOURCE, vf.createLiteral(e.getCo().getLink()));
			m.add(CitationOrigin, NameRelation.TIME_SOURCE, vf.createLiteral(e.getCo().getDate()));
			listIRIL.add(idL);
		}
		if (e instanceof Organization) {
			IRI idO = vf.createIRI("http://Organization/", e.getId());
			m.add(idO, NameRelation.NAME, vf.createLiteral(e.getLable()));
			m.add(idO, NameRelation.DESCRIPTION, vf.createLiteral(e.getDescription()));
			m.add(idO, NameRelation.HEADQ, vf.createLiteral(((Organization) e).getHeadQuarters()));
			m.add(idO, NameRelation.SOURCE, CitationOrigin);
			m.add(CitationOrigin, NameRelation.LINK_SOURCE, vf.createLiteral(e.getCo().getLink()));
			m.add(CitationOrigin, NameRelation.TIME_SOURCE, vf.createLiteral(e.getCo().getDate()));
			listIRIO.add(idO);
		}
		return m;
	}

}
