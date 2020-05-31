/*
 * Copyright (c) 2009, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.filefilter.WildcardFileFilter;

public class Find {

    public  void MigrateFile()    throws IOException {

        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current relative path is: " + s);

        File fileNameReport = new File(s);
        File[] fileListReport = fileNameReport.listFiles();
        File ReportFile = new File(s+"\\Summary_Report.txt");
        FileWriter myWriterRep = new FileWriter(s+"\\Summary_Report.txt", true);
        myWriterRep.write("Before Zip ==================== \n");
        ReportFile.createNewFile();
        int SummaryReport = 0;
        for (File file: fileListReport) {
            // System.out.println(file.getName()+" "+file.getName().indexOf("Sampling") );
            if(file.getName().indexOf("Sampling") >= 0) {
                System.out.println(file.getName());
                File folder = new File(s+"\\"+file.getName()+"\\");
                File[] listOfFiles = folder.listFiles();
              //Gen Report Before 
                
                
                try (Stream<Path> walk = Files.walk(Paths.get(s+"\\"+file.getName()))) {
                	
                
                myWriterRep.write("Folder : "+file.getName()+"\n");

                	List<String> result = walk.map(x -> x.toString())
                			.filter(f -> f.endsWith(".pdf")).collect(Collectors.toList());
                	int rep = 0;
                	while(rep < result.size()) {
                	//System.out.println("result >>>"+result.get(rep));
                	
                	//result.forEach(System.out::println)
                		myWriterRep.write(result.get(rep)+" \n");
                		
                	rep++;
                	}
                	//System.out.println("Size >>>"+result.size());
                	myWriterRep.write("Total >>>"+result.size()+" \n");
                	SummaryReport += result.size();
                } catch (IOException e) {
                	e.printStackTrace();
                }
                //End Gen Report Before
            }
        }
        
        
        
        
        
        File fileName = new File(s);
        File[] fileList = fileName.listFiles();
        for (File file: fileList) {
            // System.out.println(file.getName()+" "+file.getName().indexOf("Sampling") );
            if(file.getName().indexOf("Sampling") >= 0) {
                System.out.println(file.getName());
                File folder = new File(s+"\\"+file.getName()+"\\");
                File[] listOfFiles = folder.listFiles();
              //Gen Report Before 
                for (File file1 : listOfFiles) {
                    if (file1.isFile()) {
                        System.out.println(file1.getName());
                        //-------------------------------------------------------
                        String csvFile = s+"\\account_sampling.txt";
                        String line = "";//Temp Row
                        String cvsSplitBy = "[|\n]";
                        int check = 0;
                        String typeDoc = "";
                        String accountFalse = "";
                        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

                            while ((line = br.readLine()) != null) {

                                // use comma as separator
                                String[] account = line.split(cvsSplitBy);
                                // System.out.println(" LINE = "+line);
                                // System.out.println("Account [code= " + country[3] +" Country [code= " + country[4]+" , name=" + country[5] + "]");
                               //  System.out.println("Account  " + country[4].indexOf("Seal_1"));

                                if(account[4].indexOf(file.getName()) > 0){
                                    String accountFromFile = file1.getName().substring(0,14);
                                    String accountId = account[2];

                                   // System.out.println("Check  >> "+accountFromFile+" "+ accountId+" "+ accountFromFile.equalsIgnoreCase(accountId));
                                   // System.out.println("Account " + file.getName() +" >> "+account[2]);
                                    if(accountFromFile.equalsIgnoreCase(accountId) && account[4].substring(13,14).equalsIgnoreCase(account[5])) {
                                        check = 0;
                                        break;
                                    }else{
                                        check = 1;
                                        typeDoc = account[4].substring(13,14);
                                        accountFalse = file1.getName().substring(0,14);
                                    }

                                }

                            }


                            if(check ==1) {
                              //  System.out.println("Account ID >>>  "+accountFalse);
                             //   System.out.println("Check  "+check);
                             //   System.out.println("typeDoc  "+typeDoc);
                                try (BufferedReader br1 = new BufferedReader(new FileReader(csvFile))) {
                                    // System.out.println(" LINE = "+line);
                                    int moveFile = 0;
                                   // String accountArray[] = new String[200];
                                    //int counter = 0;
                                    while ((line = br1.readLine()) != null) {

                                        // use comma as separator
                                        String[] account = line.split(cvsSplitBy);
                                        //System.out.println(" LINE = "+line);
                                        // System.out.println("Account [code= " + country[3] +" Country [code= " + country[4]+" , name=" + country[5] + "]");
                                        //  System.out.println("Account  " + country[4].indexOf("Seal_1"));
                                        //System.out.println("TESTTTTT " + account[2] +" >> "+accountFalse);
                                        if(account[2].equalsIgnoreCase(accountFalse)){
                                            moveFile = 0;
                                            // System.out.println("Account " + file.getName() +" >> "+account[2]);
                                            if(account[5].equalsIgnoreCase(typeDoc)) {//Same Destination
                                                System.out.println(" TRUE =>> ");
                                                break;
                                            }else{
                                                System.out.println(" Move to Correct Location =>> ");
                                                if(file.getName().indexOf("Seal_1") > 0) {
                                                    System.out.println(file.getName());
                                                    Path temp = Files.move
                                                            (Paths.get(s+"\\"+file.getName()+"\\"+file1.getName()),
                                                                    Paths.get(s+"\\Sampling_Wrapping_1\\"+file1.getName()));
                                                }else if(file.getName().indexOf("Wrapping_1") > 0) {
                                                    System.out.println(file.getName());
                                                    Path temp = Files.move
                                                            (Paths.get(s+"\\"+file.getName()+"\\"+file1.getName()),
                                                                    Paths.get(s+"\\Sampling_ENV\\"+file1.getName()));
                                                }else if(file.getName().indexOf("Seal_2") > 0) {
                                                    System.out.println(file.getName());
                                                    Path temp = Files.move
                                                            (Paths.get(s+"\\"+file.getName()+"\\"+file1.getName()),
                                                                    Paths.get(s+"\\Sampling_Wrapping_2\\"+file1.getName()));
                                                }else if(file.getName().indexOf("Wrapping_2") > 0) {
                                                    System.out.println(file.getName());
                                                    Path temp = Files.move
                                                            (Paths.get(s+"\\"+file.getName()+"\\"+file1.getName()),
                                                                    Paths.get(s+"\\Sampling_ENV\\"+file1.getName()));
                                                }
                                                break;
                                            }


                                        }else{
//                                            accountArray[counter] = account[2];
//                                                    counter++;
                                            moveFile = 1;//Account ID False

                                        }

                                    }
                                    System.out.println(" FALSE MOVE FIle "+moveFile);
                                    if(moveFile ==1) {
                                        //System.out.println(" MOVE TO MAIN DIRECTORY "+Arrays.toString(accountArray));
                                        //List<String> list = Arrays.asList(accountArray)
                                        Path temp = Files.move
                                                (Paths.get(s+"\\"+file.getName()+"\\"+file1.getName()),
                                                        Paths.get(s+"\\"+file1.getName()));
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                
            }
        }
        
    	
    	myWriterRep.write("Total File >>>"+SummaryReport+" \n");
    	myWriterRep.close();
    	
        for (File file2: fileList) {
     	   new File(s+"/QC_Seal").mkdirs();
     	   new File(s+"/QC_Wrap").mkdirs();
     	   new File(s+"/QC_Env").mkdirs();
            // System.out.println(file.getName()+" "+file.getName().indexOf("Sampling") );
            if(file2.getName().indexOf("Sampling_QC") >= 0) {
                System.out.println("QC1 >>>>>>>>"+file2.getName());
                File folder = new File(s+"\\"+file2.getName()+"\\");
                File[] listOfFiles = folder.listFiles();
                //QC Section
                int numcheckfor = 1;
                for (File file1 : listOfFiles) {
                    if (file1.isFile()) {
                        System.out.println("QC2 >>>>>>>>"+file1.getName());
                        //-------------------------------------------------------
                        String csvFile = s+"\\account_sampling.txt";
                        String line = "";//Temp Row
                        String cvsSplitBy = "[|\n]";
                        int check = 0;
                        String typeDoc = "";
                        String accountFalse = "";
                        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

                            while ((line = br.readLine()) != null) {

                                // use comma as separator
                                String[] account = line.split(cvsSplitBy);
                                // System.out.println(" LINE = "+line);
                                // System.out.println("Account [code= " + country[3] +" Country [code= " + country[4]+" , name=" + country[5] + "]");
                                //System.out.println("Account4  " + account[4]+"Account5  " + account[5]);

                                if((account[4].indexOf(file2.getName())) > 0){
                               	 System.out.println("QC Ready >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                                   String accountFromFile = file1.getName().substring(0,14);
                                   String accountId = account[2];

                                  // System.out.println("Check  >> "+accountFromFile+" "+ accountId+" "+ accountFromFile.equalsIgnoreCase(accountId));
                                  // System.out.println("Check  >> "+ account[4].substring(13,14).equalsIgnoreCase(account[5]));
                                 //  System.out.println("Check  >> "+account[5]);
                                   if(accountFromFile.equalsIgnoreCase(accountId)) {
                                	   if("S".equalsIgnoreCase(account[5])) {
                                           System.out.println(file2.getName());
                                           Path temp = Files.move
                                                   (Paths.get(s+"\\"+file2.getName()+"\\"+file1.getName()),
                                                           Paths.get(s+"\\QC_Seal\\"+file1.getName()));
                                	   }else if ("W".equalsIgnoreCase(account[5])) {
                                           System.out.println(file2.getName());
                                           Path temp = Files.move
                                                   (Paths.get(s+"\\"+file2.getName()+"\\"+file1.getName()),
                                                           Paths.get(s+"\\QC_Wrap\\"+file1.getName()));
                                	   }else if ("E".equalsIgnoreCase(account[5])) {
                                           System.out.println(file2.getName());
                                           Path temp = Files.move
                                                   (Paths.get(s+"\\"+file2.getName()+"\\"+file1.getName()),
                                                           Paths.get(s+"\\QC_Env\\"+file1.getName()));
                                	   }
                                       break;
                                   }
                               }
                                
                                 

                            }
                            System.out.println("END QC  "+numcheckfor++);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        
        //Find File Not Exist
        //-------------------------------------------------------
        String csvFileCount = s+"\\account_sampling.txt";
        String lineCount = "";//Temp Row
        String cvsSplitByCount = "[|\n]";
        int checkArr = 0;
        String typeDocCount = "";
        String accountFalseCount; 
   	 File FileNotFound = new File(s+"\\FileNotFound.txt");
   	//String [] array = new String[30];
   	List<String> al = new CopyOnWriteArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFileCount))) {
       	
       	 
            while ((lineCount = br.readLine()) != null) {
                String[] account = lineCount.split(cvsSplitByCount);
                al.add(account[2])   ;
                checkArr++;
            }
            
            System.out.println(checkArr); 
            System.out.println(Arrays.asList(al)); 
          
            int i = 0;
            
           
            
            
            Iterator itr = al.iterator(); 
            while (i < al.size()) 
            {
           	 File dir = new File(s+"\\Sampling_ENV\\");
           	 System.out.println(" al.get(i)  = "+al.get(i) );
           	FileFilter fileFilter = new WildcardFileFilter(al.get(i) + "*");
                File[] files = dir.listFiles(fileFilter);
             
                System.out.println(" LINE = "+files.length);
                if(files.length == 1) {
               	 System.out.println(al.get(i)); 
               	 al.remove(new String(al.get(i)));
               	 i--;
                }
                i++;
               //checkArr--;
                   
            } 
            
            i = 0;
            System.out.println(Arrays.asList(al)); 
            while (i < al.size()) 
            {
           	 File dir = new File(s+"\\Sampling_Seal_1\\");
           	 System.out.println(" al.get(i)  = "+al.get(i) );
           	FileFilter fileFilter = new WildcardFileFilter(al.get(i) + "*");
                File[] files = dir.listFiles(fileFilter);
             
                System.out.println(" LINE = "+files.length);
                if(files.length == 1) {
               	 System.out.println(al.get(i)); 
               	 al.remove(new String(al.get(i)));
               	 i--;
                }
                i++;
               //checkArr--;
                   
            } 
            System.out.println(Arrays.asList(al)); 
            i = 0;
            System.out.println(Arrays.asList(al)); 
            while (i < al.size()) 
            {
           	 File dir = new File(s+"\\Sampling_Seal_2\\");
           	 System.out.println(" al.get(i)  = "+al.get(i) );
           	FileFilter fileFilter = new WildcardFileFilter(al.get(i) + "*");
                File[] files = dir.listFiles(fileFilter);
             
                System.out.println(" LINE = "+files.length);
                if(files.length == 1) {
               	 System.out.println(al.get(i)); 
               	 al.remove(new String(al.get(i)));
               	 i--;
                }
                i++;
               //checkArr--;
                   
            } 
            System.out.println(Arrays.asList(al)); 
            i = 0;
            System.out.println(Arrays.asList(al)); 
            while (i < al.size()) 
            {
           	 File dir = new File(s+"\\Sampling_Wrapping_1\\");
           	 System.out.println(" al.get(i)  = "+al.get(i) );
           	FileFilter fileFilter = new WildcardFileFilter(al.get(i) + "*");
                File[] files = dir.listFiles(fileFilter);
             
                System.out.println(" LINE = "+files.length);
                if(files.length == 1) {
               	 System.out.println(al.get(i)); 
               	 al.remove(new String(al.get(i)));
               	 i--;
                }
                i++;
               //checkArr--;
                   
            } 
            System.out.println(Arrays.asList(al)); 
            i = 0;
            System.out.println(Arrays.asList(al)); 
            while (i < al.size()) 
            {
           	 File dir = new File(s+"\\Sampling_Wrapping_2\\");
           	 System.out.println(" al.get(i)  = "+al.get(i) );
           	FileFilter fileFilter = new WildcardFileFilter(al.get(i) + "*");
                File[] files = dir.listFiles(fileFilter);
             
                System.out.println(" LINE = "+files.length);
                if(files.length == 1) {
               	 System.out.println(al.get(i)); 
               	 al.remove(new String(al.get(i)));
               	 i--;
                }
                i++;
               //checkArr--;
                   
            } 
            System.out.println(Arrays.asList(al)); 
            i = 0;
            System.out.println(Arrays.asList(al)); 
            while (i < al.size()) 
            {
           	 File dir = new File(s+"\\QC_Seal\\");
           	 System.out.println(" al.get(i)  = "+al.get(i) );
           	FileFilter fileFilter = new WildcardFileFilter(al.get(i) + "*");
                File[] files = dir.listFiles(fileFilter);
             
                System.out.println(" LINE = "+files.length);
                if(files.length == 1) {
               	 System.out.println(al.get(i)); 
               	 al.remove(new String(al.get(i)));
               	 i--;
                }
                i++;
               //checkArr--;
                   
            } 
            System.out.println(Arrays.asList(al)); 
            i = 0;
            System.out.println(Arrays.asList(al)); 
            while (i < al.size()) 
            {
           	 File dir = new File(s+"\\QC_Wrap\\");
           	 System.out.println(" al.get(i)  = "+al.get(i) );
           	FileFilter fileFilter = new WildcardFileFilter(al.get(i) + "*");
                File[] files = dir.listFiles(fileFilter);
             
                System.out.println(" LINE = "+files.length);
                if(files.length == 1) {
               	 System.out.println(al.get(i)); 
               	 al.remove(new String(al.get(i)));
               	 i--;
                }
                i++;
               //checkArr--;
                   
            } 
            System.out.println(Arrays.asList(al)); 
            i = 0;
            System.out.println(Arrays.asList(al)); 
            while (i < al.size()) 
            {
           	 File dir = new File(s+"\\QC_Env\\");
           	 System.out.println(" al.get(i)  = "+al.get(i) );
           	FileFilter fileFilter = new WildcardFileFilter(al.get(i) + "*");
                File[] files = dir.listFiles(fileFilter);
             
                System.out.println(" LINE = "+files.length);
                if(files.length == 1) {
               	 System.out.println(al.get(i)); 
               	 al.remove(new String(al.get(i)));
               	 i--;
                }
                i++;
               //checkArr--;
                   
            } 
            System.out.println(Arrays.asList(al)); 
            
            if(al.size() > 0) {
            FileNotFound.createNewFile();
          FileWriter myWriter = new FileWriter(s+"\\FileNotFound.txt");
          myWriter.write("Account Not Found \n");
          myWriter.write(Arrays.asList(al)+" \n");
          myWriter.close();
            }

            


        } catch (IOException e) {
            e.printStackTrace();
        }
        

    }
}
