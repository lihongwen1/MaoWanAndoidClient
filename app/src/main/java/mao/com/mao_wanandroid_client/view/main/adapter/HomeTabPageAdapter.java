package mao.com.mao_wanandroid_client.view.main.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

import mao.com.mao_wanandroid_client.application.Constants;
import mao.com.mao_wanandroid_client.view.drawer.fragment.CollectionFragment;
import mao.com.mao_wanandroid_client.view.drawer.fragment.CollectionWebFragment;
import mao.com.mao_wanandroid_client.view.drawer.fragment.PrivateArticleFragment;

/**
 * @author maoqitian
 * @Description 首页 tablayout fragment 适配器
 * @Time 2019/5/23 0023 23:01
 */
public class HomeTabPageAdapter extends FragmentPagerAdapter {

    List<String> mTitle;
    List<Fragment> mFragments;



    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HomeTabPageAdapter(FragmentManager fm, List<String> titles, List<Fragment> fragments) {
        super(fm);
        this.mTitle = titles;
        this.mFragments = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return mFragments.get(i);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle.get(position);
    }

    //注释父类实现，避免出现fragment 空白
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //super.destroyItem(container,position,object);
    }



    /**
     * CollectionFragment  CollectionWebFragment 收藏界面做处理，方便个人中心下拉刷新
     * @param object
     * @return
     */
    @Override
    public int getItemPosition(@NonNull Object object) {
        if(object instanceof CollectionFragment){
            if(Constants.REFRESH_TYPE.equals(type)){
                ((CollectionFragment) object).updateDate();
            }else if(Constants.LOAD_MORE_TYPE.equals(type)){
                ((CollectionFragment) object).loadDate();
            }else {
                return super.getItemPosition(object);
            }
        }else if(object instanceof CollectionWebFragment){
            if(Constants.REFRESH_TYPE.equals(type)){
                ((CollectionWebFragment) object).updateDate();
            }else if(Constants.LOAD_MORE_TYPE.equals(type)){
                ((CollectionWebFragment) object).loadDate();
            }else {
                return super.getItemPosition(object);
            }
        }else if(object instanceof PrivateArticleFragment){
            if(Constants.REFRESH_TYPE.equals(type)){
                ((PrivateArticleFragment) object).updateDate();
            }else if(Constants.LOAD_MORE_TYPE.equals(type)){
                ((PrivateArticleFragment) object).loadDate();
            }else {
                return super.getItemPosition(object);
            }
        }
        return super.getItemPosition(object);
    }
}
