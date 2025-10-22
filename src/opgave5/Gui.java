package opgave5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {
    private final TextField txfName = new TextField();


    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Opgave 5");
        GridPane pane = new GridPane();
        this.initContent(pane);


        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private final TextArea txaNames = new TextArea();

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        pane.setMinWidth(300);
        pane.setMinHeight(250);

        Label lblName = new Label("Name:");
        pane.add(lblName,1,1);
        pane.add(txfName,1,2);

        Button btnName = new Button("Tilføj navn");
        pane.add(btnName,1,3);
        btnName.setOnAction(actionEvent -> this.addName());
        txfName.setOnAction(actionEvent -> addName());

        pane.add(txaNames,1,4);
        txaNames.setPrefRowCount(10);
        txaNames.setPrefWidth(270);
        txaNames.setEditable(false);



    }

    private void addName() {
        String name = txfName.getText();
        txaNames.appendText(name + "\n");
        txfName.clear();
    }
}
