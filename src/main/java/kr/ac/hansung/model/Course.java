package kr.ac.hansung.model;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Course {
	private int year;
	private int semester;
	
	@NotEmpty(message="과목코드를 입력해주세요")
	private String code;
	
	@NotEmpty(message="과목명을 입력해주세요")
	private String name;

	private String classify;
	private int credit;
}
