package com.tts.guest.common.date_formate;

import android.annotation.SuppressLint;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.tts.guest.Config;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author sven-ou
 */
public class DefaultDateTimeSerializer extends JsonSerializer<Date> {

	@SuppressLint("SimpleDateFormat")
	@Override
	public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
        SimpleDateFormat formatter = new SimpleDateFormat(Config.DATE_TIME_PARTTERN, Locale.US);
        String formattedDate = formatter.format(value);  
        jgen.writeString(formattedDate);
	}
}
