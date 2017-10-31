package edu.chapman.cpsc356.harna100.pickylandlord.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import edu.chapman.cpsc356.harna100.pickylandlord.R;


public abstract class SingleFragmentActivity extends AppCompatActivity {

	protected abstract Fragment getFragment();

	private FrameLayout fl_fragmentContainer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_single_fragment);
		getReferences();
		showFragment(getFragment());
//		showFragment(CrimeFragment.NewInstance("Hello World", true));
	}

	private void showFragment(Fragment fragment) {
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		ft.replace(R.id.fl_fragment_container, fragment);
		ft.addToBackStack(null);
		ft.commit();

	}

	private void getReferences() {
		fl_fragmentContainer = (FrameLayout) findViewById(R.id.fl_fragment_container);
	}


}
