package com.example.mydemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubApi {
	@GET("users/{user}/followers")
	Call<List<UserModel>> loadFollowers(
			@Path("user") String user
	);
	Retrofit retrofit = new Retrofit.Builder()
			.baseUrl("https://api.github.com/")
			.addConverterFactory(GsonConverterFactory.create())
			.build();
}