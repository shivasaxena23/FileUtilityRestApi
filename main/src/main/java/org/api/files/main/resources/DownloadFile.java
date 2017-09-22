package org.api.files.main.resources;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;  
import javax.ws.rs.core.Response.ResponseBuilder;  

@Path("/downloadFile")  
public class DownloadFile {  
    private static final String FILE_PATH = "C:\\uploadedFiles\\";  
    
    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)  
    public Response getFile(@QueryParam("fileName") String fileName, @QueryParam("pageNo") int pageNo) {  
        
    	int counter = 0;
    			
    	File file = new File(FILE_PATH+fileName);  
    	
    	FileReader fileReader;
		
    	try {
		
			fileReader = new FileReader(file);
		
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String string = "";
			
			String line;
			
			while ((line = bufferedReader.readLine()) != null) {
			
				counter++;
				
				if(counter > (pageNo*50))
					break;
				
				if(counter > ((pageNo-1)*50)) {
					string = string + line;
					string = string + "\n";
				}
				
			}

			fileReader.close();
			
			if(string == "")
				string = "Page limit exceeded";
			
			ResponseBuilder response = Response.ok((Object) string);  
			
			//response.header("Content-Disposition","attachment; filename=\="fileName\"");  
		
			return response.build();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(500)
					.entity("Can find the file on server").build();
		}	 
    }  
}  

