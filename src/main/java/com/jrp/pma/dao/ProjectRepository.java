package com.jrp.pma.dao;

import com.jrp.pma.dto.ChartData;
import com.jrp.pma.dto.TimeChartData;
import com.jrp.pma.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "rest-api-projects",path = "rest-api-projects")
@Repository
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {

    @Override
    List<Project> findAll();

    @Query(nativeQuery = true, value = "SELECT stage AS label, COUNT(*) as value " +
            "FROM project GROUP BY stage;")
    List<ChartData> getProjectStatus();

    Project findByProjectId(Long id);

    @Query(nativeQuery = true, value = "SELECT name as projectName, start_date as " +
            " startDate, end_date as endDate FROM project WHERE start_date IS NOT NULL;")
    List<TimeChartData> getTimeData();


}
