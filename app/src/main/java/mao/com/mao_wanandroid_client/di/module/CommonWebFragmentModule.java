package mao.com.mao_wanandroid_client.di.module;



import dagger.Binds;
import dagger.Module;
import mao.com.mao_wanandroid_client.di.scope.FragmentScope;
import mao.com.mao_wanandroid_client.presenter.drawer.CommonWebContract;
import mao.com.mao_wanandroid_client.presenter.drawer.CommonWebPresenter;


/**
 * @author maoqitian
 * @Description CommonWebFragment 可以提供的注入对象Module
 * @Time 2019/3/27 0027 23:59
 */
@Module
public abstract class CommonWebFragmentModule {
    @FragmentScope
    @Binds
    abstract CommonWebContract.CommonFragmentPresenter bindPresenter(CommonWebPresenter presenter);
}


