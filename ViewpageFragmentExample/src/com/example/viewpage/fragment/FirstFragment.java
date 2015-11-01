package com.example.viewpage.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.viewpage.R;

public class FirstFragment extends Fragment {

	private TextView mTextView;

	public FirstFragment() {
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		/**
		 * View view = inflater.inflate(R.layout.base_frag, container) 改为null如下
		 * 可解决“The specified child already has a parent. You must call removeView()
		 *  on the child's parent first” 异常问题
		 */
		View view = inflater.inflate(R.layout.base_frag, null);
		mTextView = (TextView) view.findViewById(R.id.text);
		mTextView.setText("Fragment 1!");
		return view;
	}
}
