package be.ehb.multec;

public interface Subject {

    void addObserver(Observer observer);
    void removeObserver (Observer observer);
    void updateObservers (Object observer);

}
