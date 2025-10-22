package opgave6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Gui extends Application {

    private ListView<Car> carsList;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Opgave 6");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setVgap(10);
        pane.setHgap(10);

        carsList = new ListView<Car>();
        pane.add(carsList,0,0);


        Button btnAddCar = new Button("Tilføj bil");
        pane.add(btnAddCar,0,1);
        btnAddCar.setOnAction(actionEvent -> {
            Stage stage2 = new Stage();
            stage2.setTitle("Opret ny bil");


            GridPane pane2 = new GridPane();
            pane2.setPadding(new Insets(20));
            pane2.setVgap(10);
            pane2.setHgap(10);

            Scene scene2 = new Scene(pane2, 300, 200);
            stage2.setScene(scene2);
            stage2.show();

            Label lblMærke = new Label("Mærke");
            Label lblModel = new Label("Model");
            Label lblElektrisk = new Label("Elektrisk");
            Label lblPrisPrDag = new Label("Pris per dag.");


            pane2.add(lblMærke,0,0);
            pane2.add(lblModel,0,1);
            pane2.add(lblElektrisk,0,2);
            pane2.add(lblPrisPrDag,0,3);

            ComboBox coboMærke = new ComboBox();
            coboMærke.getItems().addAll("Audi", "Mercedes", "BMW", "Ford", "Toyota", "Mitsubishi");
            TextField txfModel = new TextField();
            CheckBox cbElectric = new CheckBox();
            TextField txfPrisPrDag = new TextField();

            pane2.add(coboMærke, 1,0);
            pane2.add(txfModel,1,1);
            pane2.add(cbElectric,1,2);
            pane2.add(txfPrisPrDag,1,3);

            Button createCarButton = new Button("Opret");
            pane2.add(createCarButton,1,4);
            createCarButton.setOnAction(actionEvent2 -> {
                String mærke = (String) coboMærke.getValue();
                String model = txfModel.getText();
                boolean elektrisk = cbElectric.isSelected();
                double prisPrDag = Double.parseDouble(txfPrisPrDag.getText());
                Car car = new Car(mærke, model, elektrisk, prisPrDag);

                carsList.getItems().add(car);

                ((Stage) (((Button) actionEvent2.getSource()).getScene().getWindow())).close();
            });

        });

    }
}
