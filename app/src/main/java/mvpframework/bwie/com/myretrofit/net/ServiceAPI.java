package mvpframework.bwie.com.myretrofit.net;

import mvpframework.bwie.com.myretrofit.bean;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by 杨杰 on 2017/12/1.
 */

public interface ServiceAPI {
  @GET(UrlUtils.TAGES)
    Call<bean> bean();
}
