package com.practice.twopointers;

import java.util.ArrayList;

public class MaximumOnesAfterModification {

  public int solve(ArrayList<Integer> A, int B) {
return 0;
  }

}


//http://ngjobsearch.microservices.resdex.com/NGJobSearchService/staging/Search/doSearch?appname=gulf&searchon=gulf&data={"limit":50,"easyApply":false,"dateTypes":{"web_jobs":"posted_date","posted_jobs":"job_add_date"},"isRecentSearch":0,"qp":"","qcity":[],"qcountry":[],"qgender":[],"qctcCluster":[],"qexpCluster":[],"qi":[],"qo":null,"qtitle":null,"qk":null,"userDetail":null,"searchBehaviour":"semantic","ntlid":[],"qs":"r","isConfidential":"","clusterCriteria":{"brandingSubCompany": "256","ctcmask":256,"expmask":256,"indtype":256,"toj":256,"farea":256,"citymask":256,"jobPostId":15000,"gender":256,"locationmask":256,"countrymask":256,"posted_date":9999,"nationalityFacet":256,"webjob":256},"UID":null,"jobTypes":[1,2,3],"ql":"","offset":1,"qe":null,"timeStamp":null,"qc":null,"qpremium":0,"qpremiumRandomized":0,"qd":1,"qShowQuickWebJobs":false,"qShowPostedJobs":false,"qALLKeyMatch":false,"qf":[],"xz":"1_0_5","mboost":"false","qctcCurrency":[1],"comName":null,"indLabel":null}
//
//
//
//
//    curl --location --request POST 'http://ngjobsearch.microservices.resdex.com/NGJobSearchService/live/Search/doSearch?appname=gulf&searchon=gulf&data=%7B%22limit%22:20,%22easyApply%22:false,%22dateTypes%22:%7B%22web_jobs%22:%22posted_date%22,%22posted_jobs%22:%22job_add_date%22%7D,%22isRecentSearch%22:0,%22qp%22:%22%22,%22qcity%22:%5B%5D,%22qcountry%22:%5B%5D,%22qgender%22:%5B%5D,%22qctcCluster%22:%5B%5D,%22qexpCluster%22:%5B%5D,%22qi%22:%5B%5D,%22qo%22:null,%22qtitle%22:null,%22qk%22:null,%22userDetail%22:null,%22searchBehaviour%22:%22semantic%22,%22ntlid%22:%5B%5D,%22qs%22:%22r%22,%22isConfidential%22:%22false%22,%22clusterCriteria%22:%7B%22ctcmask%22:256,%22expmask%22:256,%22indtype%22:256,%22toj%22:256,%22farea%22:256,%22citymask%22:256,%22jobPostId%22:15000,%22gender%22:256,%22locationmask%22:256,%22countrymask%22:256,%22posted_date%22:9999,%22nationalityFacet%22:256,%22webjob%22:256%7D,%22UID%22:null,%22jobTypes%22:%5B1,2,3%5D,%22ql%22:%22%22,%22offset%22:1,%22qe%22:null,%22timeStamp%22:null,%22qc%22:49374,%22qpremium%22:0,%22qpremiumRandomized%22:0,%22qd%22:1,%22qShowQuickWebJobs%22:false,%22qShowPostedJobs%22:false,%22qALLKeyMatch%22:false,%22qf%22:%5B%5D,%22xz%22:%221_0_5%22,%22mboost%22:%22false%22,%22qctcCurrency%22:%5B7%5D,%22comName%22:null,%22indLabel%22:null%7D' \
//    --header 'authority: www.naukrigulf.com' \
//    --header 'device-type: desktop' \
//    --header 'nationality: 80' \
//    --header 'accept-language: ENGLISH' \
//    --header 'user-agent: Mozilla/5.0 (Linux; Android 8.0; Pixel 2 Build/OPD3.170816.012) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.162 Mobile Safari/537.36' \
//    --header 'systemid: 1112' \
//    --header 'accept-format: strict' \
//    --header 'accept: application/json' \
//    --header 'clientid: m0BiLe' \
//    --header 'cache-control: no-cache' \
//    --header 'sec-fetch-dest: empty' \
//    --header 'appid: 2050' \
//    --header 'userdata: 7|IN' \
//    --header 'locationid: 80' \
//    --header 'sec-fetch-site: same-origin' \
//    --header 'sec-fetch-mode: cors' \
//    --header 'referer: https://www.naukrigulf.com/dummyvar-jobs' \
//    --header 'cookie: mboost=false; isNew=1; _t_ds=6e8319e41584886570-1246e8319e4-06e8319e4; G_ENABLED_IDPS=google; userType=legacy; improve_search=325509430; __gads=ID=d8ee25bfecbfba3b:T=1584888163:S=ALNI_MbsGcuXjpLVJcnd6CWEQ4L3Xmk3Mg; _ga=GA1.2.837829019.1584886571; _ngUP=b397287780e2a3ddc7532febc76d4db541e9b1d8c050588a744527732b3c6dd780e01cbdfbdbde62338cd81377885cbc0c5d5fcbdbb447b4; mnjpwanew=legacy; userPrefLang=y; NITEST=y; _ngenv1[env]=mobile; pwa_lang=en; _ngenv1[lang]=en; _fbp=fb.1.1586436434806.1419728845; __zlcmid=xdj30deMlEwzd2; showAndroidLayer=1; AT=eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzUxMiJ9.eyJzdWIiOiIzMDkzNzg0MyIsImlzcyI6IkluZm9FZGdlIEluZGlhIFB2dC4gTHRkLiIsInVzZXJBZ2VudCI6Ik1vemlsbGEvNS4wIChMaW51eDsgQW5kcm9pZCA4LjA7IFBpeGVsIDIgQnVpbGQvT1BEMy4xNzA4MTYuMDEyKSBBcHBsZVdlYktpdC81MzcuMzYgKEtIVE1MLCBsaWtlIEdlY2tvKSBDaHJvbWUvODAuMC4zOTg3LjE2MiBNb2JpbGUgU2FmYXJpLzUzNy4zNiIsImlwQWRyZXNzIjoiMTI3LjExLjExLjEiLCJ1c2VySWQiOjMwOTM3ODQzLCJ1ZF91c2VyTmFtZSI6InNoYXNoaWthbnQzMTA4QGdtYWlsLmNvbSIsInVkX2RldmljZVR5cGUiOiJtb2JpbGVzaXRlIiwidXNlclN0YXRlIjoiQVVUSEVOVElDQVRFRCIsInVkX2RldmljZUlkIjoiZGVza3RvcCIsInVzZXJUeXBlIjoibmdqb2JzZWVrZXJNb2JpbGUiLCJzZXNzaW9uU3RhdFRpbWUiOiIyMDIwLTA0LTA5VDA5OjEyOjIzIiwidXNlclJvbGUiOiJuZ2pvYnNlZWtlciIsImV4cCI6MTYxNzk3Mzk0MywidG9rZW5UeXBlIjoiYWNjZXNzVG9rZW4iLCJpYXQiOjE1ODY0Mzc5NDMsImp0aSI6ImJkYTc5NjQ4MGM3YjQzNTE5NzFhM2UxNWRkYTZlNjYwIiwidWRfZGlzcGxheU5hbWUiOiJTaGFzaGkgS2FudCBTaW5naCBLdXNod2FoYSJ9.uDhPhkyiFxAA-PK_A4RIrk_lkipkJ-9_tWgV972Rik7oF0B6Blhp5F8-gv3Sxfv6yCL0YMJwO0bqGfolF0DrCNManKDVabEsxREPJK92d3MyrE7Vq1JocJ6ysRVgd88qee1JvzqDXEhYDCavJz7ZJOJ7mrnPAQiyZuywbnLBS_pj0d_YrtNxkRkJCYaunzfju1UMeFVYPrvOt5LlEPAQ2dHqoyO6F6nHibskvFPKORb1OdC3iWLrR75Jp4cJAn4qkCM2v5JkpESunnZfYJAGLZGMiFRiiop2Lz-lwAyp7Ypoa8PBrxYX9UeCBkZ8IkOEjhuhG4Y52r3T2S8XlOlzPA; RT=eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzUxMiJ9.eyJzdWIiOiIzMDkzNzg0MyIsImlzcyI6IkluZm9FZGdlIEluZGlhIFB2dC4gTHRkLiIsInVzZXJBZ2VudCI6Ik1vemlsbGEvNS4wIChMaW51eDsgQW5kcm9pZCA4LjA7IFBpeGVsIDIgQnVpbGQvT1BEMy4xNzA4MTYuMDEyKSBBcHBsZVdlYktpdC81MzcuMzYgKEtIVE1MLCBsaWtlIEdlY2tvKSBDaHJvbWUvODAuMC4zOTg3LjE2MiBNb2JpbGUgU2FmYXJpLzUzNy4zNiIsImlwQWRyZXNzIjoiMTI3LjExLjExLjEiLCJ1c2VySWQiOjMwOTM3ODQzLCJ1ZF91c2VyTmFtZSI6InNoYXNoaWthbnQzMTA4QGdtYWlsLmNvbSIsInVkX2RldmljZVR5cGUiOiJtb2JpbGVzaXRlIiwidXNlclN0YXRlIjoiQVVUSEVOVElDQVRFRCIsInVkX2RldmljZUlkIjoiZGVza3RvcCIsInVzZXJUeXBlIjoibmdqb2JzZWVrZXJNb2JpbGUiLCJzZXNzaW9uU3RhdFRpbWUiOiIyMDIwLTA0LTA5VDA5OjEyOjIzIiwidXNlclJvbGUiOiJuZ2pvYnNlZWtlciIsImV4cCI6MTYxNzk3Mzk0MywidG9rZW5UeXBlIjoicmVmcmVzaFRva2VuIiwiaWF0IjoxNTg2NDM3OTQzLCJqdGkiOiJiZGE3OTY0ODBjN2I0MzUxOTcxYTNlMTVkZGE2ZTY2MCIsInVkX2Rpc3BsYXlOYW1lIjoiU2hhc2hpIEthbnQgU2luZ2ggS3VzaHdhaGEifQ.AXQExl8Cv-atLHce5FiVwH16uoU_M9Osav1CpOyYttyFZClwCY2PfGDKRShjGGGQkaTkuiAcCkTuZ9oq_UR4HdBsD0wbNeXikjKz6P-L_srk6vYL8Lq4n7KmjeS4XVmlGLgoRtbm1g-Jn2D0Q2cCGU7-aR6ee95ONCTprbFd6Ct4Gvqh1Ud1UrPCpNLF8UzMxx9JGUuRCLptNErDBk5igb9OVh-jjXkMgufFsPyLqwYVuboyQuWegXPLyO_Dr8ewtIy1HHGmgYahgJuVi19atBmFdKLU_Gm1OdsvYJyrRl0IgdSyf-pJPXYpXw_KTa-bW2oC0pgPa24SFMygeZxJsw; NIMNJ[USERNAME]=eda47e19a6106882576a4469df6b6ed839e2ae20078b25ec2d9905911c327cd3c434dd9f7e246508; NIMNJ[DISP_LANG]=en; __utmz=127812882.1588657056.43.4.utmcsr=linkedin.com|utmccn=(referral)|utmcmd=referral|utmcct=/feed/; __atuvc=0%7C15%2C0%7C16%2C0%7C17%2C0%7C18%2C1%7C19; __atssc=linkedin%3B1; PHPSESSID=9a2372758aa018d9d692e9859170c733; __ccode=IN; __utmc=127812882; symfony=h0bf7oh08jhphfdnrj6n0fipf5; clusterData=0,1,1,1,0,1,1,0,1,1; __utma=127812882.837829019.1584886571.1589442930.1589522809.55; ak_bmsc=3B6CB72CD80A080DF2A2F1D2601E21AE312C8AEDB13D00007931BE5EF82FBC1C~plYZgtzuomE2YCU63nH86z+I/3evFENLAc5L5AXI9d5AI8O8TmMG9819EVtoQiC3NyXjlGHfTLSxFtfZ9X84QQMYauuDzkhzSO2i2F9sFOLZpWLxT0UxgokSmBpRB4af0tnnWJS7nSmS5CDp/PTRFZ/+CyuKqWA4R6y6k8FMWHB6TVJ9tkHHRMM85Jy87fNH8aEu+Oimz5igZy5O5sEPqlB1mIaDXhAMX/G6lEpfV6AoagQQmbALXKRgJonQ6736enX3n4VOtK97DMxrnjCa72QY1ALMFZgur381P9LrwQ385Bn7N2oc3pihXyhpbLBaoS; __utmt=1; bm_sv=FDAD56E1D75DB537B912253EA4DEDE59~etQVOzQSaBja3wLXD5t5mIxnBuM9StWcwdPJ+026YVF4gtosrH9bONEZ7XcvkxZ6PVN72jiZHPhIsZmEu8KnzYSdrJUfnvVvVU5tOrN6qBo7z0JoceIXRtfsH8DkP8HKw2cLiKXmzAQ6EZBLifK+evfVeCjTslS827Gnhi9JIpc=; __utmb=127812882.38.9.1589529588654' \
//    --header 'geoIpCountryName: United States' \
//    --header 'geoIpCityName: Jamul'
//
//
//
//    http://ngjobsearch.microservices.resdex.com/NGJobSearchService/live/Search/doSearch?appname=gulf&searchon=gulf&data={"limit":50,"easyApply":false,"dateTypes":{"web_jobs":"posted_date","posted_jobs":"job_add_date"},"isRecentSearch":0,"qp":"Hill International","qcity":[],"qcountry":[],"qgender":[],"qctcCluster":[],"qexpCluster":[],"qi":[],"qo":null,"qtitle":null,"qk":null,"userDetail":null,"searchBehaviour":"semantic","ntlid":[],"qs":"r","isConfidential":"false","clusterCriteria":{"brandingSubCompany": "256","ctcmask":256,"expmask":256,"indtype":256,"toj":256,"farea":256,"citymask":256,"jobPostId":15000,"gender":256,"locationmask":256,"countrymask":256,"posted_date":9999,"nationalityFacet":256,"webjob":256},"UID":null,"jobTypes":[1,2,3],"ql":"","offset":1,"qe":null,"timeStamp":null,"qc":null,"qpremium":0,"qpremiumRandomized":0,"qd":1,"qShowQuickWebJobs":false,"qShowPostedJobs":false,"qALLKeyMatch":false,"qf":[],"xz":"1_0_5","mboost":"false","qctcCurrency":[1],"comName":null,"indLabel":null}
