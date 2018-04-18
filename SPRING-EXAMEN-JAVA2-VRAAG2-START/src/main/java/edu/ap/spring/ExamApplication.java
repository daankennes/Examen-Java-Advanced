package edu.ap.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExamApplication {
	
	@Autowired
	private Exam exam;
	
	@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return (args) -> {
			
			//test opgave 1
			int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
			int[] res0 = exam.getPrimes(numbers);
			for (int i : res0) {
				System.out.print(", ");
				System.out.print(i);
			}
			System.out.println("");
			
			//test opgave 2
			int res1 = exam.countLowercaseCharacters("WiE hEEft ER examENstress?");
			System.out.println(res1); //14
			
			//test opgave 3
			int res2 = exam.sumOfX(exam.generatePoints());
			System.out.println(res2); //4
			
			//test opgave 4
			String res3 = exam.getXOverTwo(exam.generatePoints());
			System.out.println(res3);
		};
    }
	
	public static void main(String[] args) {
		SpringApplication.run(ExamApplication.class, args);
	}
}