import java.util.*;
class Contact {
    private String name, phone, email;
    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
    public String getName() {
        return name; 
    }
    public void setPhone(String phone) { 
        this.phone = phone; 
    }
    public void setEmail(String email) {
         this.email = email;
         }
    @Override
    public String toString() {
        return "Name: " + name + " | Phone: " + phone + " | Email: " + email;
    }
}

class ContactManager {
    private List<Contact> list = new ArrayList<>();
    public void addContact(Contact c) {
        list.add(c);
        System.out.println("Contact added successfully!");
    }
    public void viewAllContacts() {
        if (list.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }
        for (Contact c : list) System.out.println(c);
    }
    public void searchContact(String name) {
        for (Contact c : list) {
            if (c.getName().equalsIgnoreCase(name)) {
                System.out.println("Contact Found: " + c);
                return;
            }
        }
        System.out.println("Contact not found.");
    }
    public void updateContact(String name, Scanner sc) {
        for (Contact c : list) {
            if (c.getName().equalsIgnoreCase(name)) {
                System.out.print("Enter New Phone: ");
                c.setPhone(sc.nextLine());
                System.out.print("Enter New Email: ");
                c.setEmail(sc.nextLine());
                System.out.println("Contact updated successfully!");
                return;
            }
        }
        System.out.println("Contact not found.");
    }
    public void deleteContact(String name) {
        for (Contact c : list) {
            if (c.getName().equalsIgnoreCase(name)) {
                list.remove(c);
                System.out.println("Contact deleted successfully!");
                return;
            }
        }
        System.out.println("Contact not found.");
    }
}

public class Main {
    public static void main(String[] args) {
        ContactManager cm = new ContactManager();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.print("\n1.Add 2.View 3.Search 4.Update 5.Delete 6.Exit\nEnter choice: ");
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter numbers only.");
                sc.next();
                continue;
            }
            choice = sc.nextInt();
            sc.nextLine();
            
            if (choice == 1) {
                System.out.print("Name: "); String n = sc.nextLine();
                System.out.print("Phone: "); String p = sc.nextLine();
                System.out.print("Email: "); String e = sc.nextLine();
                cm.addContact(new Contact(n, p, e));
            } else if (choice == 2) {
                cm.viewAllContacts();
            } else if (choice == 3) {
                System.out.print("Name: "); cm.searchContact(sc.nextLine());
            } else if (choice == 4) {
                System.out.print("Name: "); cm.updateContact(sc.nextLine(), sc);
            } else if (choice == 5) {
                System.out.print("Name: "); cm.deleteContact(sc.nextLine());
            } else if (choice == 6) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }
}
