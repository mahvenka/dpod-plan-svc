/**
 * 
 */
package com.ge.ren.planning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ge.ren.planning.domain.TaskTypesForRole;

/**
 * 
 * @author Yessesvy
 */
@Repository
public interface TaskTypesRoleRepository extends JpaRepository<TaskTypesForRole, Long> {

}
