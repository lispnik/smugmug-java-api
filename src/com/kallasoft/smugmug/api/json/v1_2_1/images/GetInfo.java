/* Copyright 2007 kallasoft
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kallasoft.smugmug.api.json.v1_2_1.images;

import com.kallasoft.smugmug.api.util.APIUtils;

/**
 * This class is a convenience class extending the base
 * {@link com.kallasoft.smugmug.api.json.v1_2_0.images.GetInfo} implementation.
 * 
 * @author Riyad Kalla
 * @version 1.2.1
 * @see com.kallasoft.smugmug.api.json.v1_2_0.images.GetInfo
 */
public class GetInfo extends
		com.kallasoft.smugmug.api.json.v1_2_0.images.GetInfo {
	/**
	 * Construct a new method instance that can be executed.
	 */
	public GetInfo() {
		this(METHOD_NAME, ARGUMENTS);
	}

	/**
	 * Construct a new method instance that can be executed with the given
	 * arguments.
	 * 
	 * @param methodName
	 *            The name of the SmugMug JSON API method that this
	 *            <em>Method</em> represents.
	 * @param arguments
	 *            The names of the arguments that this method accepts.
	 */
	public GetInfo(String methodName, String[] arguments) {
		super(methodName, arguments);
	}

	@Override
	public GetInfoResponse execute(String url, String[] argumentValues) {
		return new GetInfoResponse(executeImpl(url, argumentValues));
	}

	@Override
	public GetInfoResponse execute(String url, String apiKey, String sessionID,
			Long imageID, String imageKey) {
		return execute(url, apiKey, sessionID, imageID, imageKey, null, null);
	}

	@Override
	public GetInfoResponse execute(String url, String apiKey, String sessionID,
			Long imageID, String imageKey, String password,
			String sitePassword) {
		return execute(url, new String[] { apiKey, sessionID,
				APIUtils.toString(imageID), imageKey, password, sitePassword });
	}

	/**
	 * This class is a convenience class extending the base
	 * {@link com.kallasoft.smugmug.api.json.v1_2_0.images.GetInfo.GetInfoResponse}
	 * implementation.
	 * 
	 * @author Riyad Kalla
	 * @version 1.2.1
	 * @see com.kallasoft.smugmug.api.json.v1_2_0.images.GetInfo.GetInfoResponse
	 */
	public class GetInfoResponse
			extends
			com.kallasoft.smugmug.api.json.v1_2_0.images.GetInfo.GetInfoResponse {
		public GetInfoResponse(String responseText) {
			super(responseText);
		}
	}
}
