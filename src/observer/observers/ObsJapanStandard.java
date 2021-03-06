package observer.observers;

import javafx.scene.control.Label;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class ObsJapanStandard extends AbsTimeZoneObserver{

    /**
     * Constructor
     *
     * @param s Subject object we are listening to
     * @param z Label to display this observers information
     */
    public ObsJapanStandard(Subject s, Label z) {
        super(s, z);
    }

    @Override
    public void update() {
        DasCalendar = (Calendar) s.getValue().clone();

        // Conversions
        int hour = DasCalendar.get(Calendar.HOUR_OF_DAY) + 13;

        if(hour > 23){
            hour -= 24;
        }
        DasCalendar.set(Calendar.HOUR_OF_DAY, hour);

        timeZone = "JST";

        displayTime();
    }
}
