package user;

import com.demo.grpc.User.APIResponse;
import com.demo.grpc.User.Empty;
import com.demo.grpc.User.LoginRequest;
import com.demo.grpc.userGrpc.userImplBase;

import io.grpc.stub.StreamObserver;

public class UserService extends userImplBase{

	@Override
	public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver) 
	{
		System.out.println("Inside login");
		String username = request.getUsername();
		String password = request.getPassword();
		APIResponse.Builder response = APIResponse.newBuilder();
		if(username.equals("surbhi") && password.equals("test")) {
			response.setResponseCode(200).setResponsemessage("Login successful");
		}
		else {
			response.setResponseCode(100).setResponsemessage("User not allowed");
		}
		
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	@Override
	public void logout(Empty request, StreamObserver<APIResponse> responseObserver) {
		
	}
	

}
