package com.tts.guest.common.service;

import org.springframework.util.MultiValueMap;

import java.util.Map;

public interface RESTHttpService {

	<T> T put(String url, Object requestParam, Class<T> responseClass);

	/**
	 * 只支持/xxx/xxx/xxx/请求，有问号的请求需要拼接
	 */
	<T> T get(String url, Map<String, Object> requestParam, Class<T> responseClass);

	byte[] getImageInContentTypeApplicationZip(String url, Object... requestParams);

	<T> T post(String url, Map<String, Object> requestParam, Class<T> responseClass);

	String postWithAES(String url, String json);

	<T> T post(String url, Map<String, Object> requestParam, Class<T> responseClass, Map<String, ?> uriVariables);

	<T> T postWithGzip(String url, Object requestParam, Class<T> responseClass);

	<T> T postFile(String url, MultiValueMap multiValueMap, Class<T> responseClass);
}
