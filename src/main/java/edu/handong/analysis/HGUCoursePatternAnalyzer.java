package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer {
	
	private String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	private int numOfStudents;
	private int numOfCourses;
	private Student[] students;
	private Course[] courses;
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
	
		students = initiateStudentArrayFromLines(lines);
		
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			System.out.println(student.getName());
		}
		
		courses = initiateCourseArrayFromLines(lines);
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}
		
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private Student[] initiateStudentArrayFromLines(String[] lines) {
		int count=0;
		String n;
		Student initStudent;
		Student [] initStudents=new Student[numOfStudents];
		for(int i=0;(i<lines.length)&&count<numOfStudents;i++) {
			n=lines[i].split(",")[1];
			initStudent=new Student(n.trim());
			if(studentExist(initStudents,initStudent)) {
				initStudents[count]=initStudent;
				count++;
			}
		}
		return initStudents;
	}
	

	/**
	 * This method check if there is the same name of the second arugement in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(Student[] students, Student student) { 
		for(int count=0;count<students.length;count++) {
			if(null==students[0]) {
				return true;	
			}
			else if(null==students[count]) {
				continue;	
			}
			else if(student.getName().equals(students[count].getName())){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {
		int count=0;
		String n;
		Course initCourse;
		Course [] initCourses=new Course[numOfCourses];
		for(int i=0;(i<lines.length)&&count<numOfCourses;i++) {
			n=lines[i].split(",")[2];
			initCourse=new Course(n.trim());
			if(courseExist(initCourses,initCourse)) {
				initCourses[count]=initCourse;
				count++;
			}
		}
		return initCourses;
	}
	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course) {
		for(int count=0;count<courses.length;count++) {
			if(null==courses[0]) {
				return true;	
			}
			else if(null==courses[count]) {
				continue;	
			}
			else if(course.getCourseName().equals(courses[count].getCourseName())){
				return false;
			}
		}
		return true;
	}
}