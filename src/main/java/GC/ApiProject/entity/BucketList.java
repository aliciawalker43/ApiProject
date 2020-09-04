package GC.ApiProject.entity;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class BucketList {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long table_id;
	private String id;
	private String name;
	private String info;
	
	
	public Long getTable_id() {
		return table_id;
	}
	public void setTable_id(Long table_id) {
		this.table_id = table_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public BucketList(Long table_id, String id, String name, String info) {
		super();
		this.table_id = table_id;
		this.id = id;
		this.name = name;
		this.info = info;
	}
	public BucketList() {
		super();
	}
	
	
}
	
	



