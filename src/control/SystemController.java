package control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dataaccess.Auth;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import dataaccess.User;
import view.AdminWindow;
import view.HomePage;
import view.LibrarianWindow;
import view.LoginWindow;
import view.WindowDefaults;

public class SystemController implements ControllerInterface {
	private static Auth currentAuth = null;
	AdminWindow admin;
	LibrarianWindow librarian;
	LoginWindow loginWindow;
	HomePage librarySystem;
	
	public void login(String id, String password) throws LoginException{
		DataAccess da = new DataAccessFacade();
		HashMap<String, User> map = da.readUserMap();
		if(!map.containsKey(id)) {
			throw new LoginException("ID " + id + " not found");
		}
		String passwordFound = map.get(id).getPassword();
		if(!passwordFound.equals(password)) {
			throw new LoginException("Password incorrect");
		}
		currentAuth = map.get(id).getAuthorization();
		
	}
	@Override
	public List<String> allMemberIds() {
		DataAccess da = new DataAccessFacade();
		List<String> retval = new ArrayList<>();
		retval.addAll(da.readMemberMap().keySet());
		return retval;
	}
	
	@Override
	public List<String> allBookIds() {
		DataAccess da = new DataAccessFacade();
		List<String> retval = new ArrayList<>();
		retval.addAll(da.readBooksMap().keySet());
		return retval;
	}
	@Override
	public Auth getCurrentAuth() {
	     return SystemController.currentAuth;
	
	}
	
    private static WindowDefaults[] allWindows = { 
    		LoginWindow.INSTANCE,
    		AdminWindow.INSTANCE,
    		LibrarianWindow.INSTANCE,
    };
        	
    public void hideAllWindows() {
    		
    		for(WindowDefaults frame: allWindows) {
    			frame.setVisible(false);
    			
    		}
    	}
	
}
