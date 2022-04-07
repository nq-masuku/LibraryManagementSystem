package view;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import control.ControllerInterface;
import control.SystemController;


public class HomePage extends JFrame implements WindowDefaults {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ControllerInterface ci = new SystemController();
	public final static HomePage INSTANCE =new HomePage();
	JPanel mainPanel;
	JMenuBar menuBar;
    JMenu options;
    JMenuItem login, allBookIds, allMemberIds; 
    String pathToImage;
    private boolean isInitialized = false;
    
    private static WindowDefaults[] allWindows = { 
    	HomePage.INSTANCE,
		LoginWindow.INSTANCE,
		//AllMemberIdsWindow.INSTANCE,	
		//AllBookIdsWindow.INSTANCE
	};
    	
	public static void hideAllWindows() {
		
		for(WindowDefaults frame: allWindows) {
			frame.setVisible(false);
			
		}
	}
    
    
    private HomePage() {}
    
    public void init() {
    	formatContentPane();
    	setPathToImage();
    	insertSplashImage();
		
		createMenus();
		//pack();
		setSize(870,500);
		isInitialized = true;
    }
    
    private void formatContentPane() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(1,1));
		getContentPane().add(mainPanel);	
	}
    
    private void setPathToImage() {
    	String currDirectory = System.getProperty("user.dir");
    	pathToImage = currDirectory+"\\src\\view\\library0.jpg";
    }
    
    private void insertSplashImage() {
        ImageIcon image = new ImageIcon(pathToImage);
		mainPanel.add(new JLabel(image));	
    }
    private void createMenus() {
    	menuBar = new JMenuBar();
		menuBar.setBorder(BorderFactory.createRaisedBevelBorder());
		addMenuItems();
		setJMenuBar(menuBar);		
    }
    
    private void addMenuItems() {
       options = new JMenu("Login");  
 	   menuBar.add(options);
 	   
 	   login = new JMenuItem("Admin/Librarian Login");
 	   login.addActionListener(new LoginListener());
 	   options.add(login);
    }
    
    class LoginListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			LoginWindow.INSTANCE.init();
			Util.centerFrameOnDesktop(LoginWindow.INSTANCE);
			LoginWindow.INSTANCE.setVisible(true);
			
		}
    	
    }
    class AllBookIdsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			HomePage.hideAllWindows();
			//AllBookIdsWindow.INSTANCE.init();
			
			List<String> ids = ci.allBookIds();
			Collections.sort(ids);
			StringBuilder sb = new StringBuilder();
			for(String s: ids) {
				sb.append(s + "\n");
			}
			System.out.println(sb.toString());
			//AllBookIdsWindow.INSTANCE.setData(sb.toString());
			//AllBookIdsWindow.INSTANCE.pack();
			//AllBookIdsWindow.INSTANCE.setSize(660,500);
			//Util.centerFrameOnDesktop(AllBookIdsWindow.INSTANCE);
			//AllBookIdsWindow.INSTANCE.setVisible(true);
			
		}
    	
    }
    
    class AllMemberIdsListener implements ActionListener {

    	@Override
		public void actionPerformed(ActionEvent e) {
			HomePage.hideAllWindows();
			//AllMemberIdsWindow.INSTANCE.init();
			//AllMemberIdsWindow.INSTANCE.pack();
			//AllMemberIdsWindow.INSTANCE.setVisible(true);
			
			
			HomePage.hideAllWindows();
			//AllBookIdsWindow.INSTANCE.init();
			
			List<String> ids = ci.allMemberIds();
			Collections.sort(ids);
			StringBuilder sb = new StringBuilder();
			for(String s: ids) {
				sb.append(s + "\n");
			}
			System.out.println(sb.toString());
			//AllMemberIdsWindow.INSTANCE.setData(sb.toString());
			//AllMemberIdsWindow.INSTANCE.pack();
			//AllMemberIdsWindow.INSTANCE.setSize(660,500);
			//Util.centerFrameOnDesktop(AllMemberIdsWindow.INSTANCE);
			//AllMemberIdsWindow.INSTANCE.setVisible(true);
			
			
		}
    	
    }

	@Override
	public boolean isInitialized() {
		return isInitialized;
	}


	@Override
	public void isInitialized(boolean val) {
		isInitialized =val;
		
	}
	
	public static void main(String[] args) {
	      EventQueue.invokeLater(() -> 
	         {
	            HomePage.INSTANCE.setTitle("Library Management Application");
	            HomePage.INSTANCE.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            
	            HomePage.INSTANCE.init();
	            Util.centerFrameOnDesktop(HomePage.INSTANCE);
	            HomePage.INSTANCE.setVisible(true);
	         });
	   }
}
