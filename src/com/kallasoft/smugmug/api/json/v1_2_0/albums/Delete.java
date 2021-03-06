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
package com.kallasoft.smugmug.api.json.v1_2_0.albums;

import com.kallasoft.smugmug.api.json.AbstractMethod;
import com.kallasoft.smugmug.api.json.AbstractResponse;
import com.kallasoft.smugmug.api.json.RuntimeJSONException;
import com.kallasoft.smugmug.api.util.APIUtils;

/**
 * This method deletes the specified Album and all photos within in.
 * 
 * @author Riyad Kalla
 * @version 1.2.0
 * @see <a
 *      href="http://smugmug.jot.com/WikiHome/1.2.0/smugmug.albums.delete">smugmug.albums.delete
 *      API Doc</a>
 */
public class Delete extends AbstractMethod {
	/**
	 * Defines the SmugMug JSON API method name that will be called.
	 */
	public static final String METHOD_NAME = "smugmug.albums.delete";

	/**
	 * Defines all the arguments this method takes.
	 * <p>
	 * Values are: "APIKey", "SessionID", "AlbumID"
	 */
	public static final String[] ARGUMENTS = { "APIKey", "SessionID", "AlbumID" };

	/**
	 * Construct a new method instance that can be executed.
	 */
	public Delete() {
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
	public Delete(String methodName, String[] arguments) {
		super(methodName, arguments);
	}

	/**
	 * Used to execute the smugmug.albums.delete method, returning a status of
	 * the delete operation.
	 * 
	 * @param url
	 *            The URL of the SmugMug server to communicate with.
	 * @param argumentValues
	 *            The argument values to pass to this method.
	 * 
	 * @return the response that includes a status of the delete operation.
	 */
	public DeleteResponse execute(String url, String[] argumentValues) {
		return new DeleteResponse(executeImpl(url, argumentValues));
	}

	/**
	 * Convenience method used to execute the smugmug.albums.delete method.
	 * <p>
	 * This method performs necessary conversions on all the argument values
	 * before calling {@link #execute(String, String[])}.
	 * 
	 * @param url
	 *            The URL of the SmugMug server to communicate with.
	 * @param apiKey
	 *            The API Key to use. API keys are issued by SmugMug.
	 * @param sessionID
	 *            The logged in SessionID that represents the user's session.
	 * @param albumID
	 *            The ID of the album that will be deleted.
	 * 
	 * @return the response that includes a status of the delete operation.
	 * 
	 * @see #execute(String, String[])
	 */
	public DeleteResponse execute(String url, String apiKey, String sessionID,
			Long albumID) {
		return execute(url, new String[] { apiKey, sessionID,
				APIUtils.toString(albumID) });
	}

	/**
	 * Class used to represent the response for the smugmug.albums.delete method
	 * call.
	 * <p>
	 * This response doesn't return any additional arguments. The stat code
	 * returned by {@link AbstractResponse#getStat()} indicates if the operation
	 * was successful or not.
	 * 
	 * @author Riyad Kalla
	 * @version 1.2.0
	 */
	public class DeleteResponse extends AbstractResponse {
		/**
		 * Construct a response by parsing the necessary values out of the JSON
		 * response text.
		 * 
		 * @param responseText
		 *            The JSON-formatted response text that came back from the
		 *            SmugMug API call.
		 * 
		 * @throws RuntimeJSONException
		 *             if an error occurs while parsing the JSON response text.
		 */
		public DeleteResponse(String responseText) throws RuntimeJSONException {
			/* Parse base response and any error if necessary */
			super(responseText);
		}

		@Override
		public String toString() {
			return DeleteResponse.class.getName() + "[isError=" + isError()
					+ "]";
		}
	}
}
