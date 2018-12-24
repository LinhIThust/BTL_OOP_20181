
package entities;

public class CitationOrigin {
	private String link;
	private String date;

	public CitationOrigin() {
	}

	public CitationOrigin(String link, String date) {
		this.link = link;
		this.date = date;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
