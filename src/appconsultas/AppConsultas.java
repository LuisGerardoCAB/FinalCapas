/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appconsultas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author xl3_c
 */
public class AppConsultas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       JFrame MiMarco = new MarcoAplicacion();
       MiMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       MiMarco.setVisible(true);
        
    }
    
}

class MarcoAplicacion extends JFrame{
    public JComboBox presentacion;
    private JComboBox precio;
    private JTextArea resultado;
      public MarcoAplicacion(){
          setTitle("Consultas  Easy");
          setBounds(500, 300, 400, 400);
          setLayout(new BorderLayout());
          JPanel miPanel = new JPanel();
          miPanel.setLayout(new FlowLayout());
          presentacion = new JComboBox();
          presentacion.setEditable(false);
          presentacion.addItem("Todos");
          precio = new JComboBox();
          precio.setEditable(false);
          precio.addItem("Todos");
          resultado = new JTextArea();
          resultado.setEditable(false);
          add(resultado);
          miPanel.add(presentacion);
          miPanel.add(precio);
          add(miPanel, BorderLayout.NORTH);
          add(resultado, BorderLayout.CENTER);
          JButton botonConsulta = new JButton("Consulta");
          add(botonConsulta, BorderLayout.SOUTH);
          ConsultaCombo();
          
          
          add(miPanel);
          
      }
      public void ConsultaCombo(){
        try {
            Connection MiConexion =  DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "");
            Statement MiState = MiConexion.createStatement();
            String query = "select Presentacion, PrecioCaja from productos";
            ResultSet res = MiState.executeQuery(query);
            while (res.next()) {
             presentacion.addItem(res.getString(1));
             precio.addItem(res.getString(2));
            
            }
            
            
            
        } catch  (SQLException ex) {
            Logger.getLogger(MarcoAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      
      }
      



}
