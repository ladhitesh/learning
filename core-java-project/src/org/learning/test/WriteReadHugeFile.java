package org.learning.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class WriteReadHugeFile {

	public static void main(String[] args) {
		
		System.out.println("Starting");
		File file = new File("E:\\temp\\bigfile.bin");
		File file1 = new File("E:\\temp\\bigfilesort.bin");
		try {
			
			/*
			try (FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr)) {

				String line = null;
				while ((line = br.readLine()) != null) {
					System.out.println(line);
				}
			}
			*/
			
			
			//write 3gb file
			try(FileWriter fw = new FileWriter(file1);BufferedWriter bw = new BufferedWriter(fw);){
				for(int i=0;i<=30000000;i++){
					bw.write(i+":aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n");
				}
			}
			System.out.println("Done writing file");
		

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
