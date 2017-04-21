package observer.observers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * The subject which keeps track of the time zone data we are interested with. Will notify any of its
 * observers when something changes with its value.
 */
public class Subject {
    private Calendar calendar;
    private List<AbsTimeZoneObserver> observerList = new ArrayList<AbsTimeZoneObserver>();

    /**
     * Accessor for the value field
     * @return The current value of the subject
     */
    public Calendar getValue(){
        return calendar;
    }

    /**
     * Setter for the value field
     * @param value New value to propagate to clients
     */
    public void setValue(Calendar value){
        this.calendar = value;
        notifyObservers();
    }

    /**
     * Adds a new observer client to the list of observers for this value
     * @param observer An instance of an observer
     */
    public void attachObserver(AbsTimeZoneObserver observer){
        observerList.add(observer);
    }

    /**
     * Calls the update function to tell each observer this subject's value
     * has changed so they need to update.
     */
    public void notifyObservers(){
        for(AbsTimeZoneObserver obs : observerList) {
            obs.update();
        }
    }
}
