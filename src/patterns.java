/**
 *
 * @author Ahad Can PAKSOY ahad.paksoy@ogr.sakarya.edu.tr
 * @since 31.03.2022
 * <p>
 * Regex desenlerinin bulunduğu ve istenilen formatta ekrana bastırılma işlemin yapıldığı sınıf
 * </p>
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class patterns {
    public static void REGEX_PATTERNS(String str) {
        /*
         * @desc
         * Creates regex for unary operators
         * operators : ++obj,--obj,-obj,+obj,!obj
         *
         *  */
        Pattern UNARY_OPERATORS_REGEX_PATTERN_1 = Pattern.compile("([+][+][a-z0-9]|[~]|[-][-][a-z0-9])", Pattern.CASE_INSENSITIVE);
        Pattern UNARY_OPERATORS_REGEX_PATTERN_2 = Pattern.compile("([^-+*/a-z0-9][+-][a-zA-Z0-9])", Pattern.CASE_INSENSITIVE);
        Pattern UNARY_OPERATORS_REGEX_PATTERN_3 = Pattern.compile("(![a-zA-Z]+)", Pattern.CASE_INSENSITIVE);
        /*
        * @desc
        * Creates regex for binary operators
        * operators: obj + obj, obj - obj, obj * obj, obj / obj, obj % obj
        * operators: obj += obj, obj -= obj, obj *= obj, obj /= obj, obj %= obj, obj &= obj, obj |= obj
        *
        * */
        Pattern BINARY_OPERATORS_REGEX_PATTERN = Pattern.compile("([a-z0-9)]*\\h[-+~/*%=]\\h*[a-z0-9]|[a-z0-9][-+~/*=][a-z0-9]|[-+~/*=&^|%][=])", Pattern.CASE_INSENSITIVE);
        Pattern BINARY_OPERATORS_REGEX_PATTERN_2 = Pattern.compile("([-+*/%&|^][=])", Pattern.CASE_INSENSITIVE);
        /*
        * @desc
        * Creates regex for logical operators
        * operators: &&,||,!obj
        *
        * */
        Pattern LOGICAL_OPERATORS_REGEX_PATTERN = Pattern.compile("([&][&]|[|][|])", Pattern.CASE_INSENSITIVE);
        Pattern LOGICAL_OPERATORS_REGEX_PATTERN_2 = Pattern.compile("(!.)", Pattern.CASE_INSENSITIVE);
        /*
        * @desc
        * Creates regex for relational operators
        * operators: >,<,>=,<=,==,!=
        *
        * */
        Pattern RELATIONAL_OPERATORS_REGEX_PATTERN = Pattern.compile("([<>]|[><=]=)", Pattern.CASE_INSENSITIVE);
        Pattern RELATIONAL_OPERATORS_REGEX_PATTERN_2 = Pattern.compile("!=", Pattern.CASE_INSENSITIVE);

        Pattern SUM_OF_OPERATORS = Pattern.compile("([-+*/%&|^=><]|[-+~/*=&^|%][=])",Pattern.CASE_INSENSITIVE);

        // instanceof is a relational operator according to oracle ¯\_(ツ)_/¯
        // source : https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html


        /*
        * @desc
        * What is matcher?
        * An engine that performs match operations on a character sequence by interpreting a Pattern.
        *
        * */
        Matcher unaryMatcher_1 = UNARY_OPERATORS_REGEX_PATTERN_1.matcher(str.toString());
        Matcher unaryMatcher_2 = UNARY_OPERATORS_REGEX_PATTERN_2.matcher(str.toString());
        Matcher unaryMatcher_3 = UNARY_OPERATORS_REGEX_PATTERN_3.matcher(str.toString());
        Matcher binaryMatcher = BINARY_OPERATORS_REGEX_PATTERN.matcher(str.toString());
        Matcher binaryMatcher_2= BINARY_OPERATORS_REGEX_PATTERN_2.matcher(str.toString());
        Matcher logicalMatcher = LOGICAL_OPERATORS_REGEX_PATTERN.matcher(str.toString());
        Matcher logicalMatcher_2 = LOGICAL_OPERATORS_REGEX_PATTERN_2.matcher(str.toString());
        Matcher relationalMatcher = RELATIONAL_OPERATORS_REGEX_PATTERN.matcher(str.toString());
        Matcher relationalMatcher_2 = RELATIONAL_OPERATORS_REGEX_PATTERN_2.matcher(str.toString());
        Matcher summary = SUM_OF_OPERATORS.matcher(str.toString());
        /*
        * @desc
        * right side the assignment returns a stream of match results for each subsequence of the input sequence that matches the pattern
        * and .count function returns the count of elements
        * */
        long sum = summary.results().count(); // returns number of all operands
        short unaryMatches_1 = (short) unaryMatcher_1.results().count();
        short unaryMatches_2 = (short) unaryMatcher_2.results().count();
        short unaryMatches_3 = (short) unaryMatcher_3.results().count();
        short binaryMatches_1 = (short) binaryMatcher.results().count();
        short binaryMatches_2 = (short) binaryMatcher_2.results().count();
        short logicalMatches_1 = (short) logicalMatcher.results().count();
        short logicalMatches_2 = (short) logicalMatcher_2.results().count();
        short relationalMatches_1 =(short) relationalMatcher.results().count();
        short relationalMatches_2 = (short) relationalMatcher_2.results().count();
        int logicalMatches = logicalMatches_1 + logicalMatches_2; // sum of logical operators
        int relationalMatches = relationalMatches_1 + relationalMatches_2; // sum of all relational matches
        int binaryMatches = binaryMatches_1 + logicalMatches_1 + logicalMatches_2 + relationalMatches+binaryMatches_2; // sum of all binary operators
        int arithmeticOperators = unaryMatches_1 + unaryMatches_2 + binaryMatches;  // sum of arithmetic operators
        int unaryMatches = unaryMatches_1 + unaryMatches_2 + unaryMatches_3; // sum of unary operators

            // stdout
            System.out.println("Operator Bilgisi : ");
            System.out.println("       Tekli operator sayisi : " + unaryMatches + "\n" +
                    "       Ikili operator sayisi : " + binaryMatches + "\n" +
                    "       Sayisal operator sayisi : " + arithmeticOperators + "\n" +
                    "       Iliskisel operator sayisi : " + relationalMatches + "\n" +
                    "       Mantiksal operator sayisi : " + logicalMatches);
            System.out.println("Operand Bilgisi : " + "\n" +
                    "       Toplam Operand Sayisi: " + sum);


        }
}
