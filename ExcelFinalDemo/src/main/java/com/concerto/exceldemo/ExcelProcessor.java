package com.concerto.exceldemo;

import org.apache.poi.ss.usermodel.Row;

public interface ExcelProcessor<T> {
	T rowProcessor(Row row);
	

}
