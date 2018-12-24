package entities;

public class Event extends Entity {
	private String timDate;

	public Event() {
	}

	public Event(String id, String lable, String description, CitationOrigin co, String timDate) {
		super(id,lable, description, co);
		this.timDate = timDate;
	}

	public String getTimDate() {
		return timDate;
	}

	public void setTimDate(String timDate) {
		this.timDate = timDate;
	}

}
