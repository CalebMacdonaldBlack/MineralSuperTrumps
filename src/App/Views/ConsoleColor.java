package App.Views;

/**
 * Created by calebmacdonaldblack on 29/09/2016.
 */
class ConsoleColor {
    private static final String ANSI_RESET = "\u001B[0m";
    // public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    // public static final String ANSI_WHITE = "\u001B[37m";

    /**
     * Wraps text with color and escapes with original color
     *
     * @param text      Text to wrap
     * @param ansiColor Color to change text to
     * @return The final colored text
     */
    public static String colorText(String text, String ansiColor) {
        return ansiColor + text + ANSI_RESET;
    }
}
