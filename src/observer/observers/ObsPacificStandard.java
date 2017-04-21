package observer.observers;

import javafx.scene.control.Label;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * An observer class which handles converting to the Pacific Time Zone (PST)
 */
public class ObsPacificStandard extends AbsTimeZoneObserver {

    /**
     * Constructor; Should set the time zone for the calendar object
     *
     * @param s Subject object we are listening to
     * @param z Label to display this observers information
     */
    public ObsPacificStandard(Subject s, Label z) {
        super(s, z);
    }

    @Override
    public void update() {
        DasCalendar = (Calendar) s.getValue().clone();

    // Conversions
        int hour = DasCalendar.get(Calendar.HOUR_OF_DAY) + 21;





        if(hour > 23){
            hour -= 24;
        }

        DasCalendar.set(Calendar.HOUR_OF_DAY, hour);

        timeZone = "PST";

        displayTime();

    }
}
