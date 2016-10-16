package viewpager.lin.com.viewpager_daohang;

import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    /*
    数据源是  List<View>时   适配器用：PagerAdapter
    数据源是  List<Fragment>  适配器用 FragmentPagerAdapter 或 FragmentStatePagerAdapter
     */
    private List<View>viewList;
    private List<String> titleList;
    private ViewPager pager;  //实例
    private PagerTabStrip tab;  //标题实例
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        viewList=new ArrayList<View>();  //创建数据源

        //将布局转化为View对象   （上下文，ID,父组件）
        View view1=View.inflate(MainActivity.this,R.layout.view1,null);
        View view2=View.inflate(MainActivity.this,R.layout.view2,null);
        View view3=View.inflate(MainActivity.this,R.layout.view3,null);
        View view4=View.inflate(MainActivity.this,R.layout.view4,null);

        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewList.add(view4);

        //为每一个页面这种标题
        titleList=new ArrayList<String>();
        titleList.add("新朋友");
        titleList.add("群聊");
        titleList.add("公众号");
        titleList.add("空间");

        //为标题设置属性
        tab= (PagerTabStrip) findViewById(R.id.tab);  //标题对象
        tab.setDrawFullUnderline(false); //标题底部无线条
        tab.setBackgroundColor(4);  //设置标题背景颜色
        //tab.setTabIndicatorColor(color.GREEN); //设置菜单字样底部的线条颜色

        //初始化ViewPager
        pager= (ViewPager) findViewById(R.id.pager);

        //创建pagerAdapter适配器
        MyPagerAdapter myPagerAdapter=new MyPagerAdapter(viewList,titleList);
        pager.setAdapter(myPagerAdapter);

    }
}
