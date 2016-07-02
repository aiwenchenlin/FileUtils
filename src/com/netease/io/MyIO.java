package com.netease.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import sun.print.resources.serviceui;

public class MyIO {

	public static void main(String[] args) {

		/*
		 * // 1.��ȡһ�����ļ� File inputFile = doFile("D:\\softinfo.xml");
		 * 
		 * // 2.����һ�����ļ� File outputFile = doFile("D:\\newtext.txt");
		 * 
		 * // 3.��ʼ����ȡ�����ļ�д�뵽�µ��ļ��� byte[] readSize = new byte[1024]; read2write(inputFile,
		 * outputFile, readSize);
		 */

		doFile("D:/aaa/bbb/ccc", "ddd.txt");
	}

	/**
	 * ��ȡ�ļ����������򴴽�
	 * 
	 * @param pathname
	 * @return
	 */
	private static File doFile(String path, String fileName) {

		File file = new File(path);
		boolean isExist = file.exists();
		if (!isExist) {
			file.mkdirs();
		}
		try {
			boolean createNewFile = new File(file, fileName).createNewFile();
			System.out.println(createNewFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}

	/**
	 * ��ȡ�ļ�д�뵽ָ���ļ�
	 * 
	 * @param inputFile
	 * @param outputFile
	 * @param b
	 * @throws Exception
	 */
	private static void read2write(File inputFile, File outputFile, byte[] b) {

		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(inputFile);
			out = new FileOutputStream(outputFile);
			int readByte;
			while ((readByte = in.read(b)) != -1) {
				out.write(b);
			}
		} catch (Exception e) {

		} finally {
			release(in, out);
		}

	}

	/**
	 * �ͷ���Դ
	 * 
	 * @param in
	 * @param out
	 */
	private static void release(InputStream in, OutputStream out) {
		try {
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ɾ���ļ�
	 * @param file
	 * @return
	 */
	private static boolean delete(File file) {

		boolean isExists = file.exists();
		if (!isExists) {
			return false;
		}
		boolean isDelete = file.delete();
		return isDelete;
	}
}
