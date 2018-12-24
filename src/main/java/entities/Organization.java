
package entities;

public class Organization extends Entity {
	private String headQuarters;

	public Organization() {
	}

	public Organization(String id, String lable, String description, CitationOrigin co, String headQuarters) {
		super(id, lable, description, co);
		this.headQuarters = headQuarters;
	}

	public String getHeadQuarters() {
		return headQuarters;
	}

	public void setHeadQuarters(String headQuarters) {
		this.headQuarters = headQuarters;
	}

}
