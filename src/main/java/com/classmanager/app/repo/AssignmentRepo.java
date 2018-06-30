package com.classmanager.app.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.jpa.repository.JpaRepository;

import com.classmanager.app.model.Assignment;

public interface AssignmentRepo extends JpaRepository<Assignment, Long>, AssignmentRepoCustom{

}
interface AssignmentRepoCustom{
	List<Assignment> findByCourseId(Long id);
}

class AssignemntRepoImpl implements AssignmentRepoCustom{
	 @PersistenceContext
	  EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Assignment> findByCourseId(Long id) {
		Query q = entityManager.createNativeQuery("SELECT * FROM assignment WHERE fk_course = ?", Assignment.class);
		q.setParameter(1, id);
		return q.getResultList();
	}
	
}
