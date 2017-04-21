package observer.observers;

import javafx.scene.control.Label;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class ObsIndiaStandard extends AbsTimeZoneObserver {

    /**
     * Constructor
     *
     * @param s Subject object we are listening to
     * @param z Label to display this observers information
     */
    public ObsIndiaStandard(Subject s, Label z) {
        super(s, z);
    }

    @Override
    public void update() {
        DasCalendar = (Calendar) s.getValue().clone();

        // Conversions
        int hour = DasCalendar.get(Calendar.HOUR_OF_DAY) + 9;
        int minute = DasCalendar.get(Calendar.MINUTE) + 30;


        if(minute >= 60){
            minute -= 60;
            hour += 1;
        }

        if(hour > 23){
            hour -= 24;
        }


        DasCalendar.set(Calendar.HOUR_OF_DAY, hour);
        DasCalendar.set(Calendar.MINUTE, minute);

        timeZone = "IST";

        displayTime();
    }
}
