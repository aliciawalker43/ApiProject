package GC.ApiProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import GC.ApiProject.entity.Table;

public interface Dao extends JpaRepository <Table,Long> {
	

}
