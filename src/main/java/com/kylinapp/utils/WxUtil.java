/** 
 * Copyright: Copyright (c)2015
 * Company: ����������Ϣ���޹�˾(jxhtxx.com) 
 */
package com.kylinapp.utils;

import java.io.UnsupportedEncodingException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.spec.InvalidParameterSpecException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import net.sf.json.JSONObject;

/**    
 * @author��QYW   
 * @since��2018��12��28������9:17:35
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: ����������Ϣ���޹�˾(jxhtxx.com) 
 */
public class WxUtil {
	public static JSONObject getUserInfo(String encryptedData, String sessionKey, String iv) {
		// �����ܵ�����

		byte[] dataByte = Base64.getDecoder().decode(encryptedData);
		// ������Կ
		byte[] keyByte = Base64.getDecoder().decode(sessionKey);
		// ƫ����
		byte[] ivByte = Base64.getDecoder().decode(iv);
		try {
			// �����Կ����16λ����ô�Ͳ���. ���if �е����ݺ���Ҫ
			int base = 16;
			if (keyByte.length % base != 0) {
				int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
				byte[] temp = new byte[groups * base];
				Arrays.fill(temp, (byte) 0);
				System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
				keyByte = temp;
			}
			// ��ʼ��
			Security.addProvider(new BouncyCastleProvider());
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
			SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
			AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
			parameters.init(new IvParameterSpec(ivByte));
			cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// ��ʼ��
			byte[] resultByte = cipher.doFinal(dataByte);
			if (null != resultByte && resultByte.length > 0) {
				String result = new String(resultByte, "UTF-8");
				return JSONObject.fromObject(result);
			}
		} catch (NoSuchAlgorithmException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (InvalidParameterSpecException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (BadPaddingException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
}
