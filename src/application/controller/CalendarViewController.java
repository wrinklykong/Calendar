package application.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.Scanner;

import application.model.CalendarView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class CalendarViewController implements Initializable {
	

    @FXML
    private Label satTitle;

    @FXML
    private Label wedTitle;

    @FXML
    private Label monTitle;

    @FXML
    private Label friTitle;

    @FXML
    private Label tueTitle;

    @FXML
    private Label sunTitle;

    @FXML
    private GridPane calendarPane;

    @FXML
    private Label thuTitle;
    
    @FXML
    private Button loadButton;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Background set = new Background(new BackgroundFill(Color.YELLOW, new CornerRadii(2), Insets.EMPTY));
		sunTitle.setBackground(set);
		satTitle.setBackground(set);
		monTitle.setBackground(set);
		tueTitle.setBackground(set);
		wedTitle.setBackground(set);
		thuTitle.setBackground(set);
		friTitle.setBackground(set);
		
		CalendarView a = new CalendarView();
		a.loadCurrentMonth();
    	
	}
	
    @FXML
    public void loadNextMonth(ActionEvent event) {
    	
    	CalendarView a = new CalendarView();
    	a.loadCurrentMonth();
    
    }
    
}
