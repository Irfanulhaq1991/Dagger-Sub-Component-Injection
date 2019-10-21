@FragmentScope
@Subcomponent(modules = {FragmentModule.class})
public interface BaseFragmentSubComponent extends AndroidInjector<ToolBarFragment> {
    @Subcomponent.Factory
    public interface Factory extends AndroidInjector.Factory<ToolBarFragment> {
    }
}
