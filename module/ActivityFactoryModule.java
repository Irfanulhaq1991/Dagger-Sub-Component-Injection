@Module(subcomponents = {BaseActivitySubComponent.class})
public abstract class ActivityFactoryModule {
    @Binds
    @IntoMap
    @ClassKey(BaseActivity.class)
    abstract AndroidInjector.Factory<?> bindBaseActivity(BaseActivitySubComponent.Factory factory);
    @Binds
    @IntoMap
    @ClassKey(DashboardContainerActivity.class)
    abstract AndroidInjector.Factory<?> bindDashBoardActivity(DashBoardActivitySubComponent.Factory factory);

}
