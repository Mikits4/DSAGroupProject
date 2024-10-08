package net.epicgroup;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Contact[] phonebook = new Contact[100];
    private static int phonebookSize = 0;

    public static void main(String[] args) {

        phonebook[phonebookSize++] = new Contact("Fredrick", "081-123-4567");
        phonebook[phonebookSize++] = new Contact("Clifford", "081-234-5678");
        phonebook[phonebookSize++] = new Contact("Jared", "081-345-6789");

        while (true) {
            System.out.println("\n1. Insert Contact\n2. Search Contact\n3. Display All Contacts\n4. Delete Contact\n5. Update Contact\n6. Exit");
            System.out.print("Choose an option: ");
            switch (scanner.nextInt()) {
                case 1 -> insertContact();
                case 2 -> searchContact();
                case 3 -> displayContacts();
                case 4 -> deleteContact();
                case 5 -> updateContact();
                case 6 -> { System.out.println("Exiting..."); return; }
                default -> System.out.println("Invalid option");
            }
            sortContacts();
        }
    }

    private static void insertContact() {
        if (phonebookSize >= phonebook.length) {
            System.out.println("Phonebook is full");
            return;
        }
        System.out.print("Enter name: ");
        String name = scanner.next();

        System.out.print("Enter number: ");
        String number = scanner.next();

        phonebook[phonebookSize++] = new Contact(name, number);
        System.out.println("Contact added");
    }

    private static void searchContact() {
        System.out.print("Enter name to search: ");
        String name = scanner.next();

        for (int i = 0; i < phonebookSize; i++) {
            if (phonebook[i].getName().equalsIgnoreCase(name)) {
                System.out.println("Found: " + phonebook[i]);
                return;
            }
        }
        System.out.println("Contact not found");
    }

    private static void displayContacts() {
        if (phonebookSize == 0) {
            System.out.println("Phonebook is empty");
            return;
        }
        for (int i = 0; i < phonebookSize; i++) {
            System.out.println(phonebook[i]);
        }
    }

    private static void deleteContact() {
        System.out.print("Enter name to delete: ");
        String name = scanner.next();

        for (int i = 0; i < phonebookSize; i++) {
            if (phonebook[i].getName().equalsIgnoreCase(name)) {
                phonebook[i] = phonebook[--phonebookSize]; // Move the last contact to the deleted spot
                System.out.println("Contact deleted");
                return;
            }
        }
        System.out.println("Contact not found");
    }

    private static void updateContact() {
        System.out.print("Enter name to update: ");
        String name = scanner.next();

        for (int i = 0; i < phonebookSize; i++) {
            if (phonebook[i].getName().equalsIgnoreCase(name)) {
                System.out.print("Enter new name: ");
                phonebook[i].setName(scanner.next());
                System.out.print("Enter new number: ");
                phonebook[i].setNumber(scanner.next());
                System.out.println("Contact updated");
                return;
            }
        }
        System.out.println("Contact not found");
    }

    private static void sortContacts() {
        for (int i = 0; i < phonebookSize - 1; i++) {
            for (int j = i + 1; j < phonebookSize; j++) {
                if (phonebook[i].getName().compareToIgnoreCase(phonebook[j].getName()) > 0) {
                    Contact temp = phonebook[i];
                    phonebook[i] = phonebook[j];
                    phonebook[j] = temp;
                }
            }
        }
        System.out.println("Contacts sorted");
    }
}

