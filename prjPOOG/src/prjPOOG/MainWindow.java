package prjPOOG;

import java.awt.*;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainWindow extends JFrame implements ActionListener{
	private MenuItem m11,m12,m13,m14,m15,m16,m21;
	private Menu m1,m2;
	private MenuBar mb;
	
	public MainWindow(String title){
		super (title);
		setSize(800, 450);
		setLocationRelativeTo(null);//centra la finestra,indipendentemente dal monitor che si sta usando
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		m1 = new Menu ("File");
		m2 = new Menu ("Help");
		m11 = new MenuItem ("Nuova Squadra");
		m12 = new MenuItem ("Modifica Squadra");
		m13 = new MenuItem ("Cancella Squadra");
		m14 = new MenuItem ("Carica Squadre");
		m15 = new MenuItem ("Nuovo Torneo");
		m16 = new MenuItem ("Popola Torneo");
		m21 = new MenuItem ("Documentazione");
		m1.add(m11);
		m1.add(m12);
		m1.add(m13);
		m1.add(m14);
		m1.addSeparator();
		m1.add(m15);
		m1.add(m16);
		m2.add(m21);
		mb = new MenuBar();
		mb.add(m1);
		mb.add(m2);
		this.setMenuBar(mb);
		
		m11.addActionListener(this);
		m12.addActionListener(this);
		m13.addActionListener(this);
		m14.addActionListener(this);
		m15.addActionListener(this);
		m16.addActionListener(this);
		m21.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand().equals("Nuova Squadra")){
			System.out.println("Inserisco");
		}
		if (e.getActionCommand().equals("Modifica Squadra"))
			System.out.println("Modifico");
		
		if (e.getActionCommand().equals("Cancella Squadra"))
			System.out.println("Cancello");
		
		if (e.getActionCommand().equals("Carica Squadre"))
			System.out.println("Carico");
		
		if (e.getActionCommand().equals("Nuovo Torneo"))
			System.out.println("Inserisco torneo");
		
		if (e.getActionCommand().equals("Popola Torneo"))
			System.out.println("Popolo il torneo");
		
		if (e.getActionCommand().equals("Documentazione"))
			System.out.println("Presento la documentazione");
	}
	
}
