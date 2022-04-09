package com.springboot.SpringBootProject.reports;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tutorial")
@CrossOrigin("*")
public class ReportController {
	
//	@Autowired
//	private DiscoveryClient discoveryClient;
	
	@Autowired
	private ReportService reportService;
	
//	@Autowired
//	private RestTemplate restTemplate;
	
	private static final String EXTERNAL_FILE_PATH = "D:\\AllTutorials\\springboot\\projects\\springBootJPAtutorial\\";
	
	
	@GetMapping("/download")
	public void download(HttpServletResponse response) {
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=test.xlsx");
		ByteArrayInputStream stream = reportService.generateReport();
		try {
			IOUtils.copy(stream, response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		restTemplate.getForObject("http://reports/tutorial/download", String.class);
	}
	
//	@GetMapping("/reports")
//	public void test(HttpServletResponse response) {
////		List<ServiceInstance> instances=discoveryClient.getInstances("reports");
////		ServiceInstance serviceInstance=instances.get(0);
//		
////		String baseUrl=serviceInstance.getUri().toString();
////		System.out.println(baseUrl);
//		restTemplate.getForObject("/tutorial/test", String.class);
//	}
//	
	
	@GetMapping("/file")
	public void downloadPDFResource(HttpServletResponse response) throws IOException {
		Workbook workbook = null;
		final BufferedWriter writer = new BufferedWriter(new FileWriter(EXTERNAL_FILE_PATH+"output.txt", true));
//		response.setContentType("text/plain");
//		response.setHeader("Content-Disposition", "attachment; filename=result.txt");
		
		
		try {
		
			
			File folder = new File("D:\\AllTutorials\\springboot\\projects\\springBootJPAtutorial\\files");
			File[] listOfFiles = folder.listFiles();
			for (File file : listOfFiles) {
			    if (file.isFile()) {
			        System.out.println(file.getName());
			    }
			}
			
			File f =new File(EXTERNAL_FILE_PATH+"test.xls");
			 int i = f.getName().lastIndexOf('.');
			  String name = f.getName().substring(0,i);
			  File file2=new File(f.getParent(), name +"2"+ ".xls");
			  f.renameTo(file2);
			workbook = WorkbookFactory.create(f);
			Sheet sheet = workbook.getSheetAt(0);
			int noOfColumns = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println(noOfColumns);
			sheet.forEach(row -> {
//				if(row.getCell(0).getStringCellValue()!="") {
//					//all code 
//				}
				
				System.out.println(row.getCell(0).getStringCellValue());
				
				StringBuilder lineBuilder = new StringBuilder();
	            row.forEach(cell -> {
	                String value=cell.getStringCellValue();
	                System.out.println(value);
	                if(cell.getColumnIndex()==noOfColumns-1) {
	                	lineBuilder.append(value);
	                }else {
	                	lineBuilder.append(value).append(",");
	                }
	                
	            });
	            lineBuilder.append("\n");
	            try {
					writer.write(lineBuilder.toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
	        });
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			if(workbook!=null) {
				workbook.close();
			}
			if(writer!=null) {
				 writer.close();
			}
			
		}
		

		
	}
	
	public static File changeExtension(File f, String newExtension) {
		  int i = f.getName().lastIndexOf('.');
		  String name = f.getName().substring(0,i);
		  return new File(f.getParent(), name + newExtension);
		}
	
	private void writeToFile() throws IOException {
        FileOutputStream out = null;

        try {
            out = new FileOutputStream("oo.txt");
        } catch (IOException e) {
			// TODO: handle exception
		}finally {
            if (out != null) {
                out.close();
            }
        }
	}

}
