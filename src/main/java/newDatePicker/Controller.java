package newDatePicker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Controller {
    @FXML
    private DatePicker myDatePicker;
    @FXML
    private Label myDate;

    public void getDate(ActionEvent event){

        LocalDate localDate = myDatePicker.getValue();
        String formattedDate = localDate.format(DateTimeFormatter.ofPattern("MMM-dd-yyyy"));

        myDate.setText(formattedDate);
    }
}
