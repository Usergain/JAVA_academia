package ch.makery.address.view;

import java.io.File;
import ch.makery.address.MainApp;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;

public class RootLayoutController {
	//Reference to the main application
	private MainApp mainApp;
	/**
	 * Is called y the main application to five a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp=mainApp;
	}
	
	/**
	 * Creates an empty address book.
	 */
	@FXML
	private void handleNew() {
		mainApp.getPersonData().clear();	
		mainApp.setPersonFilePath(null);
	}
	
	/**
	 * Opens a FileChooser to let the user select an address book to load.
	 */
	@FXML
	private void handleOpen(){
		FileChooser fileChooser=new FileChooser();
		
		//Set extension filter
		FileChooser.ExtensionFilter extFilter=new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);
		
		//Show save file dialog
		File file=fileChooser.showOpenDialog(mainApp.getPrimaryStage());
		
		if(file !=null) {
			mainApp.loadPersonDataFromFile(file);
		}
		
	}
	
	/**
	 * Save the file to the person file that is currently open. If there is no 
	 * open file the "save as" dialog is shown
 	 */
	@FXML
	private void handleSave() {
		File personFile = mainApp.getPersonFilePath();
		if (personFile != null) {
			mainApp.loadPersonDataFromFile(personFile);
		} else {
			handleSaveAs();
		}

	}
	
	/**
	 * Opens a FileChooser to let the user select a file to save to.
 	 */
	@FXML
	private void handleSaveAs() {
		FileChooser fileChooser = new FileChooser();

		// Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);

		// Show save file dialog
		File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());

		if (file != null) {
			// Make sure it has the correct extension
			if (!file.getPath().endsWith(".xml")) {
				file = new File(file.getPath() + ".xml");
			}
			mainApp.savePersonFilePath(file);
		}

	}
	
	/**
	 * Opens an about dialog.
	 */
	@FXML
	private void handleAbout() {
		
	}
	
	/**
	 * Closes the application.
	 */
	@FXML
	private void handleExit() {
		System.exit(0);
	}
		
}
