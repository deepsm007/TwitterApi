package com.rave.socialmedia;

import java.io.Serializable;
/**
 * class use to store user's twitter authentication details.
 * @author Deep.Mistry
 *
 */
public class UserTwitterCredentials implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8827647418588928904L;
	private String consumerKey;
	private String consumerSecret;
	private String accessToken;
	private String accessSecret;
	private String userId;
	private String screenName;

	/**
	 * @return the consumerKey
	 */
	public String getConsumerKey() {
		return consumerKey;
	}

	/**
	 * @return the consumerSecret
	 */
	public String getConsumerSecret() {
		return consumerSecret;
	}

	/**
	 * @return the accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * @return the accessSecret
	 */
	public String getAccessSecret() {
		return accessSecret;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @return the screenName
	 */
	public String getScreenName() {
		return screenName;
	}

	/**
	 * @param consumerKey
	 *            the consumerKey to set
	 */
	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}

	/**
	 * @param consumerSecret
	 *            the consumerSecret to set
	 */
	public void setConsumerSecret(String consumerSecret) {
		this.consumerSecret = consumerSecret;
	}

	/**
	 * @param accessToken
	 *            the accessToken to set
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * @param accessSecret
	 *            the accessSecret to set
	 */
	public void setAccessSecret(String accessSecret) {
		this.accessSecret = accessSecret;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @param screenName
	 *            the screenName to set
	 */
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
}
