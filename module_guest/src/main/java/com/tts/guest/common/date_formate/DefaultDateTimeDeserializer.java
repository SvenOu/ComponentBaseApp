package com.tts.guest.common.date_formate;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.annotation.SuppressLint;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.tts.guest.Config;

/**
 *
 * @author sven-ou
 */
public class DefaultDateTimeDeserializer extends JsonDeserializer<Date> {
	@SuppressLint("SimpleDateFormat")
	@Override
	public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException, JsonProcessingException {
		String unformatedDate= jsonParser.getText();
		SimpleDateFormat sdf= new SimpleDateFormat(Config.DATE_TIME_PARTTERN,Locale.US);
		Date retVal;
		try {
			retVal = sdf.parse(unformatedDate);
		} catch (ParseException e) {
			return null;
		}
		return retVal;
	}
}
