package jdbc;

import java.sql.Date;

public class Pojo {

	@Column(name="name")
	private String name;

	@Column(name="context")
	private String context;

	@Column(name="data")
	private String data;

	@Column(name="updatedAt")
	private Date updatedAt;

	@Column(name="active")
	private boolean active;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
