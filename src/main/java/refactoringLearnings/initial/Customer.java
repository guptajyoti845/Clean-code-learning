package refactoringLearnings.initial;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    }


    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }


    public String HTMLStatement() {
        Enumeration rentals = _rentals.elements();
        String result = "<H1>Rentals for <EM>\" + getName() + \"</EM></\n" +
                "H1><P> \n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            //show figures
            result += each.getMovie().getTitle() + String.valueOf(each.getCharge());
        }
        //add footer lines
        result += "<P>You owe <EM>\" + String.valueOf(getTotalCharge()) +\"</EM><P> \n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints())
                +
                " frequent renter points";
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

    private int getTotalCharge() {
        int result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

}
