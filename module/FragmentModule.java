@Module
public class FragmentModule {
    @Provides
    Fragment provideContext(ToolBarFragment fragment){
       return fragment;
    }
}
