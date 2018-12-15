package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.Course;
import kr.ac.hansung.service.CourseService;

@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping("/course")
	public String showCreditPerSemester(Model model) {
		List<Course> course = courseService.getCreditPerSemester();
		model.addAttribute("courses", course);

		return "courseCompleted";
	}
	
	@RequestMapping("/courseCompleted")
	public String showCourse(Model model, @RequestParam(value="year")int year, 
			@RequestParam(value="semester")int semester) {
		
		List<Course> course = courseService.getCourseInSemeter(year, semester);
		model.addAttribute("courses", course);
		
		return "showenrolment";
		
	}

	@RequestMapping("/enrolment")
	public String inputEnrolment(Model model) {

		model.addAttribute("course", new Course());

		return "enrolment";
	}

	@RequestMapping("/doEnrolment")
	public String doEnrolment(Model model, @Valid Course course, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("===Form data does not validated");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error:errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "enrolment";
			
		}
		course.setYear(2019);
		course.setSemester(1);
		courseService.insert(course);

		return "enrolmentcomplete";
	}
	
	
	@RequestMapping("/showenrolment")
	public String showEnrolment(Model model) {
		List<Course> course = courseService.getCourseInSemeter(2019, 1);

		model.addAttribute("courses", course);

		return "showenrolment";
	}

	

}
