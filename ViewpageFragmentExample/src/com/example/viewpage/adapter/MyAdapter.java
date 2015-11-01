package com.example.viewpage.adapter;

import java.util.List;

import com.example.viewpage.fragment.BaseFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

public class MyAdapter extends FragmentPagerAdapter {

	private List<Fragment> fragments;
	
	public MyAdapter(FragmentManager fm) {
		super(fm);
	}

	public MyAdapter(FragmentManager fm,List<Fragment> list) {
		super(fm);
		this.fragments = list;
	}
	
	@Override
	public Fragment getItem(int position) {
		return fragments.get(position);
	}

	@Override
	public int getCount() {
		return fragments.size();
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		return super.instantiateItem(container, position);
	}

}
