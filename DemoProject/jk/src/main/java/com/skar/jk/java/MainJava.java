package com.skar.jk.java;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
        basics();   // in out, data types, operator, conditional statements, looping
        defaultMethods();
        string();
        arrays();
        dataStructures();
        algorithms();
        problemsAndAlgorithms();
        javaFacts();
        oops();
    }

    private static void defaultMethods() {
        //integer
        Integer.parseInt(String.valueOf('1'));
        Integer.toBinaryString(1);

        //character

        // STRING
        String STRING = "sarankumar";
        STRING.length();        // length will always be +1 than the last index
        STRING.toCharArray();
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
        STRING.isEmpty();

            // Static methods
        String.valueOf(5);

        // Array
        int NUMBERS[]={1,2,3,4,5,6,7,8,9};
        int[][] _2d = {{1,2,3},{4,5,6}};


        Arrays.asList("bmw","benz","audi");
        Arrays.asList(NUMBERS);             // converts array to collection
        Arrays.equals(NUMBERS,NUMBERS);     // returns true if the array contents matches
        Arrays.sort(NUMBERS);               // sorts the array
        Arrays.toString(NUMBERS);
        Arrays.parallelSort(NUMBERS);
        Arrays.binarySearch(NUMBERS,5);
        Arrays.fill(NUMBERS,5);
        Arrays.copyOf(NUMBERS,5);
        Arrays.copyOfRange(NUMBERS,0,3);
        // Arrays.compare(NUMBERS,NUMBERS);     REQUIRES API LEVEL 33 TIRMANSU

        //collections
        List LIST = new ArrayList<Integer>();
        Collections.sort(LIST);
        Collections.sort(LIST, Comparator.comparing(i -> (int) i).reversed());

        //math
        Math.max(1,2);
        Math.pow(3,2);

        //float

        //double
    }

    private static void javaFacts() {
        /*
        *
        * java was created for interactive television
        *
        *java does not have pointers, operator overloading
        *
        * java has automatic garbage collectors
        *
        * runs top on hardware based platforms and has two components, runtime environment and application programming interface
        *
        * platform independent
        * does not depend on hardware compiler compiles to byte code which can be run in any system with JRE with virtual machines
        *
        * compile time
        * .java -> compiler -> .class byte code
        *
        * run time
        * class file -> class loader -> bytecode verified -> interpreter -> runtime -> hardware
        *
        * platform dependent
        * jvm
        * provides java runtime environment for the machine
        * jre
        * it provides set of tools for developing java application
        * jdk
        * this provides jre and development tools for java development
        *
        * acceptable
        * public static void main(String[] args)
        * public static void main(String []args)
        * public static void main(String args[])
        * public static void main(String... args)   vararg support as well
        *
        * java can have semicolon at the end of the class if needed
        *
        * main method can be final and it is valid
        * main method must always be public
        * main method cannot be abstract
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
        //o(n) o(logn)
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
        MAP.keySet();
        MAP.getOrDefault(0,1);
        MAP.putIfAbsent(0,1);
        MAP.replace(0,5);           // only does replacing and returns old value

        defaultMethods();

        //iteration
        //list and set
        for (String i : ALIST) {
            i.toString();
        }

        //map
        for (Integer i : MAP.keySet()){
            MAP.getOrDefault(i, 1);
        }

    }

    private static void arrays() {
        // SINGLE DIMENSIONAL ARRAY
        // declaration TYPE[] VARIABLE = {VALUE,VALUE,VALUE.....}
        // Accessed VARIABLE[INDEX]
        int[] ONEDARRAY = new int[2];
        int[] ARRAY = new int[]{1,2,3,4,5};
        int[] NUMBERS = {5,5,2,3,4};
        char[] CHARACTERS = {'a','b','c','d'};
        String[] STRINGS = {"benz","bmw","audi","rolls royce"};
        String STRING = STRINGS[1];

        // arrays are objects with reference reused again and again
        // on changing the copied array or local array received through parameters with reflect on the original array as well
        // to create an independent array
        int copy[] = Arrays.copyOf(NUMBERS, NUMBERS.length); // this creates new array and copies the array to the new one

        // ITERATION
        for (int i = 0; i < STRINGS.length; i++) {
            // p(String.valueOf(i),STRINGS[i]);
        }

        // for(TYPE VARIABLE:ITERATOR)
        for (String s : STRINGS) {
            // p("for each",s);
        }

        defaultMethods();

        // MULTI DIMENSIONAL ARRAY
        int[][] TWODARRAY = new int[2][2];
        TWODARRAY[0][0] = 1;

        int[][][] THREEDARRAY = new int[2][2][2];

        multiDimensionalArrayOrMatrix();
    }

    private static void multiDimensionalArrayOrMatrix() {

    }

    private static void string() {
        // String is not a type but a CLASS, each string is an object can be created with new keyword
        // CHAR ARRAY
        char[] CHARSTRING = {'s','a','r','a','n'};

        //string
        String STRING = new String(CHARSTRING);     // char array to string
        STRING += STRING + " kumar karunakaran";

        defaultMethods();

        // STRING ITERATION
        for (char c : STRING.toCharArray()) {
            // p(String.valueOf(c));
        }

        for (int i = 0; i < STRING.length(); i++) {
            STRING.charAt(i);
        }

        // STRING BUIILDER
        StringBuilder sb = new StringBuilder("sarankumar");
        sb.append("");
        sb.replace(0,5,"replace with");
        sb.reverse();
        sb.toString();
    }

    private static void basics() {
        Scanner sc = new Scanner(System.in);
        // sc.nextLine();sc.next();  get the inputs

        // DATA TYPES
        byte BYTE = 0;                  // 1 byte   min -128    max 127
        boolean BOOLEAN = false;        // 1 bit
        char CHARACTER = '\u0000';      // 2 byte   java uses unicode system and not ascii system this is the lowest value, highest value = \uFFFF
        short SHORT = 0;                // 2 byte
        int INT = 0;   // 4 byte int cannot be null while Integer type can be null that's a reason to be used in collection
        float FLOAT = 0.0F;             // 4 byte
        long LONG = 0L;                 // 8 byte
        double PRICE = 0.0d;            // 8 byte
        String STRING = "This is string";

        //conversion can be done to primitive data types
        int ASCII = (int)CHARACTER;
        //toUpperCaseOrLowerCase('a');  // check for using ascii to convert character to upper case and lower case


        // OPERATORS
        int SUM = INT + INT;
        int INTCHAR = CHARACTER + CHARACTER;
        String s1 = STRING + STRING;
        String s2 = STRING + CHARACTER;
        int GREATER = 10 > 100 ? 1 : 0;
        // BOOLEAN + BOOLEAN    Not possible

        // CONDITIONAL STATEMENTS
        // IF ELSE
        if (INT > 0){
            // POSITIVE
        }else if (INT == 0){
            // VALUE EQUAL TO 0
        }else {
            // VALUE IS NEGATIVE
        }

        // SWITCH
        switch (INT){
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

    private static void toUpperCaseOrLowerCase(char a) {
        if (a >= 'A' && a <= 'Z') {
            a = (char) (a - 'A' + 'a');
        } else if (a >= 'a' && a <= 'z') {
            a = (char) (a - 'a' + 'A');
        }
        //System.out.println(a);
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

    public static void p(double value) {
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
        searching();
        sorting();
        dynamicProgramming();
        graph();
        greedy();
        divideAndConquer();
    }

    private static void greedy() {
        huffmanCoding();
    }

    private static void huffmanCoding() {

    }

    private static void dynamicProgramming() {
        // these are seperating big problems to smaller ones and solving them check problems and algorithms for more
    }

    private static void editDistance() {

    }

    private static void matrixChainMultiplication() {

    }

    private static void knapsackProblem() {

    }

    private static void fibonacciSeries() {

    }

    private static void graph() {

    }

    private static void sorting() {
        int[] a = {55, 54, 53, 52, 51, 50, 49, 48, 47, 46};
        quickSort(a, 0, a.length-1);
        sortingMatrix();
        mergeSort();
    }

    private static void sortingMatrix() {

    }

    private static void mergeSort() {

    }

    private static void quickSort(int[] a,int low,int high) {
        // time complexity worst case : on^2 always the lowest or highest
        if (low < high) {
            int pi = quickSortPartition(a, low, high);  // this is the place where pivot is placed at its position and the index of the pivot is returned so that the next calls ignore that pivots place
            quickSort(a, low, pi - 1);
            quickSort(a, pi + 1, high);
        }
    }

    private static int quickSortPartition(int[] a, int low, int high) {
        int pivot = a[high];                // high element is choosen as pivot
        int i = low - 1;                    // this stores the lastlow value than pivots index position
        for (int j = low; j < high; j++) {  // loop is run until below high
            if (a[j] < pivot) {             // this decides, ascending or descending
                i++;                        // increase from the last low index to swap the current low making the front side of the array to be lower than the pivot always
                swapArray(a, j, i);         // swaps the new low value to next index of the previous low
            }
        }
        swapArray(a, i+1, high);          // since the last i will be the last low index, swap the pivot to the next index of the last low
        return i+1;                         // return the pivots index for next call ie. i+1 was the place where we put pivot
    }

    private static void swapArray(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void searching() {
        binarySearchAlgorithm(new int[]{10, 11, 12, 13, 14, 15, 16, 17, 55, 100}, 100);
    }

    private static int binarySearchAlgorithm(int[] sortedArray, int ele) {
        // possible only in sorted array using midpoint
        // keep on finding the mid point element and updating the left and right index until your left and right intercepts
        int li = 0, ri = sortedArray.length - 1;
        while (li <= ri) {
            int mid = (li + ri) / 2;     // mid point between two numbers
            if (sortedArray[mid] == ele) {
                return mid;     // found at index
            }
            if (ele > sortedArray[mid]) {
                li = mid + 1;   // not in the mid position so updating li to the new position so that it can go on
            } else {
                ri = mid - 1;   // not in mid position so updating ri to new position so that it can go on
            }
        }
        return -1; // not found
    }

    private static void divideAndConquer() {
        // big problems are cotegorised into smaller problem
        //merge sort
        //quick sort
    }

    private static void problemsAndAlgorithms() {
        // methods with return type makes the process end gracefully
        toUpperCaseOrLowerCase('S');
        // integers
        palindrome();       // same on reverse
        // string
        reverseString();    // string builder or palindrome method
        anagram();          // same quantity of characters even at different position
        printingDiagonalAxes();
        //array
        reverseArray();
        rotateArray();
        segregateZero();
        // map
        twoSum();
        // two dimensional array
        pyramidAndNumbers();
        twoDimensionalPattern();
        // matrix
        spiralMatrix();
        checkUpperTriangleOrLowerTriangle();
        // different complex
        differenceBetweenTwoDates();
        mazeRunBackTracking();
        lookAndSay();
        // dynamic programming
        fibonacciSeries();
        longestIncreasingSubsequenceInArray();
        knapsackProblem();
        matrixChainMultiplication();
        editDistance();
    }

    private static void segregateZero() {
        int a[] = {1, 2, 3, 4, 5, 6, 7, 0, 0, 0, 0, 0};
        int point = a.length-1;
        for (int i = point; i >= 0; i--) {
            if (a[i] != 0) {
                a[point--] = a[i];
            }
        }
        while (point >= 0) {
            a[point--] = 0;
        }
        //System.out.println(Arrays.toString(a));
    }

    private static void reverseArray() {
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int li = a.length - 1;
        for (int i = 0; i <= li / 2; i++) {     // swap until the mid point or else will swap the other half to original again
            int temp = a[i];
            a[i] = a[li - i];
            a[li - i] = temp;
        }
        //System.out.println(Arrays.toString(a));
    }

    private static void rotateArray() {
        int[] a = {1,2,3,4,5,6,7};
        int rotation = 9;
        for (int i = 1; i <= rotation; i++) {
            rotateArrayByOne(a);
        }
        //System.out.println(Arrays.toString(a));
    }

    private static void rotateArrayByOne(int[] a) {
        int temp = a[0];
        for (int i=0;i<a.length-1;i++){
            a[i]=a[i+1];
        }
        a[a.length-1]=temp;
    }

    private static void lookAndSay() {
        // 1,11,12,1121,1321
    }

    private static void mazeRunBackTracking() {

    }

    private static void spiralMatrix() {
        int count = 1;
        int size = 10;
        int max = size;
        int li = 0, ri = 0;
        int[][] a = new int[size][size];
        while (count <= (size * size)) {
            for (int i = 0; i < max; i++) {
                a[li][ri++] = count++;
            }
            ri--;
            for (int i = 0; i < max - 1; i++) {
                a[++li][ri] = count++;
            }
            for (int i = 0; i < max - 1; i++) {
                a[li][--ri] = count++;
            }
            for (int i = 0; i < max - 2; i++) {
                a[--li][ri] = count++;
            }
            ri++;
            max = max - 2;
        }
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

    }

    private static void checkUpperTriangleOrLowerTriangle() {

    }

    private static void pyramidAndNumbers() {
        /*
        *       1
        *      212
        *     32123
        *    4321234
        *   543212345
        *
        * */
        int n = 5;
        for (int r = 1; r <= n; r++) {
            for (int i = 1; i <= n - r; i++) {      // printing spaces relation with row and n
                //System.out.print(" ");
            }
            int counter = r;
            for (; counter > 1; counter--) {        // printing the decreasing order
                //System.out.print(counter);
            }
            for (; counter <= r; counter++) {       // printing the increasing order
                //System.out.print(counter);
            }
            //System.out.println();
        }
    }

    private static void twoDimensionalPattern() {
        /*
        *
        * 1  2  3  4  5
        * 16 17 18 19 6
        * 15 24 25 20 7
        * 14 23 22 21 8
        * 13 12 11 10 9
        *
        * */

    }

    private static void printingDiagonalAxes() {
        String s = "saran";
        int max = s.length() - 1;
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j <= max; j++) {
                if (i==j){
                    //System.out.print(s.charAt(i));
                } else if (max-i==j) {
                    //System.out.print(s.charAt(i));
                }else {
                    //System.out.print(" ");
                }
            }
            //System.out.println();
        }
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
        // use for loop to get the left to right and right to left simultaneously
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
