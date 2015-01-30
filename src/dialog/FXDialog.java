/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dialog;

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
public class FXDialog {
    
    /** 
     * Present a simple dialog box with message and OK box.
     * Optionally add a cancel button and a details field.
     * Calling showAndHide() returns a boolean value of 
     * true if OK is pressed, false otherwise
     */
    
    private Stage stage;
    private boolean okPressed;
    private GridPane grid;
    private HBox buttonArea;
 
    private Label msgLabel, detLabel;
    
    public FXDialog() {
        // Setup general stage and main grid
        msgLabel = detLabel = null;
        stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        
        // Add the OK button (it's a default)
        buttonArea = new HBox(10);
        Button okBtn = new Button("OK");
        okBtn.setOnAction(event -> {okPressed = true; stage.hide();});
        buttonArea.getChildren().add(okBtn);
        grid.add(buttonArea, 1, 2);
        
        //ImageView imageView = new ImageView();
        //grid.add(imageView, 0, 0);
        
        // Add a 50 width pane for spacing and also as we plan on adding an image at 0,0
        // some time in the future
        Pane pane=new Pane();
        pane.setMinWidth(50);
        grid.add(pane, 0 ,1);
        
        stage.setScene(new Scene(grid, 250, 100));
        okPressed = false;
    }
    
    public FXDialog(String message) {
        this();
        setMessage(message);
    }
    
    public FXDialog setMessage(String what)
    {
        if (msgLabel == null) {
            msgLabel = new Label(what);
            grid.add(msgLabel, 1, 0);
        }
        else
            msgLabel.setText(what);
        return this;
    }
    
    public FXDialog setDetail(String what) {
        if (detLabel == null) {
            detLabel = new Label(what);
            grid.add(detLabel, 1, 1);
        }
        else
            detLabel.setText(what);
        return this;
    }
    
    public FXDialog setTitle(String title)
    {
        stage.setTitle(title);
        return this;
    }
    
    public FXDialog addCancel() {
        Button cancelBtn = new Button("Cancel");
        cancelBtn.setOnAction(event -> stage.hide());
        buttonArea.getChildren().add(cancelBtn);
        return this;
    }
            
    
    public boolean showAndWait()
    {
        stage.showAndWait();
        return okPressed;
    }
}
