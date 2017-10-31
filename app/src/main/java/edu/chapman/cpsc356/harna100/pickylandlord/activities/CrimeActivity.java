package edu.chapman.cpsc356.harna100.pickylandlord.activities;

import android.support.v4.app.Fragment;

import edu.chapman.cpsc356.harna100.pickylandlord.fragments.CrimeFragment;

public class CrimeActivity extends SingleFragmentActivity {

	@Override
	protected Fragment getFragment() {
		return CrimeFragment.NewInstance("",false);
	}
}
