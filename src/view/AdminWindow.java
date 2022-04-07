package view;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class AdminWindow extends JFrame implements WindowDefaults{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7756669974886820028L;
	public final static AdminWindow INSTANCE =new AdminWindow();
	JPanel mainPanel;
    private boolean isInitialized = false;

	public boolean isInitialized() {
		return isInitialized;
	}
	public void isInitialized(boolean val) {
		isInitialized = val;
	}
    
    private AdminWindow() {}
    
    public void init() {
    	formatContentPane();
		//pack();
		setSize(870,500);
		isInitialized = true;
    }
    
    private void formatContentPane() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(1,1));
		getContentPane().add(mainPanel);	
	}
    
}
