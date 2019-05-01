package sample;

import com.sun.istack.internal.NotNull;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class loginController {

    @FXML
    TextField usernameText;
    @FXML
    TextField passwordText;
    public void adminOnAction(ActionEvent actionEvent) throws Exception {

        if(adminLogin(usernameText.getText(),passwordText.getText())) {
            ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Pastane Yönetim Sistemi");

            primaryStage.setScene(new Scene(root, 600, 400));

            primaryStage.setResizable(false);
            primaryStage.show();
        }
    }
    public void personelOnAction(ActionEvent actionEvent) throws Exception {
        if(personelLogin(usernameText.getText(),passwordText.getText())){
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("personel.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Pastane Yönetim Sistemi Icerik Menusu ");

        primaryStage.setScene(new Scene(root, 600, 400));

        primaryStage.setResizable(false);
        primaryStage.show();}
    }
    public boolean personelLogin(String username,String password){

        if (username.compareToIgnoreCase("firat")==0){
            if(password.compareTo("1234")==0)
                return true;
        }
        return  false;
    }
    public boolean adminLogin(String username, String password){

        if (username.compareToIgnoreCase("hilal")==0){
            if(password.compareTo("1234")==0)
                return true;
        }
        return  false;
    }
}
