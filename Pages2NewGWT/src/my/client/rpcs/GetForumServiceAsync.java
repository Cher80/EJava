package my.client.rpcs;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GetForumServiceAsync {

	void getForum(int fid, AsyncCallback<Integer> callback);

}
