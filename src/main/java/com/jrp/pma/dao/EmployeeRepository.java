package com.jrp.pma.dao;

import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "rest-api-employees", path = "rest-api-employees")
@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

    @Override
    List<Employee> findAll();

    @Query(nativeQuery = true, value = "SELECT e.first_name AS firstName, e.last_name AS lastName, COUNT(pe.employee_id) AS projectCount " +
            "FROM employee e LEFT JOIN project_employee pe " +
            "ON pe.employee_id = e.employee_id " +
            "GROUP by e.first_name, e.last_name ORDER BY 3 DESC")
    List<EmployeeProject> employeeProjects();

    Employee findByEmail(String value);

    Employee findByEmployeeId(Long theId);

}
