package observer.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import observer.observers.*;

import java.util.Calendar;

/**
 * Controller object which will initialize what kind of observers are listening to the subject (ie the Eastern Time
 * Zone) and notify observers of updates when something changes in the EST fields.
 */
public class ObserverController {

    @FXML
    Label lblBritish;
    @FXML
    Label lblPacific;
    @FXML
    Label lblJapan;
    @FXML
    Label lblIndia;
    @FXML
    TextField txtEstHours;
    @FXML
    TextField txtEstMinutes;
    @FXML
    TextField txtEstSeconds;

    private Subject subject;

    public void initialize(){
        subject = new Subject();
        subject.attachObserver(new ObsBritishStandard(subject, lblBritish));
        subject.attachObserver(new ObsIndiaStandard(subject, lblIndia));
        subject.attachObserver(new ObsJapanStandard(subject, lblJapan));
        subject.attachObserver(new ObsPacificStandard(subject, lblPacific));
    }


    /**
     * Action function for the textfields associated with the Eastern Time Zone. Will set the value of the subject
     * inherently notifying all of its observers.
     */
    public void notifyObservers() throws NumberFormatException{
        Calendar UpperCaseCalendar = Calendar.getInstance();
        UpperCaseCalendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(txtEstHours.getText()));
        UpperCaseCalendar.set(Calendar.MINUTE, Integer.parseInt(txtEstMinutes.getText()));
        UpperCaseCalendar.set(Calendar.SECOND, Integer.parseInt(txtEstSeconds.getText()));
        subject.setValue(UpperCaseCalendar);
        subject.notifyObservers();
    }
}
