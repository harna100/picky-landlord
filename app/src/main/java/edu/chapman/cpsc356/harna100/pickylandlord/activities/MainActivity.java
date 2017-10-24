package edu.chapman.cpsc356.harna100.pickylandlord.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import edu.chapman.cpsc356.harna100.pickylandlord.R;

import edu.chapman.cpsc356.harna100.pickylandlord.fragments.CrimeFragment;

public class MainActivity extends AppCompatActivity {

	private FrameLayout fl_fragmentContainer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getReferences();
		showFragment(CrimeFragment.NewInstance("Hello World", true));
	}

	private void showFragment(Fragment fragment) {
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
		ft.replace(R.id.fl_fragment_container, fragment);
		ft.addToBackStack(null);
		ft.commit();

	}

	private void getReferences() {
		fl_fragmentContainer = (FrameLayout) findViewById(R.id.fl_fragment_container);
	}


}
