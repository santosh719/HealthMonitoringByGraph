package com.example.santosh.healthmonitoringbygraph;

import android.util.Log;

import java.util.Random;
/**
 * Created by mohseenmukaddam on 8/30/16.
 */
public class Patient {
    public static boolean MALE = true;
    public static boolean FEMALE = false;
    final String TAG = "Santi";
    private int id;
    private double Age;
    private String Name;
    private Boolean Sex;
    private int LengthOfData;
    private float[] Data;

    //complete explicit constructor
    public Patient(int id, double age, String name, Boolean sex, float[] data, int length){
        this.id = id;
        this.Age = age;
        this.Name = name;
        this.Sex = sex;
        this.Data = data;
        this.LengthOfData = length;
    }
    //for case with only length in dataset
    public Patient(int id, double age, String name, Boolean sex, int length){
        this.id = id;
        this.Age = age;
        this.Name = name;
        this.Sex = sex;
        this.LengthOfData = length;
        this.Data = this.genRandomData(length);
    }
    public Patient(int id, double age, String name, Boolean sex){
        this.id = id;
        this.Age = age;
        this.Name = name;
        this.Sex = sex;
        this.Data = this.genRandomData(25);
        this.LengthOfData = 25;

    }
    public float[] getPatientData() {
        return (this.Data);
    }
    public void setPatientData(int len){
        for(int i = 0; i< (len-1);i++){
            this.Data[i] = this.Data[i+1];
        }
        Random keeper = new Random();
        Log.d(TAG, String.valueOf(keeper.nextFloat()));
        this.Data[(len-1)] = keeper.nextFloat();
    }
    private float[] genRandomData(int len){
        float[] results = new float[len];
        Random keeper = new Random();
        for (int i = 0; i < len; i++){
            results[i] = keeper.nextFloat();
        }
        return(results);
    }
}