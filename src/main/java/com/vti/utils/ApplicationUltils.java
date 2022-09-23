//
package com.vti.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ApplicationUltils {

	public static Date getDateByString(String dateString) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-DD");
		Date date = (Date) formatter.parse(dateString);
		return date;
	}

}
