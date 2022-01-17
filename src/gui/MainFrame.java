package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import model.StudentDB;

public class MainFrame extends JFrame{
	
	private static MainFrame instance = null;
	private ResourceBundle resourceBundle;
	private MyMenuBar mb;
	private MyToolBar tb;
	private MyTabPane tp;
	private MyStatusBar sb;
	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
			instance.initGui();
		}
		return instance;
	}
	public MainFrame() {
		//Locale.setDefault(new Locale("en", "US"));
		Locale.setDefault(new Locale("sr", "RS"));
		resourceBundle = ResourceBundle.getBundle("gui.MessageResources.MessageResources", Locale.getDefault());
	}
	private void initGui(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = kit.getScreenSize();
		int sHeight = d.height;
		int sWidth = d.width;
		setSize(3*sWidth/4,3*sHeight/4);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Studenska služba");
		
		mb = new MyMenuBar();
		tb = new MyToolBar();
		this.setJMenuBar(mb);
		
		add(tb, BorderLayout.NORTH);
		
		tp = new MyTabPane();
		add(tp,BorderLayout.CENTER);
		
		
		sb = new MyStatusBar(this);
		setVisible(true);
		
		UIManager.put("OptionPane.yesButtonText", resourceBundle.getObject("yesOption"));
		UIManager.put("OptionPane.noButtonText", resourceBundle.getObject("noOption"));
		UIManager.put("OptionPane.okButtonText", resourceBundle.getObject("okOption"));
		UIManager.put("OptionPane.cancelButtonText", resourceBundle.getObject("cancelOption"));
		
	}
	public void changeLanguage() {

		resourceBundle = ResourceBundle.getBundle("gui.MessageResources.MessageResources", Locale.getDefault());
		setTitle(resourceBundle.getString("titleApp"));
		mb.initComponents();
		tb.initComponents();
		MyTabbedPane.getInstance().initComponents();
		sb.initComponents();
		
		UIManager.put("OptionPane.yesButtonText", resourceBundle.getObject("yesOption"));
		UIManager.put("OptionPane.noButtonText", resourceBundle.getObject("noOption"));
		UIManager.put("OptionPane.okButtonText", resourceBundle.getObject("okOption"));
		UIManager.put("OptionPane.cancelButtonText", resourceBundle.getObject("cancelOption"));
	}
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

}
