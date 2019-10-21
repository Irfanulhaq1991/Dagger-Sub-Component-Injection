@ActivityScope
@Subcomponent(modules = {
        ActivityModule.class,
        FragmentFactoryModule.class})
public interface BaseActivitySubComponent extends AndroidInjector<BaseActivity> {

    @Subcomponent.Factory
    public interface Factory extends AndroidInjector.Factory<BaseActivity> {
    }


}
