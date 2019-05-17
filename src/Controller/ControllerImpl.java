package Controller;

import Entity.Patisserie;

import java.io.File;
import java.util.ArrayList;

public interface  ControllerImpl {

     void save(String xmlFilePath);
     void save(File xmlFile);
     ArrayList<?> read();
     ArrayList<Patisserie> getPatiserie();

}
