/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardado.gui;

import com.guardado.thread.AnimalThread;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author LN710Q
 */
public class Gui extends JFrame{
    private JLabel[] labels;
    private JButton inicio;
    private JButton reinicio;
    private String[] nombre={"Canguro","Tortuga","Dragon"};
    
    public Gui(){
        super("Carrera de animales");
        initialComponents();
    }

    private void initialComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        labels=new JLabel[3];
        inicio=new JButton("Inicio");
        reinicio=new JButton("Reinicio");
        
        Container container=getContentPane();
        
        for (int i = 0; i < 3; i++) {
            labels[i]=new JLabel();
            labels[i].setIcon(new ImageIcon(getClass().getResource(nombre[i]+".gif")));
            labels[i].setBounds(10,(i*220)+10,200,200);
            container.add(labels[i]);
        }
        inicio.setBounds(10,0,100,30);
        container.add(inicio);
        
        inicio.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                AnimalThread canguro=new AnimalThread("Canguro",labels[0].getX(),labels[0].getY(),510,labels[0]);
                AnimalThread tortuga=new AnimalThread("Tortuga",labels[1].getX(),labels[1].getY(),510,labels[1]);
                AnimalThread dragon=new AnimalThread("Dragon",labels[2].getX(),labels[2].getY(),510,labels[2]);
                canguro.start();
                tortuga.start();
                dragon.start();
            }
        });
        
        reinicio.setVisible(true);
        reinicio.setBounds(575,0,100,30);
        container.add(reinicio);
        
        reinicio.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                labels[0].setBounds(10,(0*220)+10,200,200);
                labels[1].setBounds(10,(1*220)+10,200,200);
                labels[2].setBounds(10,(2*220)+10,200,200);
            }
        });
        setSize(700,650); //TAMAÑO DE VENTANA
    }
    
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
            new Gui().setVisible(true);
        }
        });
    }
}
