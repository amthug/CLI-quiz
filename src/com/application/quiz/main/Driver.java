package com.application.quiz.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.application.quiz.constant.AppConstants.Answers;
import com.application.quiz.constant.AppConstants.Questions;
import com.application.quiz.model.Answer;
import com.application.quiz.model.Question;
import com.application.quiz.model.Quiz;
import com.application.quiz.model.User;

public class Driver {

	public static void main(String[] args) {

		// get questions and their respective options and the correct answer
		List<Answer> ansList1 = getAnswersList1();
		Question q1 = new Question(1, Questions.HIGHEST_WICKET_TAKER_TEST, ansList1, ansList1.get(3));

		List<Answer> ansList2 = getAnswersList2();
		Question q2 = new Question(2, Questions.HIGHEST_WICKET_TAKER_ODI, ansList2, ansList2.get(0));

		List<Answer> ansList3 = getAnswersList3();
		Question q3 = new Question(3, Questions.HIGHEST_WICKET_TAKER_IPL, ansList3, ansList2.get(3));

		List<Question> questionList = Arrays.asList(new Question[] { q1, q2, q3 });

		// The interactive CLI
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the sports quiz 2019!");

		List<User> userList = new ArrayList<>();

		while (true) {
			System.out.println("Select below:");
			System.out.println("1. Take a quiz");
			System.out.println("2. Check score");
			int operation = sc.nextInt();

			if (operation == 1) {
				System.out.println("Enter your name:");

				sc.nextLine();
				User user = new User(sc.nextLine(), 0, new HashMap<>());
				userList.add(user);

				// create a quiz
				Quiz quiz = new Quiz("Sports quiz", questionList, user);

				System.out.println("Starting in 3 seconds ...");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				for (Question que : quiz.getQuestions()) {
					System.out.println(que.getText());
					System.out.println("Options:");

					int i = 1;
					for (Answer ans : que.getOptions()) {
						System.out.println(String.format("%d. %s", i++, ans.getText()));
					}

					Answer userResponse = que.getOptions().get(sc.nextInt() - 1);
					user.getAnswered().put(que, userResponse);
					user.setScore(userResponse.getId().equals(que.getAnswer().getId()) ? user.getScore() + 1
							: user.getScore() - 1);

					System.out.println();
				}

				System.out.println("Quiz ended. Your score " + user.getScore());

			} else if (operation == 2) {
				System.out.println("Enter your name:");
				sc.nextLine();
				String name = sc.nextLine();
				if (!userList.stream().anyMatch(u -> u.getName().equals(name))) {
					System.out.println("User not found. Take a quiz.");
				} else {
					System.out.println("Your score " + userList.stream().filter(u -> u.getName().equals(name))
							.collect(Collectors.toList()).get(0).getScore());
				}
			} else {
				System.out.println("Bad Input!");
			}

			System.out.println("Enter CONTINUE to try again or STOP.");
			String command = sc.next();
			if (command.equals("STOP")) {
				break;
			}
		}

		sc.close();
	}

	private static List<Answer> getAnswersList3() {
		List<Answer> answers = new ArrayList<>();
		answers.add(new Answer(1, Answers.BHAJJI));
		answers.add(new Answer(2, Answers.BHUVI));
		answers.add(new Answer(3, Answers.RAINA));
		answers.add(new Answer(4, Answers.BRAVO));
		return answers;
	}

	private static List<Answer> getAnswersList2() {
		List<Answer> answers = new ArrayList<>();
		answers.add(new Answer(1, Answers.MUTHAIAH));
		answers.add(new Answer(2, Answers.WASIM));
		answers.add(new Answer(3, Answers.WAQAR));
		answers.add(new Answer(4, Answers.VAAS));
		return answers;
	}

	private static List<Answer> getAnswersList1() {
		List<Answer> answers = new ArrayList<>();
		answers.add(new Answer(1, Answers.WARNE));
		answers.add(new Answer(2, Answers.KUMBLE));
		answers.add(new Answer(3, Answers.MCGRATH));
		answers.add(new Answer(4, Answers.MUTHAIAH));
		return answers;
	}
}
