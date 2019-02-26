package com.tts.guest.common.service.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tts.guest.Config;
import com.sv.common.web.client.HttpClientFactory;
import com.sv.common.util.Logger;
import com.tts.guest.common.service.RESTHttpService;
import com.tts.lib.utils.AES;

import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.http.ContentCodingType;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class RESTHttpServiceImpl implements RESTHttpService {

	private static final String TAG = RESTHttpServiceImpl.class.getSimpleName();
	public RESTHttpServiceImpl(){}

	@Override
	public <T> T put(String url, Object requestParam, Class<T> responseClass) {
		try{
			RestTemplate rt = getRestTemplate(getRequestFactory());
			Logger.d(TAG, url);
			HttpHeaders requestHeaders = new HttpHeaders();
			requestHeaders.setContentType(MediaType.APPLICATION_JSON);
			requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			requestHeaders.set("Charset", "UTF-8");
			ResponseEntity<T> response = rt.exchange(url, HttpMethod.PUT,
					new HttpEntity<Object>(requestParam, requestHeaders),
					responseClass, requestParam);

			return responseClass.cast(response.getBody());
		} catch (Exception e) {
			Logger.e(TAG, url + "{" + e.getClass().getSimpleName() + "} :" + e.getMessage());
			return null;
		}
	}

	@Override
	public <T> T get(String url, Map<String, Object> requestParam,
			Class<T> responseClass) {
		try {
			RestTemplate rt = getRestTemplate(getRequestFactory());
			rt.getMessageConverters().add(new ByteArrayHttpMessageConverter());
			Logger.d(TAG, url);

			HttpHeaders requestHeaders = new HttpHeaders();
			requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

			ResponseEntity<T> response = rt.exchange(url, HttpMethod.GET,
					new HttpEntity<Object>(requestHeaders), responseClass,
					requestParam);

			return responseClass.cast(response.getBody());
		} catch (Exception e) {
			Logger.e(TAG, url + "{" + e.getClass().getSimpleName() + "} :" + e.getMessage());
			return null;
		}
	}

	@Override
	public <T> T post(String url, Map<String, Object> requestParam, Class<T> responseClass) {
		try {

			RestTemplate rt = getRestTemplate(getRequestFactory());
			HttpHeaders requestHeaders = new HttpHeaders();
			requestHeaders.setContentType(MediaType.APPLICATION_JSON);
			requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(requestParam,requestHeaders);

			Logger.d(TAG, httpEntity.toString());
			ResponseEntity<T> response = rt.exchange(URI.create(url), HttpMethod.POST, httpEntity, responseClass);
			return responseClass.cast(response.getBody());

		} catch (Exception e) {
			Logger.e(TAG, url + "{" + e.getClass().getSimpleName() + "} :" + e.getMessage());
			return null;
		}
	}

	@Override
	public String postWithAES(String url, String json) {
		try {
			RestTemplate rt = getRestTemplate(getRequestFactory());
			Logger.d(TAG, url);
			byte[] body = AES.encrypt(json);
			HttpHeaders requestHeaders = new HttpHeaders();
//			requestHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//			requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_OCTET_STREAM));
			requestHeaders.setContentType(MediaType.APPLICATION_JSON);
			requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			ResponseEntity<byte[]> response = rt.exchange(url, HttpMethod.POST,
					new HttpEntity<byte[]>(body, requestHeaders),
					byte[].class);
			return AES.decrypt(response.getBody());
		} catch (Exception e) {
			Logger.e(TAG, url + "{" + e.getClass().getSimpleName() + "} :" + e.getMessage());
			return null;
		}
	}

	@Override
	public <T> T post(String url, Map<String, Object> requestParam, Class<T> responseClass, Map<String, ?> uriVariables) {
		try {

			RestTemplate rt = getRestTemplate(getRequestFactory());
			HttpHeaders requestHeaders = new HttpHeaders();
			requestHeaders.setContentType(MediaType.APPLICATION_JSON);
			requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(requestParam,requestHeaders);

			Logger.d(TAG, httpEntity.toString());

			ResponseEntity<T> response = rt.exchange(url, HttpMethod.POST, httpEntity, responseClass, uriVariables);
			return responseClass.cast(response.getBody());

		} catch (Exception e) {
			Logger.e(TAG, url + "{" + e.getClass().getSimpleName() + "} :" + e.getMessage());
			return null;
		}
	}

	@Override
	public <T> T  postWithGzip(String url, Object requestParam, Class<T> responseClass) {
		try {
			RestTemplate rt = getRestTemplate(getRequestFactory());

			Logger.d(TAG, url);

			HttpHeaders requestHeaders = new HttpHeaders();
			requestHeaders.set("Charset", "UTF-8");
			requestHeaders.setContentEncoding(ContentCodingType.GZIP);
			requestHeaders.setContentType(MediaType.APPLICATION_JSON);
			requestHeaders.set("Connection", "Keep-Alive");

			ResponseEntity<T> response = rt.exchange(url, HttpMethod.POST,
					new HttpEntity<Object>(requestParam, requestHeaders),
					responseClass);
			return responseClass.cast(response.getBody());
		} catch (Exception e) {
			Logger.e(TAG, url + "{" + e.getClass().getSimpleName() + "} :" + e.getMessage());
			return null;
		}
	}

	@Override
	public <T> T postFile(String url, MultiValueMap multiValueMap, Class<T> responseClass) {
		try {

			RestTemplate rt = getRestTemplate(getRequestFactory());

			HttpHeaders requestHeaders = new HttpHeaders();

			// Sending multipart/form-data
			requestHeaders.set("Charset", "UTF-8");
			requestHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

			// Populate the MultiValueMap being serialized and headers in an HttpEntity object to use for the request
			HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(
					multiValueMap, requestHeaders);

			// Make the network request, posting the message, expecting a String in response from the server
			ResponseEntity<T> response = rt.exchange(url, HttpMethod.POST, requestEntity,
					responseClass);

			return responseClass.cast(response.getBody());
		} catch (Exception e) {
			Logger.e(TAG, url + "{" + e.getClass().getSimpleName() + "} :" + e.getMessage());
			return null;
		}
	}

	@Override
	public byte[] getImageInContentTypeApplicationZip(String url, Object... requestParams) {
		try {
			Logger.d(TAG, url);

			RestTemplate rt = getRestTemplate(null);

			//add zip converter
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			objectMapper.setDateFormat(new SimpleDateFormat(Config.DATE_TIME_PARTTERN, Locale.US));
			MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
			messageConverter.setObjectMapper(objectMapper);

			List<MediaType> supportedMediaTypes = new ArrayList<MediaType>(3);
			supportedMediaTypes.add(new MediaType("application", "json", Charset.forName("UTF-8")));
			messageConverter.setSupportedMediaTypes(supportedMediaTypes);

			rt.getMessageConverters().add(messageConverter);

			//declare zip header
			HttpHeaders requestHeaders = new HttpHeaders();
			requestHeaders.setAccept(Collections.singletonList(MediaType.parseMediaType("application/zip")));
			requestHeaders.setContentType(MediaType.parseMediaType("application/zip"));

			ResponseEntity<byte[]> response = rt.exchange(url, HttpMethod.GET,
					new HttpEntity<Object>(requestHeaders), byte[].class, requestParams);

			return byte[].class.cast(response.getBody());
		} catch (Exception e) {
			Logger.e(TAG, url + "{" + e.getClass().getSimpleName() + "} :" + e.getMessage());
			return null;
		}
	}

	private static final int CONNECTION_TIMEOUT = 60*1000;
	private static final int READ_TIMEOUT = 60*1000;

	private RestTemplate getRestTemplate(ClientHttpRequestFactory requestFactory){
		RestTemplate rt;
		if (null != requestFactory) {
            rt = new RestTemplate(requestFactory);
        } else {
            rt = new RestTemplate();
        }

		if (rt.getRequestFactory() instanceof SimpleClientHttpRequestFactory) {
		    ((SimpleClientHttpRequestFactory) rt
			    .getRequestFactory()).setConnectTimeout(CONNECTION_TIMEOUT);
		    ((SimpleClientHttpRequestFactory) rt
			    .getRequestFactory()).setReadTimeout(READ_TIMEOUT);
		} else if (rt.getRequestFactory() instanceof HttpComponentsClientHttpRequestFactory) {
			Logger.d("HTTP", "HttpClient is used");
		    ((HttpComponentsClientHttpRequestFactory) rt
		    		.getRequestFactory()).setConnectTimeout(CONNECTION_TIMEOUT);
		    ((HttpComponentsClientHttpRequestFactory) rt
			    .getRequestFactory()).setReadTimeout(READ_TIMEOUT);
		}

		ObjectMapper om = new ObjectMapper();
		om.setDateFormat(new SimpleDateFormat(Config.DATE_TIME_PARTTERN, Locale.US));
		MappingJackson2HttpMessageConverter mc = new MappingJackson2HttpMessageConverter();
		mc.setObjectMapper(om);

		rt.getMessageConverters().add(mc);

		return rt;
	}

	private ClientHttpRequestFactory getRequestFactory(){

		HttpComponentsClientHttpRequestFactory requestFactory =
				new HttpComponentsClientHttpRequestFactory();

		HttpClientFactory factory = new HttpClientFactory();
		CloseableHttpClient httpClient = null;
		try {
			httpClient = factory.create(Config.getBaseURL());
		} catch (Exception e) {
			Logger.e(TAG, e.getMessage());
		}
		requestFactory.setHttpClient(httpClient);
		return requestFactory;
	}
}
