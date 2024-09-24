package pruebaHibernate.example;

import java.sql.Date;

public class Event {
	
	//Spring e hibernate la Primary key siempre en Long
	private Long id;
	private String title;
	private Date date;
	
	//Para Hibernate y Spring el constructor siempre vacio sin parámetros
	public Event() {
		super();
	}
	public Long getId() {
		return id;
	}
	
	//Para Hibernate y Spring el establecer ID siempre private
	private void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	


}
