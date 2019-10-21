@Module(subcomponents = {
        AllContactFragmentSubComponent.class,
        BaseFragmentSubComponent.class})
public abstract class FragmentFactoryModule {
    @Binds
    @IntoMap
    @ClassKey(ToolBarFragment.class)
    abstract AndroidInjector.Factory<?> bindContactsConTainerFragment(BaseFragmentSubComponent.Factory factory);
    @Binds
    @IntoMap
    @ClassKey(AllContactsFragment.class)
    abstract AndroidInjector.Factory<?> bindAllContactsFragment(AllContactFragmentSubComponent.Factory factory);

}
