package mvpframework.bwie.com.myretrofit.net;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 杨杰 on 2017/12/1.
 */

public class RetrofitHelper {
    public static OkHttpClient okHttpClient;
    public static ServiceAPI serverApi;
    static {
        getOkHttpClient();
    }
    public static OkHttpClient getOkHttpClient(){
        if (okHttpClient==null){
            synchronized (RetrofitHelper.class){
                if (okHttpClient==null){
                    okHttpClient = new OkHttpClient();
                }
            }
        }
        return okHttpClient;
    }
    public static<T> T OnCreatApi(Class<T> tClass,String url){
         Retrofit retrofit=new Retrofit.Builder()
                 .baseUrl(url)
                 .addConverterFactory(GsonConverterFactory.create())
                 .build();
         return retrofit.create(tClass);
    }

    public static ServiceAPI getServerApi() {
        if (serverApi==null){
            synchronized (ServiceAPI.class){
                if (serverApi==null){
                    serverApi= OnCreatApi(ServiceAPI.class,UrlUtils.BASE_HOST);
                }
            }
        }
        return serverApi;
    }
}
