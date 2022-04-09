package com.springboot.SpringBootProject.reports;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.SpringBootProject.models.User;
import com.springboot.SpringBootProject.repository.UserRepository;

@Service
public class ReportServiceImpl implements ReportService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public ByteArrayInputStream generateReport() {
		List<User> users = userRepository.findAll();
		Workbook workbook=new XSSFWorkbook();
		Sheet sheet=workbook.createSheet("user");
		users.forEach(user -> {
			Row row=sheet.createRow(0);
			Cell cell=row.createCell(0);
			cell.setCellValue(user.getLastName());
			row.createCell(1).setCellValue(user.getFirstName());
		});
		
		
		ByteArrayOutputStream outputSream=new ByteArrayOutputStream();
		try {
			workbook.write(outputSream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ByteArrayInputStream(outputSream.toByteArray());
		
		
	}

	@Override
	public ByteArrayInputStream xlToText() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
