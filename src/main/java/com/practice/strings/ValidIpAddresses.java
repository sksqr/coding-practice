package com.practice.strings;

import java.util.ArrayList;
import java.util.Collections;

public class ValidIpAddresses {

  public static void main(String[] args) {
    ValidIpAddresses validIpAddresses = new ValidIpAddresses();
    String A="25525511135";
    System.out.println(validIpAddresses.restoreIpAddresses(A));
  }


  ArrayList<String> ips;
  public ArrayList<String> restoreIpAddresses(String A) {
    ips = new ArrayList();
    addIpAddresses(A,0,"",0);
    Collections.sort(ips);
    return ips;
  }

  public void addIpAddresses(String A, int start, String ip, int count) {


    if(start==A.length()-1){
      ips.add(ip);
    }
    if(count==4){
      return;
    }
    int n = A.length();
    int k=1;
    while(k<=3 && start+k <n){
      String newIp="";
      String subnet = A.substring(start,start+k);
      if(!subnet.equals("") && Long.valueOf(subnet) <= 255){
        if(count==0){
          newIp=subnet;
        }
        else{
          newIp =ip+"."+subnet;
        }
        addIpAddresses(A,start+k,newIp,count+1);
      }
      k++;
    }
    return;
  }
}
