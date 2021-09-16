package com.ot.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.ot.constants.FrameworkConstants;
import com.ot.enums.ConfigProperties;
import com.ot.exceptions.PropertyFileUsageException;


public final class PropertyUtils {

	private static Properties property = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<>();

	private PropertyUtils() {

	}

	static {
		try(FileInputStream fis = new FileInputStream(FrameworkConstants.getPropertyfilepath())) {
			property.load(fis);
			for (Map.Entry<Object, Object> entry : property.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
			}
		} 
		catch(IOException i) {
			i.printStackTrace();
			System.exit(0);
		}

	}


	public static String get(ConfigProperties key)  {
		if(Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new PropertyFileUsageException ("Property Name "+ key + " is not found, please check config properties");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}

}
