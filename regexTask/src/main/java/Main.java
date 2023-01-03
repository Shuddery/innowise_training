import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        //HTML color
        System.out.println(Pattern.matches(IConstants.htmlColorRegex, "#ABCDEE"));
        //Numbers in the text that are not followed by a + sign
        System.out.println(getNumbersWithoutTowardsPlusSign("3+4-2*9-6*5 "));
        //Correctly written expressions with brackets
        System.out.println(getTextWithSameAmountOfBrackets(
            "(test)(The number of open and closed brackets should be the same)"));
        //Both hours and minutes consist of two digits, for example: 09:00
        System.out.println(getCorrectTime("Breakfast at 09:00"));
        /* Fractional numbers from the text with a decimal separator
        in the form of a dot. The digits of the whole part may not be highlighted or separated by a space
        or comma. */
        System.out.println(Pattern.matches(IConstants.decimalRegex, "0.123"));
        /* Text enclosed in quotation marks.
        When solving the problem, take into account that the text can be located on several lines */
        System.out.println(Pattern.matches(IConstants.textInQuotesRegex
            , "\"text\n"
                + "on several\n"
                + "lines\""));
    }

    private static List<String> getNumbersWithoutTowardsPlusSign(String str) {
        return getGroupListWithRegex(IConstants.numbersWithoutTowardsPlusSignRegex, str);
    }

    private static List<String> getTextWithSameAmountOfBrackets(String str) {
        return getGroupListWithRegex(IConstants.textWithSameAmountOfBracketsRegex, str);
    }

    private static List<String> getCorrectTime(String str) {
    return getGroupListWithRegex(IConstants.correctTimeRegex, str);
    }

    private static List<String> getGroupListWithRegex(String regex, String str) {
        List<String> list = new ArrayList<>();
        Matcher matcher = Pattern.compile(regex).matcher(str);
        while (matcher.find()) {
            for (int i = 1; i <= matcher.groupCount(); i++) {
                list.add(matcher.group(i));
            }
        }
        return list;
    }
}