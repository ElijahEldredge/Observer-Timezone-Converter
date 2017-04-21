package test;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import observer.controllers.ObserverController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


import static org.junit.Assert.assertEquals;

/**
 * Created by Cory on 4/17/17.
 */
@RunWith( JfxTestRunner.class )
public class ObserverTests{

    TextField txtEstHours, txtEstMinutes, txtEstSeconds;
    Label lblPacific, lblBritish, lblJapan, lblIndia;
    ObserverController c;

    @Before
    public void initialize() {
        try {
            FXMLLoader loader = new FXMLLoader();
            AnchorPane root = loader.load(getClass().getResource("../observer/gfx/observer.fxml").openStream());
            Scene scene = new Scene(root);
            scene.getStylesheets().add("../observer/gfx/styles.css");

            c = loader.getController();

            VBox vbox = (VBox) root.getChildren().get(0);

            txtEstHours = (TextField) ((HBox) vbox.getChildren().get(1)).getChildren().get(0);
            txtEstMinutes = (TextField) ((HBox) vbox.getChildren().get(1)).getChildren().get(2);
            txtEstSeconds = (TextField) ((HBox) vbox.getChildren().get(1)).getChildren().get(4);

            GridPane gridbox = (GridPane) vbox.getChildren().get(2);
            lblPacific = ((Label) ((VBox) gridbox.getChildren().get(0)).getChildren().get(1));
            lblBritish = ((Label) ((VBox) gridbox.getChildren().get(1)).getChildren().get(1));
            lblJapan = ((Label) ((VBox) gridbox.getChildren().get(2)).getChildren().get(1));
            lblIndia = ((Label) ((VBox) gridbox.getChildren().get(3)).getChildren().get(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void initialTest1() {

        txtEstHours.setText("4");
        txtEstMinutes.setText("34");
        txtEstSeconds.setText("42");

        c.notifyObservers();

        assertEquals(lblPacific.getText(),"1:34:42 PST");
        assertEquals(lblBritish.getText(), "10:34:42 ECT");
        assertEquals(lblJapan.getText(), "17:34:42 JST");
        assertEquals(lblIndia.getText(), "14:04:42 IST");
    }

    @Test
    public void initialTest2() {

        txtEstHours.setText("23");
        txtEstMinutes.setText("23");
        txtEstSeconds.setText("00");

        c.notifyObservers();

        assertEquals(lblPacific.getText(),"20:23:00 PST");
        assertEquals(lblBritish.getText(), "5:23:00 ECT");
        assertEquals(lblJapan.getText(), "12:23:00 JST");
        assertEquals(lblIndia.getText(), "8:53:00 IST");
    }

    @Test
    public void initialTest3() {

        txtEstHours.setText("1");
        txtEstMinutes.setText("43");
        txtEstSeconds.setText("26");

        c.notifyObservers();

        assertEquals(lblPacific.getText(),"22:43:26 PST");
        assertEquals(lblBritish.getText(), "7:43:26 ECT");
        assertEquals(lblJapan.getText(), "14:43:26 JST");
        assertEquals(lblIndia.getText(), "11:13:26 IST");
    }
}
