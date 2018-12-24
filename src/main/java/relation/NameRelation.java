package relation;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;

public class NameRelation {

	public static final String NAMESPACE = "http://relation.com/";

	public static final int SIZE = 4;

	public static final IRI SOURCE = getIRI("source");
	public static final IRI TIME_SOURCE = getIRI("time_source");
	public static final IRI LINK_SOURCE = getIRI("link_source");
	// --------------------------------------------------//
	public static final IRI NAME = getIRI("name");
	public static final IRI DESCRIPTION = getIRI("description");
	public static final IRI TIME = getIRI("time");
	public static final IRI POSITION = getIRI("position");
	public static final IRI IN_COUNTRY = getIRI("in_country");
	public static final IRI HEADQ = getIRI("headQ");
	// --------------------------------------------------//
	public static final IRI HAS_CHILD = getIRI("has_child");
	public static final IRI FRENDLY = getIRI("frendly");
	public static final IRI BOSS = getIRI("boss");
	public static final IRI MEET = getIRI("meet");
	public static final IRI LOVE = getIRI("love");
	// ------------------------------------------------//
	public static final IRI LIVE_IN = getIRI("live_in");
	public static final IRI FROM = getIRI("from");
	public static final IRI WORK_AT = getIRI("work_at");
	public static final IRI VISIT = getIRI("vist");
	// public static final IRI =getIRI("");
	// -----------------------------------------------//
	public static final IRI ORGANIZE = getIRI("organize");
	public static final IRI STATED = getIRI("stated");
	public static final IRI PROTECT = getIRI("protect");
	// -----------------------------------------------//
	public static final IRI ESTABLISH = getIRI("establish");
	public static final IRI LITIGATION = getIRI("litigation");
	// ------------------------------------------------//
	public static final IRI PLACE = getIRI("place");
	public static final IRI PROHIBITED = getIRI("prohibited");
	// -----------------------------------------------//
	public static final IRI CO_OPERATE = getIRI("co_operate");
	// ----------------------------------------------//
	public static final IRI AFTER = getIRI("after");
	public static final IRI NEXT_TO = getIRI("next_to");

	public static final IRI[] p2P = { HAS_CHILD, FRENDLY, BOSS, MEET, LOVE };
	public static final IRI[] p2CorL = { LIVE_IN, FROM, WORK_AT, VISIT };
	public static final IRI[] p2E = { ORGANIZE, STATED, PROTECT };
	public static final IRI[] p2O = { ESTABLISH, WORK_AT, LITIGATION };
	public static final IRI[] e2CorL = { PLACE, PROHIBITED };
	public static final IRI[] o2o = { CO_OPERATE, LITIGATION };

	private static IRI getIRI(String localName) {
		return SimpleValueFactory.getInstance().createIRI(NAMESPACE, localName);
	}

}
