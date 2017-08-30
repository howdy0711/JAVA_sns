package death;

import java.io.IOException;
import java.net.*;
public class Logout {
	Socket chat;
	public Logout(Socket chat)
	{
		this.chat = chat;
		
		logout();
		
	}
	public void logout()
	{
		try {
			chat.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
