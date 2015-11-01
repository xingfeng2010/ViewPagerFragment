package com.example.viewpage;

import java.util.ArrayList;
import java.util.List;

import com.example.viewpage.adapter.MyAdapter;
import com.example.viewpage.fragment.BaseFragment;
import com.example.viewpage.fragment.FirstFragment;
import com.example.viewpage.fragment.SecondFragment;
import com.example.viewpage.fragment.ThirdFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends FragmentActivity {
	private static final String TAG = "MainActivity";
    private ViewPager mViewPager;
    private ImageView mImageView1;
    private ImageView mImageView2;
    private ImageView mImageView3;

    private OnPageChangeListener mOnPageChangeListener = new OnPageChangeListener() {

		/**
		 * 此方法是在状态改变的时候调用
		 * 有三种状态(0，1，2)。arg0 ==1的时辰默示正在滑动，arg0==2的时辰默示滑动完毕了，
		 * arg0==0的时辰默示什么都没做
		 */
		@Override
		public void onPageScrollStateChanged(int arg0) {
			Log.i(TAG,"onPageScrollStateChanged arg0:"+arg0);
			
		}

		/**
		 *  当页面在滑动的时候会调用此方法，在滑动被停止之前
		 *  arg0 :当前页面，及你点击滑动的页面
         *  arg1:当前页面偏移的百分比
         *  arg2:当前页面偏移的像素位置
		 */
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}

		/**
		 * 此方法是页面跳转完后得到调用，index是你当前选中的页面的Position(位置编号)
		 */
		@Override
		public void onPageSelected(int index) {
			Log.i(TAG,"onPageSelected index:"+index);
			
		}
		
	};

	private OnClickListener mOnClickListener= new OnClickListener() {

		@Override
		public void onClick(View view) {
			switch(view.getId()) {
			case R.id.first:
				mViewPager.setCurrentItem(0);
				break;
			case R.id.second:
				mViewPager.setCurrentItem(1);
				break;
			case R.id.third:
				mViewPager.setCurrentItem(2);
				break;
			}
		}
		
	};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initAdapter();
	}

	private void initView() {
		mViewPager = (ViewPager) this.findViewById(R.id.view_page);
		mImageView1 = (ImageView) this.findViewById(R.id.first);
		mImageView2 = (ImageView) this.findViewById(R.id.second);
		mImageView3 = (ImageView) this.findViewById(R.id.third);

		mImageView1.setOnClickListener(mOnClickListener);
		mImageView2.setOnClickListener(mOnClickListener);
		mImageView3.setOnClickListener(mOnClickListener);
	}

	private void initAdapter() {
		List<Fragment> list = new ArrayList<Fragment>();
		list.add(new FirstFragment());
		list.add(new SecondFragment());
		list.add(new ThirdFragment());
		mViewPager.setAdapter(new MyAdapter(this.getSupportFragmentManager(),list));
		mViewPager.setCurrentItem(0);
		
		mViewPager.setOnPageChangeListener(mOnPageChangeListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
