package com.example.geodezhelper.Files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GeoFileReader {
        BufferedReader reader;
        String filename;
        ArrayList<String> Fromfile;
        public GeoFileReader(String filename){
            this.filename = filename;
            Fromfile = new ArrayList<>();
        }
        public void read(){
            try {
                reader =new BufferedReader(new FileReader(filename));
                while (reader.ready()){
                    String s =reader.readLine();
                    Fromfile.add(s);
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public ArrayList<String>getFromfile(){
            return Fromfile;
        }
}
