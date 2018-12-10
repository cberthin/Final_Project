package pkgApp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {

		
	private RetirementApp mainApp = null;
	
	@FXML
	private Label lblSaveEachMonth;
	
	@FXML
	private TextField txtYearsToWork;
	
	@FXML
	private TextField txtAnnualReturn1;
	
	@FXML
	private Label lblWhatYouNeedSaved;
	
	@FXML
	private TextField txtYearsRetired;
	
	@FXML
	private TextField txtAnnualReturn2;
	
	@FXML
	private TextField txtRequiredIncome;
	
	@FXML
	private TextField txtMonthlySSI;
	

	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}
	
	@FXML
	public void btnClear(ActionEvent event) {
		System.out.println("Clear pressed");
		lblSaveEachMonth.setText("");
		lblWhatYouNeedSaved.setText("");
		
		txtAnnualReturn1.setText("");
		txtYearsToWork.setText("");
		txtYearsRetired.setText("");
		txtAnnualReturn2.setText("");
		txtRequiredIncome.setText("");
		txtMonthlySSI.setText("");
		
		//	TODO: Clear all the text inputs
	}
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		
		//try {
			double YearsToWork=Double.parseDouble(txtYearsToWork.getText());
			double annualReturn1=Double.parseDouble(txtAnnualReturn1.getText());
			double annualReturn2=Double.parseDouble(txtAnnualReturn2.getText());
			double requiredIncome=Double.parseDouble(txtRequiredIncome.getText());
			double monthlySSI=Double.parseDouble(txtMonthlySSI.getText());
			double yearsRetired=Double.parseDouble(txtYearsRetired.getText());
		//}
		
		//catch(NumberFormatException e) {
			
		//}
		
		
		Retirement rtm=new Retirement((int)YearsToWork, annualReturn1, (int)yearsRetired, annualReturn2,
				requiredIncome, monthlySSI);
		
		//String p1=Double.toString(rtm.TotalAmountSaved());
		//String p2=Double.toString(rtm.AmountToSave());
		
		String p1=String.format("%.2f", rtm.TotalAmountSaved());
		String p2=String.format("%.2f", rtm.AmountToSave());
		
		lblSaveEachMonth.setText(p2.toString());
		lblWhatYouNeedSaved.setText(p1);
		//	TODO: Call AmountToSave and TotalAmountSaved and populate 
	}

		
}
