package org.example.deo;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

public class ProjectDeo {
    private DataSource dataSource;
    private ProjectSqlUpDate projectSqlUpDate;

    private final String sqlForUpDate="update project set title=? where projectNo=?";

    public ProjectDeo(DataSource dataSource ) {
        this.dataSource = dataSource;
        projectSqlUpDate =new ProjectSqlUpDate(dataSource,sqlForUpDate);
    }
    public int updateProject(int projectNo,String title){
        return projectSqlUpDate.update(new Object[]{title,projectNo});
    }
    private final class ProjectSqlUpDate extends SqlUpdate{

        public  ProjectSqlUpDate(DataSource dataSource,String sqlQuery){
            super(dataSource,sqlQuery);
            declareParameter( new SqlParameter(java.sql.Types.VARCHAR));
            declareParameter( new SqlParameter(java.sql.Types.INTEGER));
            compile();
        }

}
}