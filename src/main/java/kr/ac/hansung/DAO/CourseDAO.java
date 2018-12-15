package kr.ac.hansung.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Course;

@Repository
public class CourseDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from course";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}

	// query and return a single object
	public Course getCourse(String code) {
		String sqlStatement = "select * from course where code=?";

		return jdbcTemplate.queryForObject(sqlStatement, new Object[] { code }, new RowMapper<Course>() {
			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {

				Course course = new Course();

				course.setYear(rs.getInt("year"));
				course.setSemester(rs.getInt("semester"));
				course.setCode(rs.getString("code"));
				course.setName(rs.getString("name"));
				course.setClassify(rs.getString("classify"));
				course.setCredit(rs.getInt("credit"));

				return course;
			}

		});
	}

	public List<Course> getCourses() {
		String sqlStatement = "select * from course";

		return jdbcTemplate.query(sqlStatement, new RowMapper<Course>() {
			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {

				Course course = new Course();

				course.setYear(rs.getInt("year"));
				course.setSemester(rs.getInt("semester"));
				course.setCode(rs.getString("code"));
				course.setName(rs.getString("name"));
				course.setClassify(rs.getString("classify"));
				course.setCredit(rs.getInt("credit"));

				return course;
			}

		});
	}
	

	public List<Course> getCreditPerSemester() {
		String sqlStatement = "select year, semester, sum(credit) credit from course where not year=2019 group by year,semester order by year, semester";

		return jdbcTemplate.query(sqlStatement, new RowMapper<Course>() {
			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {

				Course course = new Course();

				course.setYear(rs.getInt("year"));
				course.setSemester(rs.getInt("semester"));
				course.setCredit(rs.getInt("credit"));

				return course;
			}

		});
	}
	
	public List<Course> getCourseInSemeter(int year, int semester) {
		String sqlStatement = "select * from course where year=? and semester=?";

		return jdbcTemplate.query(sqlStatement, new Object[] { year, semester }, new RowMapper<Course>() {
			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {

				Course course = new Course();

				course.setYear(rs.getInt("year"));
				course.setSemester(rs.getInt("semester"));
				course.setCode(rs.getString("code"));
				course.setName(rs.getString("name"));
				course.setClassify(rs.getString("classify"));
				course.setCredit(rs.getInt("credit"));

				return course;
			}

		});
	}

	public boolean insert(Course course) {

		int year = course.getYear();
		int semester = course.getSemester();
		String code = course.getCode();
		String name = course.getName();
		String classify = course.getClassify();
		int credit = course.getCredit();
	

		String sqlStatement = "insert into course (year, semester, code, name, classify, credit) values(?,?,?,?,?,?)";

		return (jdbcTemplate.update(sqlStatement, new Object[] { year, semester, code, name, classify, credit }) == 1);
	}

	public boolean update(Course course) {

		int year = course.getYear();
		int semester = course.getSemester();
		String code = course.getCode();
		String name = course.getName();
		String classify = course.getClassify();
		int credit = course.getCredit();

		String sqlStatement = "update  course set year=?, semester=?, name=?, classify=?, credit=? where code=?";

		return (jdbcTemplate.update(sqlStatement, new Object[] { year, semester, name, classify, credit, code }) == 1);
	}

	public boolean delete(int id) {
		String sqlStatement = "delete from course where code=?";

		return (jdbcTemplate.update(sqlStatement, new Object[] { id }) == 1);
	}
	
	
	

}
