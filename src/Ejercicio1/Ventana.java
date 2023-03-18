
package Ejercicio1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Ventana extends JFrame{
    private JPanel panel;
    private JLabel etiqueta;
    private JButton boton;
    private int contador = 0;
    
    public Ventana(){
        setTitle("Contabilizador de clicks");
        setLocationRelativeTo(null);
        setSize(400, 400);
        
        iniciarComponentes();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void iniciarComponentes(){
        panel();
        etiquetaClicks();
        boton();
    }
    
    public void panel(){
        panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
    }
    
    public void etiquetaClicks(){
       etiqueta = new JLabel(); 
       etiqueta.setBounds(0, 50, 400, 60);
       etiqueta.setText("Pulsa el boton");
       etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
       etiqueta.setFont(new Font("arial", 3, 20));
       panel.add(etiqueta);
    }
    
    public void boton(){
        boton = new JButton();
        boton.setBounds(110, 250, 180, 40);
        boton.setText("Pulsa Aqui");
        boton.setFont(new Font("arial", 3, 20));
        panel.add(boton);
        
        detectorDeClicks(); //Se le agrega el evento de accion de la pulsacion de clicks
    }
    
    public void detectorDeClicks(){
        ActionListener detectorDeClicks = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            contador++;
            if(contador == 1){
                etiqueta.setText("¡Has pulsado 1 vez!");
            }
            else{
                etiqueta.setText("¡Has pulsado "+contador+" veces!");
            }
            }       
        };
        boton.addActionListener(detectorDeClicks);
    }
}
