package com.javatpoint.ecormspringboot.common.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConverterUtil {
	public static List<Long> convertObjectToList(Object pramValue) {
		List<Long> list = new ArrayList<>();
		String[] charts = ((String) pramValue).split(",");
		for (String string : charts) {
			long id = Long.parseLong(string);
			list.add(id);
		}
		return list;
	}
}
