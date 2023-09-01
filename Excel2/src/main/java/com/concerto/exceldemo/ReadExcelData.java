package com.concerto.exceldemo;

import org.apache.poi.ss.usermodel.Row;

public interface ReadExcelData {

	public Object processExcelRow(Row row);
}
