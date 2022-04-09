package com.springboot.SpringBootProject.reports;

import java.io.ByteArrayInputStream;

public interface ReportService {
	public ByteArrayInputStream generateReport();
	public ByteArrayInputStream xlToText();
}
