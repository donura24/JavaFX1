package WebVieww;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private WebView myWebView;

    @FXML
    private TextField myTextField;

    private WebEngine webEngine;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        webEngine = myWebView.getEngine();
        loadPage();
    }

    public void loadPage(){

        webEngine.load("http://"+myTextField.getText());
    }
}
