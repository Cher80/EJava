package my.client;

import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>SearchService</code>.
 */
public interface SearchServiceAsync {
	void searchServer(String input, String url, AsyncCallback<Map> callback);
}
