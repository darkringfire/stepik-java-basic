package kao.stepik.basic;

import java.util.HashMap;
import java.util.Map;

public class RolesSpeech {

	public static void main(String[] args) {
		String[] roles = { "Городничий", "Аммос Федорович", "Артемий Филиппович", "Лука Лукич" };
		String[] textLines = {
				"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
				"Аммос Федорович: Как ревизор?", "Артемий Филиппович: Как ревизор?",
				"Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
				"Аммос Федорович: Вот те на!", "Артемий Филиппович: Вот не было заботы, так подай!",
				"Лука Лукич: Господи боже! еще и с секретным предписаньем!"

		};
		System.out.println(">>>");
		System.out.println(printTextPerRole(roles, textLines));
		System.out.println(">>>");
	}

	private static String printTextPerRole(String[] roles, String[] textLines) {
		int rolesLength = roles.length;
		Map<String, Integer> rolesOrder = new HashMap<>();
		StringBuilder[] roleLines = new StringBuilder[rolesLength];
		for (int i = 0; i < rolesLength; i++) {
			roleLines[i] = new StringBuilder(roles[i] + ":\n");
			rolesOrder.put(roles[i], i);
		}

		for (int i = 0; i < textLines.length; i++) {
			String[] speach = textLines[i].split(": ", 2);
			String roleName = speach[0];
			int roleNumber = rolesOrder.get(roleName);
			String speachLine = String.valueOf(i + 1) + ") " + speach[1];
			roleLines[roleNumber].append(speachLine + "\n");
		}

		return String.join("\n", roleLines);
	}
}
