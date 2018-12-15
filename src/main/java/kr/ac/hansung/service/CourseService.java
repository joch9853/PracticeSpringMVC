package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.DAO.CourseDAO;
import kr.ac.hansung.model.Course;



@Service
public class CourseService {
	
	@Autowired
	private CourseDAO courseDao;
	
	public List<Course> getCurrent() {
		return courseDao.getCourses();
	}

	public void insert(Course course) {
		courseDao.insert(course);
		
	}
	
	//특정 연도와 학기에 수강한 과목들
	public List<Course> getCourseInSemeter(int year, int semester) {
		return courseDao.getCourseInSemeter(year, semester);
	}
	
	
	public List<Course> getCreditPerSemester() {
		return courseDao.getCreditPerSemester();
	}

}
