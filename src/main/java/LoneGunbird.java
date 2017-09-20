import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * Retrieve contents from a URL and return them as a string.
 *
 * @param url url to retrieve contents from
 * @return the contents from the url as a string, or an empty string on error
 */
public class LoneGunbird {
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int wordCount(String page){
        int wordCount = 0;

        boolean isword = false;
        int endOfLine = page.length() - 1;

        for (int i = 0; i < page.length(); i++) {
            // if the char is a letter, word = true.
            if (Character.isLetter(page.charAt(i)) && i != endOfLine) {
                isword = true;
                // if char isn't a letter and there have been letters before,
                // counter goes up.
            } else if (!Character.isLetter(page.charAt(i)) && isword) {
                wordCount++;
                isword = false;
                // last word of String; if it doesn't end with a non letter, it
                // wouldn't count without this.
            } else if (Character.isLetter(page.charAt(i)) && i == endOfLine) {
                wordCount++;
            }
        }
        return wordCount;
    }

    public static int specifiCount(String page){
        int wordCount = 0;

        boolean isword = false;
        int endOfLine = page.length() - 1;

        for (int i = 0; i < page.length(); i++) {
            // if the char is a letter, word = true.
            if (page.substring(i,i+5).equalsIgnoreCase("prince") && i != endOfLine) {
                isword = true;
                // if the character and the 6 next characters are "prince" word count goes up
                // counter goes up.
            } else if (!page.substring(i,i+5).equalsIgnoreCase("prince") && isword) {
                wordCount++;
                isword = false;
                // last word of String; if it doesn't end with a non letter, it
                // wouldn't count without this.
            }
        }
        return wordCount;
    }

    public static void main(String args[]){
        String url = "http://erdani.com/tdpl/hamlet.txt";
        String page = urlToString(url);
        int words = wordCount(page);
        System.out.println("there are " + words + " words in " + url);

    }

}
