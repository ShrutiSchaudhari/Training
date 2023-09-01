package com.concerto.excel_reader;

import org.apache.poi.ss.usermodel.Row;

public interface ExcelDataProcessor<T> {
	T processRow(Row row);
}
