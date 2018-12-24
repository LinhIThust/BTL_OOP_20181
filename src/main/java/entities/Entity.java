
package entities;

import java.util.ArrayList;

public class Entity {

	private String id;
	private String lable;
	private String description;
	private CitationOrigin co;

	public Entity() {
	}

	public Entity(String id, String lable, String description, CitationOrigin co) {
		this.id = id;
		this.lable = lable;
		this.description = description;
		this.co = co;
	}

	public Entity(String lable, String description) {
		super();
		this.lable = lable;
		this.description = description;
	}

	public Entity(String lable, String description, CitationOrigin co) {
		super();
		this.lable = lable;
		this.description = description;
		this.co = co;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLable() {
		return lable;
	}

	public void setLable(String lable) {

		this.lable = lable;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CitationOrigin getCo() {
		return co;
	}

	public void setCo(CitationOrigin co) {
		this.co = co;
	}

}
