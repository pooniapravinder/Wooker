package utils.words.capitalize;

public class Capitalize {

    public static String getCapitalize(String input) {
        if ((input == null) || (input.isEmpty())) {
            return input;
        }

        String str = input.trim().replaceAll("\\s+", " ");
        StringBuilder result = new StringBuilder(str.length());
        String words[] = str.split("\\ ");
        for (String word : words) {
            result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1).toLowerCase()).append(" ");
        }
        return result.toString().trim();
    }

}
