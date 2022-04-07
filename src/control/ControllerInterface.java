package control;

import java.util.List;
import dataaccess.Auth;

public interface ControllerInterface {
	public void login(String id, String password) throws LoginException;
	public List<String> allMemberIds();
	public List<String> allBookIds();
	public Auth getCurrentAuth();
	public void hideAllWindows();
	
}
