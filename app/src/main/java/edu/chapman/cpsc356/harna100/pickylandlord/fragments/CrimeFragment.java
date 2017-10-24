package edu.chapman.cpsc356.harna100.pickylandlord.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import edu.chapman.cpsc356.harna100.pickylandlord.R;

/**
 * Created by Paul-HP on 10/18/2017.
 */

public class CrimeFragment extends Fragment {
	private final String TAG = "CrimeFragment";
	private EditText et_title;
	private CheckBox cb_solved;
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_crime, container, false);
		return v;
	}

	@Override
	public void onStart() {
		super.onStart();
		getReferences();
	}

	private void getReferences() {
		et_title = (EditText) getView().findViewById(R.id.et_title);
		cb_solved = (CheckBox) getView().findViewById(R.id.cb_solved);
	}
}
