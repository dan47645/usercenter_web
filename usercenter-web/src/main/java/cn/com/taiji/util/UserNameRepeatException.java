package cn.com.taiji.util;

public class UserNameRepeatException extends RuntimeException {
	public UserNameRepeatException(String message){
		super(message);
	}
}
