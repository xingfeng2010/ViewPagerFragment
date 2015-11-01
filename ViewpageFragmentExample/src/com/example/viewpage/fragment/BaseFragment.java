package com.example.viewpage.fragment;

import com.example.viewpage.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BaseFragment extends Fragment {

	private TextView mTextView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.base_frag, container);
		mTextView = (TextView) view.findViewById(R.id.text);
		return view;
	}

	protected void setText(String str) {
		mTextView.setText(str);
	}
}
