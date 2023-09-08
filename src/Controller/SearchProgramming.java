
package Controller;

import Common.Algorithm;
import Common.Library;
import Model.Element;
import View.Menu;


public class SearchProgramming extends Menu<String> {

    static String[] mc = {"Search", "Exit"};

    protected Library library;
    protected Algorithm algorithm;
    protected int[] array;
    protected int size_array;

    public SearchProgramming(Element element) {
        super("PROGRAMMING", mc);
        library = new Library();
        algorithm = new Algorithm();
        size_array = element.getSize_array();
        array = element.getArray();
        System.out.println("The array: ");
        library.display(array);
        //1. Enter a possitive number
        //size_array = library.getInt("Enter number of array", 1, 100);
        //2. Create array by generate random integer in range
        //array = library.createArray(size_array);
    }

    public void execute(int n) {
        switch (n) {
            case 1:              
                search();
                break;
            case 3:
                System.exit(0);
                break;
        }
    }


    public void search() {
        final String[] mcSearch = {"Linear Search", "Binary Search", "Exit"};
        class SearchMenu extends Menu<String> {

            public SearchMenu() {
                super("Search Option", mcSearch);
            }

            @Override
            public void execute(int n) {
                
                
                int value = library.getInt("\nEnter number to find: ", 1, 100);
                switch (n) {
                    case 1:
                        library.display(array);
                        int res=algorithm.linearSearch(array, value);
                        if (res == -1) System.out.println("Not found");
                        else System.out.println("The target: "+value+ " is found at index: "+res);
                        break;
                case 2:
                        System.out.println("Sorted array: ");
                        algorithm.buddleSort(array);
                        library.display(array);
                        int result=algorithm.binarySearch(array, value);
                        if (result == -1) System.out.println("Not found");
                        else System.out.println("The target: "+value+ " is found at index: "+result);
                        break;
                    case 3:
                        System.exit(0);
                        break;
                }
            }
        }
        SearchMenu sm = new SearchMenu();
        sm.run();
    }
}
