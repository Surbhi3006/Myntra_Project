import com.demo.grpc.User.APIResponse;
import com.demo.grpc.User.LoginRequest;
import com.demo.grpc.userGrpc;
import com.demo.grpc.userGrpc.userBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

	public static void main(String[] args) throws Exception 
	{
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",9091).usePlaintext().build();
		userBlockingStub stub = userGrpc.newBlockingStub(channel);
		LoginRequest loginrequest = LoginRequest.newBuilder().setUsername("surbhi").setPassword("test1").build();
		APIResponse response = stub.login(loginrequest);
		System.out.println(response);
	}
}
