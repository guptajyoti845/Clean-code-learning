package refactoringLearnings.initial;

abstract class Price {
    abstract int getPriceCode();

    abstract double getCharge(int daysRented);
}
