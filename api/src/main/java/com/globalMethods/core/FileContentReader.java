package com.globalMethods.core;

import static org.junit.Assert.assertNotNull;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;

import junit.framework.Assert;

public class FileContentReader {
	public static String   batPutMemberGPGFile,batgetMemberGPGFileFTPLocation,batgetOutboundGPGFileFTPLocation,batgetMemberErrorFileFTPLocation,batgetMemberControlFileFTPLocation,batPutMemberOutboundGPGFile;
	public static String  timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss.SSS").format(Calendar.getInstance().getTime());
	public static String batCommandWriteloadfile="cd /d " + System.getProperty("user.dir")+"\\lib\\"+"\n"+"psftp.exe H4mAD4DM@nhdevftp.sandata.com -pw ckgz4zcU -b put.bat ";
	public static String batCommandWriteloadfileget="cd /d " + System.getProperty("user.dir")+"\\lib\\"+"\n"+"psftp.exe H4mAD4DM@nhdevftp.sandata.com -pw ckgz4zcU -b get.bat ";
	public static String batFileNamePsftp =System.getProperty("user.dir")+ "\\lib\\putfile.bat";
	public static String batFileNamePsftpget =System.getProperty("user.dir")+ "\\lib\\getfile.bat";
	 private static String keyPath = System.getProperty("user.dir") +File.separator+"lib"+File.separator+"intf_molina_publickey.asc";
	
	public static String batFileNamePsftpbat =System.getProperty("user.dir")+ "\\lib\\put.bat";
	public static String batFileNamePsftpbatget =System.getProperty("user.dir")+ "\\lib\\get.bat";
	public static void runCommand(String filePath,String fileContent ) throws Exception{

		try{
			createFile(filePath, fileContent);
			Thread.sleep(10);
			Runtime.getRuntime().exec(filePath);
			Thread.sleep(10000);
		}

		catch(IOException e){
			e.printStackTrace();
			throw new Exception("IOException",e);
		}
	}

	public static void deleteFile(String filePath)
	{
		File file= new File(filePath);

		if (file.exists())
		{
			file.delete();
		}
	}

	public static void createFile(String filepath, String fileContent) throws IOException
	{
		File file= new File(filepath);

		if (file.exists())
		{
			deleteFile(filepath);
		}

		file.createNewFile();
		FileWriter filewriter=new FileWriter(file.getAbsoluteFile());
		BufferedWriter bufferedwriter= new BufferedWriter(filewriter);
		bufferedwriter.write(fileContent);

		bufferedwriter.close();

	}

	public static void verifyFileContainString(String FilePath,List<String> Compare ,int Row)   {
		Map<Integer ,List<String>> mapdataByRow = new HashMap<>();
		try{
			BufferedReader reader =new BufferedReader(new FileReader(FilePath));
			String row =null;

			int rowNumber =1;
			while((row = reader.readLine())!=null)	{
				mapdataByRow.put(rowNumber, Arrays.asList(row.split(",(=(?:[^\"]*\"[^\"]*\")*[^\"]*$)")));
				rowNumber++;
			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		Iterator<String> iterator = Compare.iterator();
		while (iterator.hasNext()) {
			String comparevalue =iterator.next();
			if(mapdataByRow.get(Row).get(0).contains(comparevalue)){
				System.out.println(comparevalue+" is present in Error File");
			}
			else{
				Assert.fail(comparevalue+" is not present in Error File");
			}
		}	

	}

	public static String createPipeDelimFileAndConvertToGPG(String FilePath ,Map<String ,String> mapdataByValue) throws Exception   {
		Map<Integer ,List<String>> mapdataByRow = new HashMap<>();
		String latestFileName =globalVariables.memberGenericFileName+timeStamp+".csv";

		try{
			BufferedReader reader =new BufferedReader(new FileReader(FilePath));
			String row =null;

			int rowNumber =1;
			while((row = reader.readLine())!=null)	{
				mapdataByRow.put(rowNumber, Arrays.asList(row.split(",(=(?:[^\"]*\"[^\"]*\")*[^\"]*$)")));
				rowNumber++;
			}
			String mapdataByRowString=mapdataByRow.get(1).get(0).toString();
			String[] mapdataByRowStringArray=mapdataByRowString.split(Pattern.quote("|"));

			String mapdataByRowavalue=mapdataByRow.get(3).get(0).toString();
			String[] mapdataByRowvalueArray=mapdataByRowavalue.split(Pattern.quote("|"));
			for (Map.Entry<String,String> valueEntry : mapdataByValue.entrySet())  {

				for(int i=0;i<mapdataByRowStringArray.length;i++){

					if(mapdataByRowStringArray[i].equalsIgnoreCase("\""+valueEntry.getKey()+"\""))
					{

						mapdataByRowvalueArray[i]= "\""+valueEntry.getValue()+"\"";
						break;
					}
				}}


			StringBuffer Finalvalue = new StringBuffer();
			for(int i=0;i<mapdataByRowvalueArray.length;i++){
				Finalvalue =Finalvalue.append(mapdataByRowvalueArray[i]);
				if(i!=mapdataByRowvalueArray.length-1){
					Finalvalue.append("|");
				}
			}
			String finalvalueString = Finalvalue.toString();

			createFile(globalVariables.Encryptfile+latestFileName, mapdataByRowString+"\n"+finalvalueString);
		
			String result = OpenPgpHelper.encryptFile(globalVariables.Encryptfile+latestFileName, globalVariables.EncryptedfileResult+latestFileName+".gpg",keyPath);
	        assertNotNull(result);
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return latestFileName;

	}
	public static String createPipeDelimFileProviderAndConvertToGPG(String FilePath ,Map<String ,String> mapdataByValue) throws Exception   {
		Map<Integer ,List<String>> mapdataByRow = new HashMap<>();
		String latestFileName =globalVariables.memberProviderFileName+timeStamp+".csv";

		try{
			BufferedReader reader =new BufferedReader(new FileReader(FilePath));
			String row =null;

			int rowNumber =1;
			while((row = reader.readLine())!=null)	{
				mapdataByRow.put(rowNumber, Arrays.asList(row.split(",(=(?:[^\"]*\"[^\"]*\")*[^\"]*$)")));
				rowNumber++;
			}
			String mapdataByRowString=mapdataByRow.get(1).get(0).toString();
			String[] mapdataByRowStringArray=mapdataByRowString.split(Pattern.quote("|"));

			String mapdataByRowavalue=mapdataByRow.get(3).get(0).toString();
			String[] mapdataByRowvalueArray=mapdataByRowavalue.split(Pattern.quote("|"));
			for (Map.Entry<String,String> valueEntry : mapdataByValue.entrySet())  {

				for(int i=0;i<mapdataByRowStringArray.length;i++){

					if(mapdataByRowStringArray[i].equalsIgnoreCase("\""+valueEntry.getKey()+"\""))
					{

						mapdataByRowvalueArray[i]= "\""+valueEntry.getValue()+"\"";
						break;
					}
				}}


			StringBuffer Finalvalue = new StringBuffer();
			for(int i=0;i<mapdataByRowvalueArray.length;i++){
				Finalvalue =Finalvalue.append(mapdataByRowvalueArray[i]);
				if(i!=mapdataByRowvalueArray.length-1){
					Finalvalue.append("|");
				}
			}
			String finalvalueString = Finalvalue.toString();

			createFile(globalVariables.Encryptfile+latestFileName, mapdataByRowString+"\n"+finalvalueString);
			runCommand(globalVariables.batFileCreation, globalVariables.batcommandwrite);

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return latestFileName;

	}

	public static String createPipeDelimFileAndConvertToGPG_Auth(String FilePath ,Map<String ,String> mapdataByValue) throws Exception   {
		Map<Integer ,List<String>> mapdataByRow = new HashMap<>();
		String latestFileName =globalVariables.memberAuthFileName+timeStamp+".csv";

		try{
			BufferedReader reader =new BufferedReader(new FileReader(FilePath));
			String row =null;

			int rowNumber =1;
			while((row = reader.readLine())!=null)	{
				mapdataByRow.put(rowNumber, Arrays.asList(row.split(",(=(?:[^\"]*\"[^\"]*\")*[^\"]*$)")));
				rowNumber++;
			}
			String mapdataByRowString=mapdataByRow.get(1).get(0).toString();
			String[] mapdataByRowStringArray=mapdataByRowString.split(Pattern.quote("|"));

			String mapdataByRowavalue=mapdataByRow.get(3).get(0).toString();
			String[] mapdataByRowvalueArray=mapdataByRowavalue.split(Pattern.quote("|"));
			for (Map.Entry<String,String> valueEntry : mapdataByValue.entrySet())  {

				for(int i=0;i<mapdataByRowStringArray.length;i++){

					if(mapdataByRowStringArray[i].equalsIgnoreCase("\""+valueEntry.getKey()+"\""))
					{

						mapdataByRowvalueArray[i]= "\""+valueEntry.getValue()+"\"";
						break;
					}
				}}


			StringBuffer Finalvalue = new StringBuffer();
			for(int i=0;i<mapdataByRowvalueArray.length;i++){
				Finalvalue =Finalvalue.append(mapdataByRowvalueArray[i]);
				if(i!=mapdataByRowvalueArray.length-1){
					Finalvalue.append("|");
				}
			}
			String finalvalueString = Finalvalue.toString();

			createFile(globalVariables.Encryptfile+latestFileName, mapdataByRowString+"\n"+finalvalueString);
			runCommand(globalVariables.batFileCreation, globalVariables.batcommandwrite);

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return latestFileName;

	}

	
	public static String createPipeDelimFileAndConvertToGPGWithRemovalField(String FilePath ,List<String> mapDataToRemove) throws Exception   {
		Map<Integer ,List<String>> mapdataByRow = new HashMap<>();
		String latestFileName =globalVariables.memberGenericFileName+timeStamp+".csv";

		try{
			BufferedReader reader =new BufferedReader(new FileReader(FilePath));
			String row =null;

			int rowNumber =1;
			while((row = reader.readLine())!=null)	{
				mapdataByRow.put(rowNumber, Arrays.asList(row.split(",(=(?:[^\"]*\"[^\"]*\")*[^\"]*$)")));
				rowNumber++;
			}
			String mapdataByRowString=mapdataByRow.get(1).get(0).toString();
			String[] mapdataByRowStringArray=mapdataByRowString.split(Pattern.quote("|"));
			List<String> list = new ArrayList<String>(Arrays.asList(mapdataByRowStringArray));
			
			String mapdataByRowavalue=mapdataByRow.get(3).get(0).toString();
			String[] mapdataByRowvalueArray=mapdataByRowavalue.split(Pattern.quote("|"));
			List<String> listvalue = new ArrayList<String>(Arrays.asList(mapdataByRowvalueArray));
			for (String valueEntry : mapDataToRemove)  {

				for(int i=0;i<mapdataByRowStringArray.length;i++){

					if(mapdataByRowStringArray[i].equalsIgnoreCase("\""+valueEntry+"\""))
					{
						list.remove(mapdataByRowStringArray[i]);
						listvalue.remove(mapdataByRowvalueArray[i]);
						break;
					}
				}}


			StringBuffer Finalvalue = new StringBuffer();
			StringBuffer FinalField = new StringBuffer();
			for(int i=0;i<list.size();i++){
				Finalvalue =Finalvalue.append(listvalue.get(i));
				if(i!=listvalue.size()-1){
					Finalvalue.append("|");
				}
			}
			for(int i=0;i<listvalue.size();i++){
				FinalField =FinalField.append(list.get(i));
				if(i!=list.size()-1){
					FinalField.append("|");
				}
			}
			String finalvalueString = Finalvalue.toString();
			String finalFieldString = FinalField.toString();

			createFile(globalVariables.Encryptfile+latestFileName, finalFieldString+"\n"+finalvalueString);
			runCommand(globalVariables.batFileCreation, globalVariables.batcommandwrite);

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return latestFileName;

	}
	
	public static Map<String ,String> readFileDataAddToMap(String FilePath ) throws Exception   {
		Map<Integer ,List<String>> mapdataByRow = new HashMap<>();

		Map<String ,String> mapdataByValue = new HashMap<>();
		try{
			BufferedReader reader =new BufferedReader(new FileReader(FilePath));
			String row =null;

			int rowNumber =1;
			while((row = reader.readLine())!=null)	{
				mapdataByRow.put(rowNumber, Arrays.asList(row.split(",(=(?:[^\"]*\"[^\"]*\")*[^\"]*$)")));
				rowNumber++;
			}
			String mapdataByRowString=mapdataByRow.get(1).get(0).toString();
			String[] mapdataByRowStringArray=mapdataByRowString.split(Pattern.quote("|"));

			String mapdataByRowavalue=mapdataByRow.get(2).get(0).toString();
			String[] mapdataByRowvalueArray=mapdataByRowavalue.split(Pattern.quote("|"));
			for(int i=0;i<mapdataByRowStringArray.length;i++){
				mapdataByValue.put(mapdataByRowStringArray[i], mapdataByRowvalueArray[i]);

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return mapdataByValue;

	}
	
	public static Map<String ,String> getFileDataOnMap(String FilePath ) throws Exception   {
		Map<Integer ,List<String>> mapdataByRow = new HashMap<>();
		Map<String ,String> finalMapapdataByRow = new HashMap<>();


		try{
			BufferedReader reader =new BufferedReader(new FileReader(FilePath));
			String row =null;

			int rowNumber =1;
			while((row = reader.readLine())!=null)	{
				mapdataByRow.put(rowNumber, Arrays.asList(row.split(",(=(?:[^\"]*\"[^\"]*\")*[^\"]*$)")));
				rowNumber++;
			}
			String mapdataByRowString=mapdataByRow.get(1).get(0).toString();
			String[] mapdataByRowStringArray=mapdataByRowString.split(Pattern.quote("|"));

			String mapdataByRowavalue=mapdataByRow.get(2).get(0).toString();
			String[] mapdataByRowvalueArray=mapdataByRowavalue.split(Pattern.quote("|"));

			for(int i=0;i<mapdataByRowStringArray.length;i++){

				finalMapapdataByRow.put(mapdataByRowStringArray[i].replace("\"", ""), mapdataByRowvalueArray[i].replace("\"", ""));

			}
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally{
			deleteFile(FilePath);
		}

		return finalMapapdataByRow;
	}


	public static List<String> getFileNamesInDirectory(String directoryPath){
		File directory =new File(directoryPath);
		File[] files = directory.listFiles();
		List<String> fileNames= new ArrayList<>();
		for(File file :files){
			fileNames.add(file.getName());
		}
		return fileNames;



	}
	public static  List<String>  putGetFilefromServer(String FileName,String OutBoundFileName,String errorFile) throws Exception
	{
		System.out.println("------------------Prcessing the File Using Ftp-----------------");
		batPutMemberOutboundGPGFile="cd " +globalVariables.memberFtpLocation+"\n"+"lcd "+globalVariables.EncryptedfileResult+"\n"+
				"put "+OutBoundFileName;
		batPutMemberGPGFile="cd " +globalVariables.memberFtpLocation+"\n"+"lcd "+globalVariables.EncryptedfileResult+"\n"+
				"put "+FileName+".gpg";
		
		batgetMemberGPGFileFTPLocation="cd " +globalVariables.memberFtpLocation+"\n"+"lcd "+globalVariables.decryptedfileResult+"\n"+
				"get "+FileName+".gpg";
		batgetOutboundGPGFileFTPLocation="cd " +globalVariables.memberFtpLocation+"\n"+"lcd "+globalVariables.decryptedfileResult+"\n"+
				"get "+OutBoundFileName;
		batgetMemberErrorFileFTPLocation="cd " +globalVariables.memberFtpLocationErrorControlFile+"\n"+"lcd "+globalVariables.decryptedfileResult+"\n"+
				"get "+globalVariables.generatedErrorFile;
		batgetMemberControlFileFTPLocation="cd " +globalVariables.memberFtpLocationErrorControlFile+"\n"+"lcd "+globalVariables.decryptedfileResult+"\n"+
				"get "+globalVariables.generatedControlFile;
		System.out.println("---------------Creating the Bat file for Puting the File to Server --------------------");
		createFile(batFileNamePsftpbat,batPutMemberGPGFile+"\n"+batPutMemberOutboundGPGFile );
		
		
		System.out.println("---------------Creating the Bat file for get the File from Server --------------------");
		if(errorFile==null){
		createFile(batFileNamePsftpbatget,batgetMemberGPGFileFTPLocation+"\n"+batgetOutboundGPGFileFTPLocation+"\n"+batgetMemberControlFileFTPLocation 
				+"\n"+batgetMemberErrorFileFTPLocation);
		}
		else{
			createFile(batFileNamePsftpbatget,batgetMemberGPGFileFTPLocation+"\n"+batgetOutboundGPGFileFTPLocation+"\n"+batgetMemberControlFileFTPLocation);
		}
		
		System.out.println("---------------Put the File to the Server --------------------");
		
		runCommand(batFileNamePsftp,batCommandWriteloadfile);
		Thread.sleep(20000);
		List<String> fileNames=	getFIleFromftpLocation(FileName+".gpg",OutBoundFileName,errorFile);
		return fileNames;
	}
	
	public static List<String> getFIleFromftpLocation(String processedFileName,String OutBoundFileName,String errorFile) throws Exception{

		
		System.out.println("---------------get the File to the Server --------------------");
		String[] filesArray;
		if(errorFile!=null){
		filesArray = new String[]{OutBoundFileName,processedFileName,globalVariables.generatedErrorFile,globalVariables.generatedControlFile};
		}
		else{
			filesArray = new String[]{OutBoundFileName,processedFileName,globalVariables.generatedControlFile};
		}
		int retryCount =50;
		List<String> fileNames;
		while ( retryCount > 0){
			TimeUnit.SECONDS.sleep(30);
		int count=0;
		runCommand(batFileNamePsftpget,batCommandWriteloadfileget);
		 fileNames = getFileNamesInDirectory(globalVariables.decryptedfileResult);
	for(int i=0;i<filesArray.length;i++){
			if(fileNames.contains(filesArray[i])){
		
				count++;
			}}
			
			if(count==filesArray.length)
			{
				break;
			}
			else{
				retryCount--;
				FileContentReader.deleteAllFilesInDirectory(globalVariables.decryptedfileResult);
			}
		   } 
		
		System.out.println("---------------Decrypting the files --------------------");
		fileNames = getFileNamesInDirectory(globalVariables.decryptedfileResult); 
		for(String fileName :fileNames ){
		String result = OpenPgpHelper.decryptFiles(globalVariables.decryptedfileResult,fileName, globalVariables.decryptedfileResultTo);
		}
		 fileNames = getFileNamesInDirectory(globalVariables.decryptedfileResultTo);
		 return fileNames;
	}
public static String  createOutboundFileAndEncrypt(Map<String,String> processedFile) throws Exception
{
	String outBoundFileName ="MEDHHS_EVV_Outbound_ControlFile_"+timeStamp+".csv";
	StringBuffer Finalvalue = new StringBuffer();
	Finalvalue.append("\"FileName\"|\"RecordCount\""+"\n");
	for(String fileName :processedFile.keySet()){
		Finalvalue.append("\""+fileName+"\"|\""+processedFile.get(fileName)+"\"\n");
		
	}
	Finalvalue.append("\""+outBoundFileName+"\"|\""+ Integer.toString(processedFile.size()+2)+"\"\n");
	Finalvalue.append("\""+CommonMethods.generatePastDate_MMddYYYY()+"\" - \""+CommonMethods.generateFutureDate_YYYY_MM_dd_Time()+"\"");
	
	createFile(globalVariables.Encryptfile+outBoundFileName, Finalvalue.toString());
	String result = OpenPgpHelper.encryptFile(globalVariables.Encryptfile+outBoundFileName, globalVariables.EncryptedfileResult+outBoundFileName+".gpg",keyPath);
    assertNotNull(result);
    return outBoundFileName+".gpg";
}
public static void deleteAllFilesInDirectory(String directoryPath)
	{
		File directory =new File(directoryPath);
		for(File file :directory.listFiles()){
			if(!file.isDirectory()){
				file.delete();
			}
		}
	}

public static void main(String[] args) throws Exception {
	Map<String,String> processedFile =new HashMap<String,String>();
	processedFile.put("abc", "1");
	processedFile.put("rahul", "1");
	createOutboundFileAndEncrypt(processedFile);
}
}







