package control;

import java.util.ArrayList;

import model.Person;
import view.MainView;

public class Controller {
    MainView view;
    ArrayList<Person> list;

    public Controller() {
        view = new MainView(this);
        list = new ArrayList<Person>();
    }

    public void printHelloWorld(){
        System.out.println("Hello World!");
    }

    public void addPerson(String name, String surname, String address, int age) {
        Person newPerson = new Person(name, surname, address, age);
        list.add(newPerson);
    }
    
    public void minAge(){
        if(list.size() <= 0) {
            System.out.println("No persons in list.");
        } else {
            int min = list.get(0).getAlter();
            for (int i = 1; i < list.size(); i++) {
                if(list.get(i).getAlter() < min) {
                    min = list.get(i).getAlter();
                }
            }
            System.out.println("The youngest person is " + min + " years old.");
        }
    }
}
