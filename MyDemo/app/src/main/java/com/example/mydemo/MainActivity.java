package com.example.mydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final GitHubApi gitHubApi = GitHubApi.retrofit.create(GitHubApi.class);

				//Sets up up the API call
				Call<List<UserModel>> call = gitHubApi.loadFollowers("krishmasand");

				//Runs the call on a different thread
				call.enqueue(new Callback<List<UserModel>>() {
					@Override
					//Once the call has finished
					public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
						//Gets the list of userModel
						List<UserModel> userModels = response.body();
						Toast.makeText(getApplicationContext(),userModels.get(0).toString(),Toast.LENGTH_SHORT).show();
					}

					@Override
					//If the call failed
					public void onFailure(Call<List<UserModel>> call, Throwable t) {
						Log.d("test", "Request failed");
					}
				});
			}
		}

