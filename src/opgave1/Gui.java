package opgave1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {
    public final TextField txfName = new TextField();
    public final TextField txfLastName = new TextField();
    public final TextField txfFullName = new TextField();

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("demo.Gui Demo 1");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(GridPane pane) {
        // enable this to show grid lines
        pane.setGridLinesVisible(false);

        //Width
        //pane.setMinWidth(600);

        //height
        //pane.setMinHeight(250);

        // set padding of the pane
        pane.setPadding(new Insets(50));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        // add a label to the pane (at col=0, row=0)
        Label lblName = new Label("Fornavn:");
        pane.add(lblName, 1, 1);

        Label lblLastName = new Label("Efternavn:");
        pane.add(lblLastName, 2, 1);

        Label lblFullName = new Label("Fulde navn:");
        pane.add(lblFullName, 1,3);

        // add a text field to the pane
        // (at col=1, row=0, overlapper 2 cols and 1 row)

        pane.add(txfName, 1, 2, 1, 1);
        pane.add(txfLastName, 2, 2, 1, 1);
        pane.add(txfFullName, 1, 4, 2, 1);


        // add a button to the pane (at col=2, row=1)
        Button btnCombine = new Button("Kombiner");
        pane.add(btnCombine, 2, 5);
        GridPane.setMargin(btnCombine, new Insets(10, 10, 0, 10));

        // connect a method to the button
        btnCombine.setOnAction(event -> this.combineAction());
    }

    //-----------------------------------------------------
    // Button actions

    private void combineAction() {
        String firstName = txfName.getText().trim();
        String lastName = txfLastName.getText().trim();
        String fullName = firstName + " " + lastName;

        txfFullName.setText(fullName);

    }

}

