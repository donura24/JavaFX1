package TreeViews;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TreeView<String> myTreeView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        TreeItem<String> rootItem = new TreeItem<>("Files");
        TreeItem<String> branchItem1 = new TreeItem<>("Videos");
        TreeItem<String> branchItem2 = new TreeItem<>("Pictures");
        TreeItem<String> branchItem3 = new TreeItem<>("Music");

        TreeItem<String> leafItem1 = new TreeItem<>("Video1");
        TreeItem<String> leafItem2 = new TreeItem<>("Music1");
        TreeItem<String> leafItem3 = new TreeItem<>("Picture1");

        branchItem1.getChildren().addAll(leafItem1);
        branchItem2.getChildren().addAll(leafItem2);
        branchItem3.getChildren().addAll(leafItem3);

        rootItem.getChildren().addAll(branchItem1, branchItem2, branchItem3);


        myTreeView.setRoot(rootItem);
    }

    public void selectItem() {

        TreeItem<String> item = myTreeView.getSelectionModel().getSelectedItem();

    }


}
