package my.client;

import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */ 
@RemoteServiceRelativePath("search")
public interface SearchService extends RemoteService {
	Map<String, List> searchServer(String input, String url);
}
