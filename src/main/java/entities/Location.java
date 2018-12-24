
package entities;

public class Location extends Entity {
	private String country;

	public Location() {
	}

	public Location(String id, String lable, String description, CitationOrigin co, String country) {
		super(id, lable, description, co);
		this.country = country;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
