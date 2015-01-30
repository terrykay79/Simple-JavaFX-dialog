/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dialog;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author tezk
 */
public class Dialog extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        while (true) {
            FXDialog d = new FXDialog();
            d.setMessage("Click ok\nor close me!");
            if (d.showAndWait())
                new FXDialog("You pressed ok!").showAndWait();
            else
                new FXDialog("Huh? Close?").addCancel().setTitle("New title").showAndWait();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
