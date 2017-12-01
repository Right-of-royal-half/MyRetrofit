package mvpframework.bwie.com.myretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import mvpframework.bwie.com.myretrofit.net.RetrofitHelper;
import mvpframework.bwie.com.myretrofit.net.ServiceAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ServiceAPI serverApi= RetrofitHelper.getServerApi();
        Call<bean> bean = serverApi.bean();
        bean.enqueue(new Callback<mvpframework.bwie.com.myretrofit.bean>() {
            @Override
            public void onResponse(Call<bean> call, Response<bean> response) {
                String s = response.body().getResults().get(0).toString();
                Log.d("qqqqqqqqqqqqqqqqqqqqq",s);
            }

            @Override
            public void onFailure(Call<bean> call, Throwable t) {

            }
        });
    }
}
