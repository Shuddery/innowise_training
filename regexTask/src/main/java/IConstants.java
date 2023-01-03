public interface IConstants {
    public String htmlColorRegex = "^#([A-Fa-f\\\\d]{6})";
    public String numbersWithoutTowardsPlusSignRegex = "(\\d)[^a-zA-Z\\d+]";
    public String textWithSameAmountOfBracketsRegex = "\\(([^()]+)\\)";
    public String correctTimeRegex = "([0-1][\\d]:{1}[0-5][\\d]|2[0-3]:{1}[0-5][\\d])";
    public String decimalRegex = "^0$|^[1-9]\\d*$|^\\.\\d+$|^0\\.\\d*$|^[1-9]\\d*\\.\\d*$";
    public String textInQuotesRegex = "\"[^\"]*\"";
}