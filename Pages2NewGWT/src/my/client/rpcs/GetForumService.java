package my.client.rpcs;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


@RemoteServiceRelativePath("getForum")
public interface GetForumService extends RemoteService {

	public int getForum(int fid);
}
