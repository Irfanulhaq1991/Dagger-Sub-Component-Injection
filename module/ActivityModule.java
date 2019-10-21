@Module
public class ActivityModule {
    @Provides
    @ActivityContext
    Context provideContext(BaseActivity activity){
       return activity;
    }
}
