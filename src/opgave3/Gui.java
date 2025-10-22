package opgave3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.*;

public class Gui extends Application {
    public final TextField txfIndskud = new TextField();
    public final TextField txfRente = new TextField();
    public final TextField txfRentetilskrivninger = new TextField();
    public final Label lblFremtidigVærdi = new Label();

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Opgave 3");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblIndskud = new Label("Indskud ");
        pane.add(lblIndskud, 1, 1);

        Label lblRente = new Label("Rente (%) ");
        pane.add(lblRente, 1, 2);

        Label lblRenteTilskrivning = new Label("Rentetilskrivninger ");
        pane.add(lblRenteTilskrivning,1,3);

        Label lblFremtidigVærdiTitel = new Label("Fremtidig værdi ");
        pane.add(lblFremtidigVærdiTitel, 1,5);


        pane.add(txfIndskud, 2,1);
        pane.add(txfRente, 2,2);
        pane.add(txfRentetilskrivninger, 2,3);
        pane.add(lblFremtidigVærdi,2,5);

        Button btnBeregn = new Button("Beregn");
        pane.add(btnBeregn, 2,4);
        btnBeregn.setOnAction(event -> this.beregnRentetilskrivning());





    }

    private void beregnRentetilskrivning() {
        double indskud = Double.parseDouble(txfIndskud.getText());
        double rente = Double.parseDouble(txfRente.getText()) / 100;
        double renteTilskrivninger = Double.parseDouble(txfRentetilskrivninger.getText());
        double fremtidigVærdi = indskud * Math.pow(1 + rente, renteTilskrivninger);

        lblFremtidigVærdi.setText(String.format("%.2f kr.", fremtidigVærdi));
    }
}
