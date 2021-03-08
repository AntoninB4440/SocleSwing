package fr.diginamic.service.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

	public static LocalDate parseLocal(String date) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		return LocalDate.parse(date, formatter);

	}
}
