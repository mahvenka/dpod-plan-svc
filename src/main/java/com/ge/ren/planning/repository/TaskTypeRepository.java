/**
 * 
 */
package com.ge.ren.planning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.ge.ren.planning.domain.TaskType;

/**
 * @author 502687773
 *
 */

@Repository
public interface TaskTypeRepository extends JpaRepository<TaskType, Long> {

    /**
     * @param userRoleId
     * @return
     */
    @Query(value = "select a.task_type_id, a.tenant_id, a.task_type_name_default, "
	    + "a.display_order, a.is_active, a.created_by, a.created_on, a.last_updated_by, "
	    + "a.last_updated_on from task_type a, task_types_for_role b where a.task_type_id = b.task_type_id "
	    + "and b.user_role_id = :userRoleId", nativeQuery = true)
    List<TaskType> fetchTaskTypeByUserRoleId(@Param(value = "userRoleId") Long userRoleId);

}
