package observer.observers;

import javafx.scene.control.Label;
import java.util.Calendar;

/**
 * An abstract class to encompass any kind of time zone observer
 */
public abstract class AbsTimeZoneObserver {
    protected Subject s;
    protected Label z;

    protected String timeZone;

    protected Calendar DasCalendar;

    /**
     * Constructor
     * @param s Subject object we are listening to
     * @param z Label to display this observers information
     */
    public AbsTimeZoneObserver(Subject s, Label z){
        this.s = s;
        this.z = z;

    }

    /**
     * Automatically formats and sets the time to the label associated with this observer
     */
    public void displayTime(){
        String minutesText;
        String secondsText;

        int hours = DasCalendar.get(Calendar.HOUR_OF_DAY);
        int minutes = DasCalendar.get(Calendar.MINUTE);
        int seconds = DasCalendar.get(Calendar.SECOND);

        if(minutes < 10){
            minutesText = "0" + minutes;
        }
        else{
            minutesText = "" + minutes;
        }

        if(seconds < 10){
            secondsText = "0" + seconds;
        }
        else{
            secondsText = "" + seconds;
        }

        z.setText("" + hours + ":" + minutesText + ":" + seconds + " " + timeZone);

   }

    /**
     * Updates this Observers Calendar object with the new calculated Date and Time. Should be implemented by
     * each child class.
     */
    public abstract void update();
}
