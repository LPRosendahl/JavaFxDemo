package opgave2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {
    private int number = 0;
    private Label lblNumber;
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Opgave 2");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setVgap(10);
        pane.setHgap(10);
        pane.setMinHeight(200);
        pane.setMinWidth(200);

        lblNumber = new Label(" " + number);
        pane.add(lblNumber, 3,5);

        Label lblNumberText = new Label("Nummer: ");
        pane.add(lblNumberText, 2, 5);


        Button positivtButton = new Button("+1");
        pane.add(positivtButton, 4,4, 1, 1);
        GridPane.setFillWidth(positivtButton, true);
        GridPane.setFillHeight(positivtButton, true);
        positivtButton.setOnAction(event -> this.addNumberAction());


        Button negativeButton = new Button("-1");
        pane.add(negativeButton, 4,6, 1, 1);
        GridPane.setFillWidth(negativeButton, true);
        GridPane.setFillHeight(negativeButton, true);
        negativeButton.setOnAction(event -> this.subtractNumberaction());


    }

    private void addNumberAction() {
        number++;
        lblNumber.setText(" " + number);

    }

    private void subtractNumberaction() {
        number--;
        lblNumber.setText(" " + number);

    }

}
