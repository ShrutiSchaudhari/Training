package com.concerto.exceldemo;

import java.util.List;

import org.apache.poi.ss.usermodel.Row;

public interface ReadExcelData {

	public Object processExcelRow(Row row);
}
