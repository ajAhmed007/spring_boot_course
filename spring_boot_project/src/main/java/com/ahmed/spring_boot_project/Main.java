package com.ahmed.spring_boot_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@GetMapping("/")
	public GreetResponse greet() {
		return new GreetResponse(
				"Hello", List.of(new Person(
				"Ahmed",
				"Abdullahi",
				25,
				"Software Engineer")));

	}

	//record GreetResponse(String greet){}
	static class Person {
		private String first_name;
		private String last_name;
		private int age;
		private String job;

		public Person(String first_name, String last_name, int age, String job) {
			this.first_name = first_name;
			this.last_name = last_name;
			this.age = age;
			this.job = job;
		}

		public String getFirst_name() {
			return first_name;
		}

		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}

		public String getLast_name() {
			return last_name;
		}

		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getJob() {
			return job;
		}

		public void setJob(String job) {
			this.job = job;
		}
	}

	static class GreetResponse {
		private String greet;
		private List<Person> profile;

		public GreetResponse(String greet, List<Person> profile) {
			this.greet = greet;
			this.profile = profile;
		}

		public String getGreet() {
			return greet;
		}

		public void setGreet(String greet) {
			this.greet = greet;
		}

		public List<Person> getProfile() {
			return profile;
		}

		public void setProfile(List<Person> profile) {
			this.profile = profile;
		}
	}
}
