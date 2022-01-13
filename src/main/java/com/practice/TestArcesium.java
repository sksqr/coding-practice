package com.practice;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestArcesium {

  public static void main(String[] args) {

    List<String> inputList = new ArrayList<>();
    inputList.add("address.geo.lat");
    inputList.add("EQUALS");
    inputList.add("-17.3159");
    Gson gson = new Gson();
    String data = getData();
    JsonArray jsonArray = gson.fromJson(data,JsonArray.class);
    List<Integer> list = new ArrayList<>();
    String op = "EQUALS";
    Set<String> setForInOps = new HashSet<>();
    if("IN".equals(inputList.get(1))){
      String[] arr = inputList.get(2).split(",");
      for(int i =0; i<arr.length; i++){
        setForInOps.add(arr[i]);
      }
    }
    for(int i=0; i<jsonArray.size(); i++){
      String value = getValueFromJson(jsonArray.get(i),inputList.get(0));
      if("EQUALS".equals(inputList.get(1))){
        if(inputList.get(2).equals(value)){
          list.add(jsonArray.get(i).getAsJsonObject().get("id").getAsInt());
        }
      } else {
        if(setForInOps.contains(value)){
          list.add(jsonArray.get(i).getAsJsonObject().get("id").getAsInt());
        }
      }
    }
    System.out.println(list);

  }

  private static String getValueFromJson(JsonElement jsonElement, String param){
    int i = param.indexOf(".");
    if(i==-1){
      return jsonElement.getAsJsonObject().get(param).getAsString();
    }
    else {
      String p = param.substring(0,i);
      return getValueFromJson(jsonElement.getAsJsonObject().get(p),param.substring(i+1,param.length()));
    }
  }

  private static String getData(){
    String data = "[\n"
        + "  {\n"
        + "    \"id\": 1,\n"
        + "    \"name\": \"Vinay Kumar\",\n"
        + "    \"username\": \"vinayk\",\n"
        + "    \"email\": \"vinayk@abcu.com\",\n"
        + "    \"address\": {\n"
        + "      \"street\": \"random1\",\n"
        + "      \"suite\": \"APR\",\n"
        + "      \"city\": \"Mumbai\",\n"
        + "      \"zipcode\": \"192008-13874\",\n"
        + "      \"geo\": {\n"
        + "        \"lat\": \"-17.3159\",\n"
        + "        \"lng\": \"91.1496\"\n"
        + "      }\n"
        + "    },\n"
        + "    \"website\": \"seuinfra.org\",\n"
        + "    \"company\": {\n"
        + "      \"name\": \"sec infra\",\n"
        + "      \"basename\": \"seu infra tech\"\n"
        + "    }\n"
        + "  },\n"
        + "  {\n"
        + "    \"id\": 2,\n"
        + "    \"name\": \"Anandita Basu\",\n"
        + "    \"username\": \"PrernaB\",\n"
        + "    \"email\": \"Anandita.b@abc1f.cpm\",\n"
        + "    \"address\": {\n"
        + "      \"street\": \"Hawroh Bridge\",\n"
        + "      \"suite\": \"ATY\",\n"
        + "      \"city\": \"Kolkata\",\n"
        + "      \"zipcode\": \"700001\",\n"
        + "      \"geo\": {\n"
        + "        \"lat\": \"-67.3159\",\n"
        + "        \"lng\": \"91.8006\"\n"
        + "      }\n"
        + "    },\n"
        + "    \"website\": \"techInfar.org\",\n"
        + "    \"company\": {\n"
        + "      \"name\": \"tech infar world\",\n"
        + "      \"basename\": \"seu infra tech\"\n"
        + "    }\n"
        + "  },\n"
        + "  {\n"
        + "    \"id\": 3,\n"
        + "    \"name\": \"Charvi Malhotra\",\n"
        + "    \"username\": \"CharviM\",\n"
        + "    \"email\": \"Charvim@mail.net\",\n"
        + "    \"address\": {\n"
        + "      \"street\": \"whitehouse Extension\",\n"
        + "      \"suite\": \"A782\",\n"
        + "      \"city\": \"Bengaluru\",\n"
        + "      \"zipcode\": \"560001\",\n"
        + "      \"geo\": {\n"
        + "        \"lat\": \"-68.6102\",\n"
        + "        \"lng\": \"-47.0653\"\n"
        + "      }\n"
        + "    },\n"
        + "    \"website\": \"Infesystem.info\",\n"
        + "    \"company\": {\n"
        + "      \"name\": \"infeystems\",\n"
        + "      \"basename\": \"Information E stsyem\"\n"
        + "    }\n"
        + "  },\n"
        + "  {\n"
        + "    \"id\": 4,\n"
        + "    \"name\": \"Patricia Wilson\",\n"
        + "    \"username\": \"WilsonP\",\n"
        + "    \"email\": \"Wilsonp@mymail.org\",\n"
        + "    \"address\": {\n"
        + "      \"street\": \"Kalangut\",\n"
        + "      \"suite\": \"Apt 6\",\n"
        + "      \"city\": \"Panjim\",\n"
        + "      \"zipcode\": \"403110\",\n"
        + "      \"geo\": {\n"
        + "        \"lat\": \"29.4572\",\n"
        + "        \"lng\": \"-164.2990\"\n"
        + "      }\n"
        + "    },\n"
        + "    \"website\": \"giant.Tech.biz\",\n"
        + "    \"company\": {\n"
        + "      \"name\": \"robert-techgiant\",\n"
        + "      \"basename\": \"transition cutting-edge web services provider\"\n"
        + "    }\n"
        + "  },\n"
        + "  {\n"
        + "    \"id\": 5,\n"
        + "    \"name\": \"Chetan Chauhan \",\n"
        + "    \"username\": \"ChauhanChetan\",\n"
        + "    \"email\": \"chetanc@mailme.in\",\n"
        + "    \"address\": {\n"
        + "      \"street\": \"Willow Walks\",\n"
        + "      \"suite\": \"1351\",\n"
        + "      \"city\": \"Hyderabad\",\n"
        + "      \"zipcode\": \"500001\",\n"
        + "      \"geo\": {\n"
        + "        \"lat\": \"-31.8129\",\n"
        + "        \"lng\": \"62.5342\"\n"
        + "      }\n"
        + "    },\n"
        + "    \"website\": \"sanganak.info\",\n"
        + "    \"company\": {\n"
        + "      \"name\": \"Sanganak\",\n"
        + "      \"basename\": \"end-to-end solution provider\"\n"
        + "    }\n"
        + "  },\n"
        + "  {\n"
        + "    \"id\": 6,\n"
        + "    \"name\": \"Pragya Mathur\",\n"
        + "    \"username\": \"mathurpragya\",\n"
        + "    \"email\": \"pragya.mathur@mail.in\",\n"
        + "    \"address\": {\n"
        + "      \"street\": \"Rosewind Crossing\",\n"
        + "      \"suite\": \"A-50\",\n"
        + "      \"city\": \"Delhi\",\n"
        + "      \"zipcode\": \"100001\",\n"
        + "      \"geo\": {\n"
        + "        \"lat\": \"-71.4197\",\n"
        + "        \"lng\": \"71.7478\"\n"
        + "      }\n"
        + "    },\n"
        + "        \"website\": \"hola.in\",\n"
        + "    \"company\": {\n"
        + "      \"name\": \"Hola Technocrafts\",\n"
        + "      \"basename\": \"e-enable innovative applications\"\n"
        + "    }\n"
        + "  },\n"
        + "  {\n"
        + "    \"id\": 7,\n"
        + "    \"name\": \"Krish Ahuja\",\n"
        + "    \"username\": \"ahujakrish\",\n"
        + "    \"email\": \"ahujakrish@mails.in\",\n"
        + "    \"address\": {\n"
        + "      \"street\": \"Havmore Extension\",\n"
        + "      \"suite\": \"A3221\",\n"
        + "      \"city\": \"Bengalura\",\n"
        + "      \"zipcode\": \"560058\",\n"
        + "      \"geo\": {\n"
        + "        \"lat\": \"24.8918\",\n"
        + "        \"lng\": \"21.8984\"\n"
        + "      }\n"
        + "    },\n"
        + "    \"website\": \"tellybelly.in\",\n"
        + "    \"company\": {\n"
        + "      \"name\": \"Telly Belly\",\n"
        + "      \"basename\": \"generate application support solutions\"\n"
        + "    }\n"
        + "  },\n"
        + "  {\n"
        + "    \"id\": 8,\n"
        + "    \"name\": \"Nilofar Anam\",\n"
        + "    \"username\": \"anamnilofar\",\n"
        + "    \"email\": \"nilofaranam.d@maily.me\",\n"
        + "    \"address\": {\n"
        + "      \"street\": \"fountains lane\",\n"
        + "      \"suite\": \"B902\",\n"
        + "      \"city\": \"pune\",\n"
        + "      \"zipcode\": \"400001\",\n"
        + "      \"geo\": {\n"
        + "        \"lat\": \"-14.3990\",\n"
        + "        \"lng\": \"-120.7677\"\n"
        + "      }\n"
        + "    },\n"
        + "    \"website\": \"techoba.com\",\n"
        + "    \"company\": {\n"
        + "      \"name\": \"Tech Happy Group\",\n"
        + "      \"basename\": \"e-support to middle retailers\"\n"
        + "    }\n"
        + "  },\n"
        + "  {\n"
        + "    \"id\": 9,\n"
        + "    \"name\": \"Garima Gupta\",\n"
        + "    \"username\": \"Garimag\",\n"
        + "    \"email\": \"gupta.garima22@myemails.io\",\n"
        + "    \"address\": {\n"
        + "      \"street\": \"Little Park\",\n"
        + "      \"suite\": \"B68\",\n"
        + "      \"city\": \"Surat\",\n"
        + "      \"zipcode\": \"764920\",\n"
        + "      \"geo\": {\n"
        + "        \"lat\": \"24.6463\",\n"
        + "        \"lng\": \"-168.8889\"\n"
        + "      }\n"
        + "    },\n"
        + "    \"website\": \"contech.com\",\n"
        + "    \"company\": {\n"
        + "      \"name\": \"Configs Techs\",\n"
        + "      \"basename\": \"real-time technologies support\"\n"
        + "    }\n"
        + "  },\n"
        + "  {\n"
        + "    \"id\": 10,\n"
        + "    \"name\": \"Dharma Dhar\",\n"
        + "    \"username\": \"Dharmadhar55\",\n"
        + "    \"email\": \"dharmadhar55@olexa.in\",\n"
        + "    \"address\": {\n"
        + "      \"street\": \"Anam Street\",\n"
        + "      \"suite\": \"198/23\",\n"
        + "      \"city\": \"Surat\",\n"
        + "      \"zipcode\": \"314280\",\n"
        + "      \"geo\": {\n"
        + "        \"lat\": \"-38.2386\",\n"
        + "        \"lng\": \"57.2232\"\n"
        + "      }\n"
        + "    },\n"
        + "     \"website\": \"ampitech.net\",\n"
        + "    \"company\": {\n"
        + "      \"name\": \"Ampitech Solutions Ltd\",\n"
        + "      \"basename\": \"target end-to-end startup support\"\n"
        + "    }\n"
        + "  }\n"
        + "]";



 return data;
  }

}
