package opgave4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {
    public final TextField txfCelcius = new TextField();
    public final TextField txfFahrenheit = new TextField();

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Opgave 4");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblCelcius = new Label("Celcius");
        pane.add(lblCelcius, 1, 1);

        Label lblFahrenheit = new Label("Fahrenheit");
        pane.add(lblFahrenheit, 3, 1);

        pane.add(txfCelcius, 1, 2);
        pane.add(txfFahrenheit, 3, 2);

        Button btnCelciusToFahrenheit = new Button(">>");
        pane.add(btnCelciusToFahrenheit, 2, 1);
        btnCelciusToFahrenheit.setOnAction(event -> this.convertCelciusToFahrenheit());

        Button btnFahrenheitToCelcius = new Button("<<");
        pane.add(btnFahrenheitToCelcius, 2, 2);
        btnFahrenheitToCelcius.setOnAction(event -> this.convertFahrenheitToCelcius());

    }

    private void convertFahrenheitToCelcius() {
        double fahrenheit = Double.parseDouble(txfFahrenheit.getText().replace(",", "."));
        double celcius = (fahrenheit - 32) * 5 / 9;

        txfCelcius.setText(String.format("%.2f", celcius));
    }

    private void convertCelciusToFahrenheit() {
        double celcius = Double.parseDouble(txfCelcius.getText().replace(",", "."));
        double fahrenheit = (celcius * 9 / 5) + 32;

        txfFahrenheit.setText(String.format("%.2f", fahrenheit));
    }
}
