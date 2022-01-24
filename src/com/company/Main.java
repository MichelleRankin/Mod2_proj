package com.company;


import java.util.*;


public class Main {
    public String Company;
    public int Sales;
    public int Price;
    public String Item;
    public String Nickname;


    Main(String Company, int Sales, int Price, String Item, String Nickname){
        this.Company = Company;
        this.Sales = Sales;
        this.Price = Price;
        this.Item = Item;
        this.Nickname = Nickname;

    }

    public int getSales(){return Sales;}
    public int getPrice(){return Price;}

    public String getCompany() {
        return Company;
    }
    public String getItem(){
        return Item;
    }
    public String getNickname(){
        return Nickname;
    }


    public String toString(){return "Company: "+Company +
            " / Sales: "+Sales  +
            " / Price: "+Price +
            " / Items Sold: "+ Item +
            " / Nickname: "+ Nickname;}


    public static void main(String[] args) {
        List<Main> L = new ArrayList<Main>();
        Scanner Num = new Scanner(System.in);
        Scanner Let = new Scanner(System.in);
        String character;
        do{
            System.out.println("ADD a Company");
            System.out.println("DISPLAY a Company");
            System.out.println("SEARCH for a Company");
            System.out.println("DELETE a Company");
            System.out.println("UPDATE a Company");
            System.out.println("QUIT");
            System.out.print("What would you like to do? > ");
            character = Let.nextLine();


            switch(character) {
                case "ADD":
                    System.out.print("Enter the Company Name: ");
                    String name = Let.nextLine();
                    System.out.print("Enter their Sales: ");
                    int AmountOfSales = Num.nextInt();
                    System.out.print("Enter their Prices: ");
                    int Cost = Num.nextInt();
                    System.out.print("What is Sold at this Company: ");
                    String item = Let.nextLine();
                    System.out.print("What is a Common Nickname for the Company: ");
                    String Nickname = Let.nextLine();


                    L.add(new Main(name, AmountOfSales, Cost, item, Nickname));
                    break;
                case "DISPLAY":
                    System.out.println("-------------------------------");
                    Iterator<Main> i = L.iterator();
                    while (i.hasNext()) {
                        Main n = i.next();
                        System.out.println(n);

                    }
                    System.out.println("-------------------------------");

                    break;
                case "SEARCH":
                    boolean found = false;

                    System.out.println("-------------------------------");
                    System.out.print("Enter Company Name or Nickname: ");
                    name = Let.nextLine();
                    i = L.iterator();
                    while (i.hasNext()) {
                        Main n = i.next();
                        if (n.getCompany().equals(name) || n.getNickname().equals(name)) {
                            System.out.println(n);
                            found = true;
                        }
                    }
                        if (!found) {
                            Main n = i.next();

                            System.out.println(n);

                        }
                    System.out.println("-------------------------------");
                    break;
                case "DELETE":
                    found = false;
                    System.out.print("Enter Company name or Nickname to remove them: ");
                    name = Let.nextLine();
                    System.out.println("-------------------------------");

                    i = L.iterator();
                    while (i.hasNext()) {
                        Main n = i.next();
                        if (n.getCompany().equals(name) || n.getNickname().equals(name)) {
                            i.remove();
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Record not found, please try again unless already deleted.");

                    } else {
                        System.out.println("Record Removed Successfully");
                    }
                    System.out.println("-------------------------------");
                    break;
                case "UPDATE":
                    found = false;
                    System.out.println("Enter Company name or nickname to update our records: ");
                    name = Let.nextLine();
                    System.out.println("-------------------------------");
                    ListIterator<Main> li = L.listIterator();
                    while (li.hasNext()) {
                        Main n = li.next();
                        if (n.getCompany().equals(name) || n.getNickname().equals(name)) {
                            System.out.print("Enter new Company Name: ");
                            name = Let.nextLine();
                            System.out.print("Enter their current Sales: ");
                            AmountOfSales = Num.nextInt();
                            System.out.print("Enter their current Prices: ");
                            Cost = Num.nextInt();
                            System.out.print("What is now Sold at this Company: ");
                            item = Let.nextLine();
                            System.out.print("What is a new Common Nickname for the Company: ");
                            Nickname = Let.nextLine();


                            li.set(new Main(name, AmountOfSales, Cost, item, Nickname));
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Record Not Found, or already removed.");

                    } else {
                        System.out.println("Record updated successfully");
                    }
                    System.out.println("-------------------------------");
                    break;

            }



        }while(!character.equals("QUIT"));
    }
}
