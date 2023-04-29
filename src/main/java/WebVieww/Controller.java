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

    private String homePage;

    private double webZoom;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        webEngine = myWebView.getEngine();
        homePage = "www.google.com";
        myTextField.setText(homePage);
        webZoom = 1.0;
        loadPage();
    }

    public void loadPage(){

        webEngine.load("http://"+myTextField.getText());
    }

    public void refreshPage(){
        webEngine.reload();
    }

    public void zoomIn(){
        webZoom+=0.25;
        myWebView.setZoom(webZoom);
    }
    public void zoomOut(){
        webZoom-=0.25;
        myWebView.setZoom(webZoom);
    }
}
