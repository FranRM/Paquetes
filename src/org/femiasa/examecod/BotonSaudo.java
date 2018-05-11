/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.femiasa.examecod;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import java.io.*;


@ActionID(
        category = "Bugtracking",
        id = "org.femiasa.examecod.BotonSaudo"
)
@ActionRegistration(
        iconBase = "org/femiasa/examecod/images.png",
        displayName = "#CTL_BotonSaudo"
)
@ActionReference(path = "Toolbars/File", position = 0)
@Messages("CTL_BotonSaudo=Clicka e saudareite.")
public final class BotonSaudo implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
                Runtime rt = Runtime.getRuntime();
                JOptionPane.showMessageDialog(null, "Vai a introducir os datos para o empaquetamento:" );
                
                String outdir=JOptionPane.showInputDialog("Indique o directorio onde quere que se cree o paquete.");
                String outfile=JOptionPane.showInputDialog("Indique o nome que qere que teña o paquete.");
                String srcdir=JOptionPane.showInputDialog("Indique o directorio onde se atopa o .jar.");
                String srcfiles=JOptionPane.showInputDialog("Indique o arquivo .jar.");
                String appclass=JOptionPane.showInputDialog("Indique a clase principal.");
                String name=JOptionPane.showInputDialog("Indique o nome da aplicación.");
                String title=JOptionPane.showInputDialog("Indique o titulo do paquete.");
                
                rt.exec("javapackager -deploy -native deb -outdir "+outdir+" -outfile "+outfile+" -srcdir "+srcdir+" -srcfiles "+srcfiles+" -appclass "+appclass+" -name "+name+" -title "+title);
                
                JOptionPane.showMessageDialog(null, "Fin" );
                
 
            } catch(Exception ea) {
                System.out.println(ea.toString());
                ea.printStackTrace();
            }
    }
}
