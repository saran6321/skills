package com.skar.jk.java;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MainJava extends AbstractClass implements MainInterface {
    //public static methods can be called from other static method without initialisation or directly using class name
    //static method can be private
    // main is static so it does not need an object and can be called directly with the class name
    // accepts string[] command line arguments that can initialise the configuration of the program

    // static method belongs to class and can be called with ClassName or from other methods directly and without instance
    // non static method belongs to instance of the class and can be called only with instance.methodname()

    // private methods can be called within the class
    // public methods can be called from anywhere
    // protected can be called by instance of children classes

    public static void main(String[] args) {
        // declaration - TYPE VARIABLE = new CLASSNAME();
        tableOfContents();
    }

    private static void tableOfContents() {
        javaFacts();
        basics();
        math();
        oops();
        string();
        arrays();
        dataStructures();
        algorithms();
        problems();
    }

    private static void math() {
        Math.max(1,2);
    }

    private static void javaFacts() {
        /*
        * platform independent
        * does not depend on hardware compiler compiles to byte code which can be run in any system with JRE
        *
        * not a fully oops language
        * as it still supports primitive data types
        *
        * stack memory
        * memory assigned to each individual program
        *
        * heap memory
        * memory not allocated to java program but will be available to use
        *
        * java both compiled and interpreted
        * java is both compiled and interpreted language while c and c++ is compiled language
        *
        * pointers in java
        * java does not allow pointers but internally it uses it
        * pointers are not used to acheive abstration and for security as direct memory access need careful handling and cause unwanted issues
        *
        * what are instance
        *instance variables are the variable of the the class particular instance
        *
        * default value assigned to the not assigned variables
        *no default value assigned to variable we need to initialise or else will throw variable might not be initialised error
        *but for instance objects reference will be null, numeric to 0, boolean to false
        *
        * data abstraction ?
        *data abstraction abstracts attribute in an instance can be checked during initialisation
        *
        * == .contains()
        *string will use constant pool of memory to store value where == compares the memory location and returns true if it matches
        *
        * can main method or static method be overloaded and what are the acceptable types
        *overload yes, static and main method can be overloaded public static void main(int[] args) but default will accept only String[]
        *
        * can static method be overridden
        * override no, as they are loaded and looked up during compile time
        *
        *public static void main(String args[])
        *public static void main(String[] args)
        *both are acceptable array representation in java
        *
        * overloading and overriding
        *overloading same method with different representation
        *overriding giving new definition for existing method in parent class
        *
        * try, catch, finally
        *a try block can have multiple catch block for each exception handling
        * finally will be executed of try or catch block irrespective of the flow
        * finally may not be executed if we use System.exit() or any fatal errors like stack overflow or memory access error
        *
        * final keyword
        *final keyword makes the class, variable as constant once assigned if not assigned can be assigned only once else throws [variable might already have been initialized] error
        *
        *final class cannot be inherited
        *final method cannot be overridden
        *final variable value cannot be changed
        *
        * use of finalize()
        *public void finalize() will be called before garbage collector at the end of the main program execution where clean up can be implemented
        *
        *
        * use of garbage collector
        * it is used to free up memory space
        *
        *
        *
        *
        *
        *
        * */
    }

    private static void oops() {
        MainJava mainJava = new MainJava();
        // non static methods can be called only with instance
        String s = mainJava.nonStaticStringReturnMethod();
        MainClass mainClass = new MainClass();
        // setting interface to mainjava instance for mainclass
        mainClass.setMainClass(mainJava);
        mainClass.callMainJavaMethod();
    }

    private String nonStaticStringReturnMethod(){
        // Non static methods can be called only with instances of class
        return "Saran kumar";
    }

    private static void dataStructures() {
        String[] STRINGS = {"bmw","benz","audi"};

        // All these extends -> collection which extends -> iterable
        // LISTS
        List<String> LIST;
        LIST = Arrays.asList(STRINGS);      // covert array to collection
        List<String> ALIST = new ArrayList<>(LIST);
        List<String> LLIST = new LinkedList<>();
        ALIST.add("kumar");
        ALIST.get(0);
        ALIST.indexOf("saran");
        LIST.contains("saran");
        LIST.size();
        LIST.toArray();
        ALIST.addAll(LIST);
        LIST.isEmpty();
        ALIST.sort((s, t1) -> 0);    // comparator interface
        LIST.iterator();
        LIST.remove("kumar");
        LIST.containsAll(LIST);
        ALIST.removeAll(LIST);
        // LIST.replaceAll("");     unary operator
        ALIST.equals("");
        ALIST.set(0,"set");
        ALIST.add(0,"add");
        ALIST.remove(0);
        ALIST.clear();

        //SET
        Set<String> SET = new HashSet<>();
        Set<String> TSET = new TreeSet<>();
        TSET.add("saran");

        // HASH MAP
        Map<Integer,Integer> MAP;
        MAP = new LinkedHashMap<>();
        MAP = new HashMap<>();
        MAP.put(0,1);           // creates new value or replaces
        MAP.get(0);
        MAP.containsKey(0);
        MAP.containsValue(1);
        MAP.getOrDefault(0,1);
        MAP.putIfAbsent(0,1);
        MAP.replace(0,5);           // only does replacing and returns old value
    }

    private static void arrays() {
        // SINGLE DIMENSIONAL ARRAY
        // declaration TYPE[] VARIABLE = {VALUE,VALUE,VALUE.....}
        // Accessed VARIABLE[INDEX]
        int[] ONEDARRAY = new int[2];
        int[] NUMBERS = {5,5,2,3,4};
        char[] CHARACTERS = {'a','b','c','d'};
        String[] STRINGS = {"benz","bmw","audi","rolls royce"};
        String STRING = STRINGS[1];

        // ITERATION
        for (int i = 0; i < STRINGS.length; i++) {
            // p(String.valueOf(i),STRINGS[i]);
        }

        // for(TYPE VARIABLE:ITERATOR)
        for (String s : STRINGS) {
            // p("for each",s);
        }

        // Array class with static methods
        Arrays.asList("bmw","benz","audi");
        Arrays.asList(NUMBERS);             // converts array to collection
        Arrays.sort(NUMBERS);               // sorts the array
        Arrays.toString(NUMBERS);
        Arrays.parallelSort(NUMBERS);
        Arrays.binarySearch(NUMBERS,5);
        Arrays.equals(NUMBERS,NUMBERS);     // returns true if the array contents matches
        Arrays.fill(NUMBERS,5);
        Arrays.copyOf(NUMBERS,5);
        Arrays.copyOfRange(NUMBERS,0,3);
        // Arrays.compare(NUMBERS,NUMBERS);     REQUIRES API LEVEL 33 TIRMANSU

        // MULTI DIMENSIONAL ARRAY
        int[][] TWODARRAY = new int[2][2];
        TWODARRAY[0][0] = 1;

        int[][][] THREEDARRAY = new int[2][2][2];
    }

    private static void string() {
        // String is not a type but a CLASS, each string is an object can be created with new keyword
        // STRING BUIILDER
        StringBuilder sb = new StringBuilder("sarankumar");
        sb.append("");
        sb.replace(0,5,"replace with");
        sb.reverse();
        sb.toString();

        // CHAR ARRAY
        char[] CHARSTRING = {'s','a','r','a','n'};

        //string
        String STRING = new String(CHARSTRING);     // char array to string
        STRING += STRING + " kumar karunakaran";

        // STRING METHODS
        STRING.length();        // length will always be +1 than the last index
        STRING.toCharArray();
        STRING.isEmpty();
        STRING.charAt(0);       // takes index as argument note for index out of bounds
        STRING.equals(STRING);  // equals returns the correct boolean value of the string object
        STRING.compareTo("sa");
        STRING.compareToIgnoreCase("SA");
        STRING.startsWith("sa");
        STRING.endsWith("ar");
        STRING.indexOf('a');
        STRING.indexOf('a',5);
        STRING.lastIndexOf('a');
        STRING.lastIndexOf('a',5);
        STRING.indexOf("sar");
        STRING.substring(5,7);
        STRING.concat("k");
        STRING.replace("kumar","");
        STRING.split("^sa$");
        STRING.toLowerCase();
        STRING.toUpperCase();
        STRING.trim();
        STRING.strip();
        STRING.isBlank();

        // Static methods
        String.valueOf(5);

        // STRING ITERATION
        for (char c : STRING.toCharArray()) {
            // p(String.valueOf(c));
        }

        for (int i = 0; i < STRING.length(); i++) {
            STRING.charAt(i);
        }
    }

    private static void basics() {
        Scanner sc = new Scanner(System.in);
        // sc.nextLine();sc.next();  get the inputs

        // DATA TYPES
        int INTEGER = 16;
        double PRICE = 10.0;
        long LONG = 5L;
        float FLOAT = 5F;
        char CHARACTER = 's';
        boolean BOOLEAN = true;
        String STRING = "This is string";

        // OPERATORS
        int SUM = INTEGER + INTEGER;
        int INTCHAR = CHARACTER + CHARACTER;
        String s1 = STRING + STRING;
        String s2 = STRING + CHARACTER;
        // BOOLEAN + BOOLEAN    Not possible

        // CONDITIONAL STATEMENTS
        // IF ELSE
        if (INTEGER > 0){
            // POSITIVE
        }else if (INTEGER == 0){
            // VALUE EQUAL TO 0
        }else {
            // VALUE IS NEGATIVE
        }

        // SWITCH
        switch (INTEGER){
            case 'a':
                // CHARACTER MATCH
                break;
            case 6:
                // INTEGER MATCH
                break;
            default:
                // DEFAULT MATCH
                break;
        }

        // LOOPING

        // FOR STATEMENT CONDITION STATEMENT
        for (int i = 0, j = 0; i < 1 && j < 1; i++, j++) {
            // EXPRESSION
        }

        // WHILE
        int i=0;
        while (i<10){
            // EXPRESSION
            i++;
        }

        // DO WHILE
        i = 0;
        do {
            // EXPRESSION
            i++;
        } while (i < 10);

        // Exception handling
        try {
            MainInterface mainInterface = null;
            mainInterface.interfaceMethod();
        } catch (Exception e) {
            // p("exception");
            // e.printStackTrace();
        }

    }

    public static void p(String title, String value) {
        System.out.println(title + " :");
        System.out.println(value);
        System.out.println();
    }

    public static void p(String value) {
        System.out.println(value);
        System.out.println();
    }

    public static void p(int value) {
        System.out.println(value);
        System.out.println();
    }

    @Override
    protected void abstractProtectedMethod() {

    }

    @Override
    public void interfaceMethod() {
        // INTERFACE IMPLEMENTATION IN MAIN CLASS
    }

    private static void algorithms() {
        divideAndConquer();
    }

    private static void divideAndConquer() {
        // big problems are cotegorised into smaller problem
    }

    private static void problems() {
        // INTEGERS
        pattern();
        palindrome();       // same on reverse
        // STRING
        reverseString();
        anagram();          // same quantity of characters even at different position
        printingDiagonalAxes();
        // MAP
        twoSum();
        // two dimensional array
        longestIncreasingSubsequenceInArray();
        //matrix
        checkUpperTriangleOrLowerTriangle();
        // complex
        differenceBetweenTwoDates();
    }

    private static void anagram() {
        // match the string irrespective of the character positions
        // make the stings to char array
        // sort the array
        // match the array
        String s1 = "sarankumar", s2 = "kumacrsaran";
        char[] a1 = s1.toCharArray(), a2 = s2.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        Arrays.equals(a1, a2);
        if (Arrays.equals(a1, a2)) {
            // p("anagram");
        } else {
            // p("not anagram");
        }
    }

    private static void reverseString() {
        String s = "sarankumar";
        String rs = new StringBuilder(s).reverse().toString();
        //p(rs);

        for (int i = s.length() - 1; i >= 0; i--) {
            // p(String.valueOf(s.charAt(i)));
        }
    }

    private static void differenceBetweenTwoDates() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) { // make this check true for normal run
            LocalDate BDATE = LocalDate.of(2001, 3, 6);
            LocalDate TODAY = LocalDate.now();

            long dd = ChronoUnit.DAYS.between(BDATE, TODAY);
            long md = ChronoUnit.MONTHS.between(BDATE, TODAY);
            long yd = ChronoUnit.YEARS.between(BDATE, TODAY);

            p("year", String.valueOf(yd));
            p("month", String.valueOf(md));
            p("days", String.valueOf(dd));
        }
    }

    private static void longestIncreasingSubsequenceInArray() {
        String s1 = "AGGTAB", s2 = "GXTXAYB";
        int l1 = s1.length(), l2 = s2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        // find max length
        for (int i = 0; i <= l1; i++) {         // goes through first string
            for (int j = 0; j <= l2; j++) {     // goes through second string for each character of first string
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;               // prevents index out of bounds
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {  // everything is handled on - 1 index level as 0 and 0 is not allowed
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        //create the array
        int length = dp[l1][l2];
    }

    private static void checkUpperTriangleOrLowerTriangle() {

    }

    private static void pattern() {
        twoDimensionalPattern();
    }

    private static void twoDimensionalPattern() {

    }

    private static void printingDiagonalAxes() {

    }

    private static void twoSum() {
        // given list find the two values that matches the sum value given 5
        // x + y = sum, create algebraic equation with available value and one of the unknown value
        // sum - x = y, store the index of x and value y in the hashmap, iterate and find the index of matching y in the list
        int[] l = {1,2,4,6,7,8,9};
        int sum = 6;
        Map<Integer,Integer> hm = new HashMap<>();
        for (int i = 0; i < l.length; i++) {
            if (hm.containsKey(l[i])){
                // p(hm.get(l[i]));
                // p(i);
                break;
            }
            int remain = sum - l[i];
            hm.put(remain,i);
        }
    }

    private static void palindrome() {
        // palindrome string
        // use for lop to get the left to right and right to left simultaneously
        String s = "racecars";
        int l = s.length();
        Boolean isPalindrome = true;
        for (int i = 0; i < l/2; i++) {
            if (s.charAt(i) != s.charAt(l - i - 1)) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome){
             // p("palindrome");
        }else {
             // p("Not a palindrome");
        }

        // string builder reverse approach
        StringBuilder sb = new StringBuilder(s);
        if (sb.toString().equals(sb.reverse().toString())) {
            // p("palindrome");
        } else {
            // p("not palindrome");
        }

        //palindrome number
        int num = 40404;
        int originalNum = num;
        int reverseNum = 0;
        while (num > 0) {
            reverseNum = reverseNum * 10 + (num % 10);
            num = num / 10;
        }
        if (originalNum == reverseNum) {
            // p("palindrome");
        } else {
            // p("not a palindrome");
        }
    }
}
