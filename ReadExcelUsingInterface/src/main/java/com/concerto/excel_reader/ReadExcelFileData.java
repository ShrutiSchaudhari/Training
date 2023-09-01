package com.concerto.excel_reader;

import org.apache.poi.ss.usermodel.Row;

public interface ReadExcelFileData {

	public Object processRow(Row row);
	
}
