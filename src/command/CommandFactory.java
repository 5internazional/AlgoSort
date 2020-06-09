package command;
import compare.*;
import console.Console;
import lists.DoublyLinkedList;
import lists.Listable;
import lists.SinglyLinkedList;
import data.Student;
import sort.BubbleSort;
import sort.SelectionSort;
import sort.Sortable;
import java.util.Scanner;

public class CommandFactory {
    private static Console console = new Console();
    private static Scanner scan = new Scanner(System.in);

    public void chooseListable() {
        System.out.println("Would you like to work with Singly Linked List (enter 1) or Doubly Linked List (enter 2)");
        int answer = scan.nextInt();
        if (answer == 1) {
            singlyLL();
        } else if (answer == 2) {
            doublyLL();
        } else
            System.out.println("Wrong inout");
    }
    private void doublyLL() {
        Listable<Student> s = new DoublyLinkedList<>();
        menu(s);
    }
    private void singlyLL() {
        Listable<Student> s = new SinglyLinkedList<>();
        menu(s);
    }

    public static void menu(Listable<Student> list) {
       menuView();
        int answer = 1;
        while(answer!=0){
            answer = scan.nextInt();
            switch (answer) {
                case 1:
                case 3:
                    list.add(student());
                    list.printAll();
                break;
                case 2:
                    list.addFirst(student());
                    list.printAll();
                    break;
                case 4:
                    System.out.println("Add the position");
                    int position = scan.nextInt();
                    if(position>0){
                        list.add(position-1, student());
                        list.printAll();
                    }else
                        System.out.println("Wrong position");
                break;
                case 5:
                    System.out.println(list.get(console.readInt("Which student's info would you like to know about? Type his number")-1));
                    break;
                case 6:
                    list.remove(console.readInt("Which student's info would you like to remove?")-1);
                    list.printAll();
                    break;
                case 7:
                    System.out.println(list.size());
                    break;
                case 8:
                    list.printAll();
                    break;
                case 9:
                    list.clear();
                    break;
                case 10:
                    sorting(list);
                case 0:
                    break;
                default:
                    System.out.println("Wrong input. Try again");
            }
        }
    }

    private static void menuView() {
        System.out.println("What would you like to change?");
        System.out.println("1. Add new student with information");
        System.out.println("2. Add first student");
        System.out.println("3. Add last student");
        System.out.println("4. Add new student with information at the position");
        System.out.println("5. Get information about a student");
        System.out.println("6. Delete a student from the list");
        System.out.println("7. Get number of students");
        System.out.println("8. Get all information from the list");
        System.out.println("9. Clean the list");
        System.out.println("10. Sorting by criterion");
        System.out.println("0. Exit");

    }
    private static void sorting(Listable<Student> list) {
        Sortable<Student> sorting = null;
        int answer;
            int sort = console.readInt("Which sorting do you want to use? Bubblesort (enter 1) or Selectionsort (enter 2) ");
            if (sort == 1) {
                sorting = new BubbleSort<>();
            } else if (sort == 2) {
                sorting = new SelectionSort<>();
            } else {
                System.out.println("Wrong input");
                return;
            }
            do {
                answer = console.readInt("By which criterion you want to sort the students:\n " +
                        "1. Prename; \n 2. Surname \n 3. Course \n 4. Matrikelnum \n 5. Back to menu");

                switch (answer) {
                    case 1:
                        sortAndPrint(list, sorting, new PrenameComparator());
                        break;
                    case 2:
                        sortAndPrint(list, sorting, new SurnameComparator());
                        break;
                    case 3:
                        sortAndPrint(list, sorting, new CourseComparator());
                        break;
                    case 4:
                        sortAndPrint(list, sorting, new MNComparator());
                        break;
                    case 5:
                    case 0:
                        menuView();
                        return;
                }
            }while(answer!=0);
    }
    private static void sortAndPrint(Listable<Student> list, Sortable<Student> algorithm, Comparator<Student> comparator){
        System.out.println("Sort algorithm: " + algorithm.getClass().getSimpleName() +
                "Comparator: " + comparator.getClass().getSimpleName());
        algorithm.sort(list, comparator);
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    private static Student student(){
        String prename = console.readString("Add prename");
        String surname = console.readString("Add surname");
        int course = console.readInt("Add course");
        int mn = console.readInt("Add matrikelnummer");
        Student student = new Student(surname, prename, course, mn);
        return student;
    }
}
