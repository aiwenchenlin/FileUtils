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
		 * // 1.读取一个新文件 File inputFile = doFile("D:\\softinfo.xml");
		 * 
		 * // 2.创建一个新文件 File outputFile = doFile("D:\\newtext.txt");
		 * 
		 * // 3.开始将读取到的文件写入到新的文件中 byte[] readSize = new byte[1024]; read2write(inputFile,
		 * outputFile, readSize);
		 */

		doFile("D:/aaa/bbb/ccc", "ddd.txt");
	}

	/**
	 * 读取文件，不存在则创建
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
	 * 读取文件写入到指定文件
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
	 * 释放资源
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
	 * 删除文件
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
