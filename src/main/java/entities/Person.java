
package entities;

public class Person extends Entity {

	private String position;

	public Person() {

	}

	public Person(String id, String lable, String description, CitationOrigin co, String position) {
		super(id, lable, description, co);
		this.position = position;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
}
