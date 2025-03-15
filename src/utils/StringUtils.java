package utils;

public class StringUtils {
    public static int getQuestionNumber(String question) {
        String firstPart = question.split("-")[0].trim();
        return Integer.parseInt(firstPart);
    }
}
