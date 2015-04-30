package com.cdms.codrive.classes;

import com.parse.ParseException;
import com.parse.ParseUser;

public class User {
	
	protected ParseUser parseUser;
	
	public void setParseUser(ParseUser parseUser) {
		this.parseUser = parseUser;
	}

	public String getEmail()
	{
		return this.parseUser.getEmail();
	}
	
	//null check for Activity
	public Exception login(String username, String password)
	{
		ParseUser user = ParseUser.getCurrentUser();
		if(user!=null)
		{
			this.parseUser = user;
			return null;
		}
		try
		{
			user = ParseUser.logIn(username, password);
			this.parseUser = user;
			return null;
		} catch (ParseException e) {
			return e;
		}
	}
	
	//null check for Activity
	public Exception signUp(String username, String password)
	{
		ParseUser user = new ParseUser();
		user.setUsername(username);
		user.setPassword(password);
		try {
			user.signUp();
			this.parseUser=user;
			return null;
		} catch (ParseException e) {
			return e;
		}
	}
	
}
