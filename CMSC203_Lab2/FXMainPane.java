


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	Button hello;
	Button howdy;
	Button chinese;
	Button clear;
	Button exit;
	Label label;
	TextField textField;
	Insets inset;
	
	//  declare two HBoxes
	HBox hbox1;
	HBox hbox2;
	//student Task #4:
	//  declare an instance of DataManager
	DataManager dm;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		hello = new Button("Hello");
		howdy = new Button("Howdy");
		chinese = new Button("Chinese");
		clear = new Button("Clear");
		exit = new Button("Exit");
		label = new Label("Feedback");
		textField = new TextField();
		//  instantiate the HBoxes
		hbox1 = new HBox();
		hbox2 = new HBox();
		//student Task #4:
		//  instantiate the DataManager instance
		dm = new DataManager();
		//  set margins and set alignment of the components
		inset = new Insets(0);
		HBox.setMargin(hello, inset);
		HBox.setMargin(howdy, inset);
		HBox.setMargin(chinese, inset);
		HBox.setMargin(clear, inset);
		HBox.setMargin(exit, inset);
		
		hbox1.setAlignment(Pos.CENTER);
		hbox2.setAlignment(Pos.CENTER);
	
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		hbox1.getChildren().addAll(label, textField);
		//  add the buttons to the other HBox
		hbox2.getChildren().addAll(hello, howdy, chinese, clear, exit);
		//  add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(hbox1, hbox2);
		
		hello.setOnAction(new ButtonHandler());
        howdy.setOnAction(new ButtonHandler());
        chinese.setOnAction(new ButtonHandler());
        clear.setOnAction(new ButtonHandler());
        exit.setOnAction(new ButtonHandler());
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent> {
		
		
		@Override
		public void handle(ActionEvent event) {
			if(event.getTarget() == hello) {
				textField.setText(dm.getHello());
			}
			else if (event.getTarget() == howdy) {
				textField.setText(dm.getHowdy());
			}
			else if (event.getTarget() == chinese) {
				textField.setText(dm.getChinese());
			}
			else if (event.getTarget() == clear) {
				textField.setText("");
			}
			else if (event.getTarget() == exit) {
				Platform.exit();
				System.exit(0);
			}
			
		}
		
	}
}
	
