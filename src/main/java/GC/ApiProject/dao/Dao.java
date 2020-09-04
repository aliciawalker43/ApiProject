package GC.ApiProject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import GC.ApiProject.entity.BucketList;

public interface Dao extends JpaRepository <BucketList,Long> {
	

 
}
