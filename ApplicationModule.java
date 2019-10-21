@Module
public class ApplicationModule {
    private App app;
    public ApplicationModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    @AppContext
    Context provideContext(){
        return app;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharePref(@AppContext Context app){
        return app.getSharedPreferences("MIC_Shared_Pref", Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    SharedPreferences.Editor provideEditor(SharedPreferences sharedPreferences){
        return sharedPreferences.edit();
    }

    @Provides
    @Singleton
    SharedPrefUtil provideSharedPrefUtil(SharedPreferences sharedPreferences, SharedPreferences.Editor editor){
        return new SharedPrefUtil(sharedPreferences, editor);
    }



    @Provides
    @Singleton
    @BgExecutor
    Scheduler provideExecutorScheduler(){
        return Schedulers.io();
    }


    @Provides
    @Singleton
    @UiExecutor
    Scheduler provideUiScheduler() {
        return AndroidSchedulers.mainThread();
    }

    @Singleton
    @Provides
    String provideBaseUrl(){
        return  "http://my-inner-circle.com/micweb/Api_controller/";//BaseUrl
    }


    @Singleton
    @Provides
    Cache provideOkHttpCache(Context application) {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }


    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Cache cache) {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        if(BuildConfig.DEBUG) {
            client.addNetworkInterceptor(new StethoInterceptor());
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.level(HttpLoggingInterceptor.Level.BASIC);
            client.addInterceptor(logging);
        }

        client.cache(cache);
        return client.build();
    }


    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient, String BaseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BaseUrl)
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    @Provides
    @Singleton
    RestClient provideRestClient(Retrofit retrofit){
        return retrofit.create(RestClient.class);
    }
}
