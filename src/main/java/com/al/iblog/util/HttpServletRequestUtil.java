package com.al.iblog.util;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class HttpServletRequestUtil {
	public static int getInt(HttpServletRequest request, String key) {
		try {
			return Integer.decode(request.getParameter(key));
		} catch (Exception e) {
			return -1;
		}
	}

	public static long getLong(HttpServletRequest request, String key) {
		try {
			return Long.valueOf(request.getParameter(key));
		} catch (Exception e) {
			return -1;
		}
	}

	public static double getDouble(HttpServletRequest request, String key) {
		try {
			return Double.valueOf(request.getParameter(key));
		} catch (Exception e) {
			return -1d;
		}
	}

	public static boolean getBoolean(HttpServletRequest request, String key) {
		try {
			return Boolean.valueOf(request.getParameter(key));
		} catch (Exception e) {
			return false;
		}
	}

	public static Map<String, String> getParams(HttpServletRequest request) {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		List<FileItem> items;
		Map<String, String> param = null;
		try {
			items = upload.parseRequest(request);
			param = new HashMap<String, String>();
			for (FileItem fileItem : items) {
				if (fileItem.isFormField()) {
					param.put(fileItem.getFieldName(), fileItem.getString("utf-8"));
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return param;
	}

	public static String getString(HttpServletRequest request, String key) {
		try {
			// request.setCharacterEncoding("UTF-8");
			String result = request.getParameter(key);
			if (result != null) {
				result = result.trim();
			}
			if ("".equals(result)) {
				result = null;
			}
			return result;
		} catch (Exception e) {
			return null;
		}
	}
}
