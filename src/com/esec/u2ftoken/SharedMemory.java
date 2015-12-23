package com.esec.u2ftoken;

import javacard.framework.JCSystem;

/** 
 * @author Yang Zhou 
 * @version ����ʱ�䣺2015-12-23 ����11:18:14 
 * Some transient memory which can be reused.
 */
public class SharedMemory {
	
	/**
	 * Singleton instance
	 */
	private static SharedMemory INSTANCE = null;
	
	public byte[] m32BytesApplicationSha256;
	
	public byte[] m32BytesChallengeSha256;
	
	public byte[] m32BytesUserPrivateKey;
	
	public byte[] m65BytesUserPublicKey;
	
	public byte[] m2BytesKeyHandle;
	
	public static SharedMemory getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new SharedMemory();
		}
		return INSTANCE;
	}
	
	private SharedMemory() {
		m32BytesApplicationSha256 = JCSystem.makeTransientByteArray((short) 32, JCSystem.CLEAR_ON_DESELECT);
		m32BytesChallengeSha256 = JCSystem.makeTransientByteArray((short) 32, JCSystem.CLEAR_ON_DESELECT);
		m32BytesUserPrivateKey = JCSystem.makeTransientByteArray((short) 32, JCSystem.CLEAR_ON_DESELECT);
		m65BytesUserPublicKey = JCSystem.makeTransientByteArray((short) 65, JCSystem.CLEAR_ON_DESELECT);
		m2BytesKeyHandle = JCSystem.makeTransientByteArray((short) 2, JCSystem.CLEAR_ON_DESELECT);
	}
}