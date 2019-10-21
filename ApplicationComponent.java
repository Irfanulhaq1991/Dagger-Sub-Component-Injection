@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        ApplicationModule.class,
        AppActivitiesFactoryModule.class
})
public interface ApplicationComponent extends AndroidInjector<TodoApplication> {

        @Component.Factory
        interface Factory {
            fun create(@BindsInstance applicationContext: Context): ApplicationComponent
        }

}
