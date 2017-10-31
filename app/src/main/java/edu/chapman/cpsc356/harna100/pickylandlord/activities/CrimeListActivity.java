package edu.chapman.cpsc356.harna100.pickylandlord.activities;

import android.support.v4.app.Fragment;

import edu.chapman.cpsc356.harna100.pickylandlord.fragments.CrimeListFragment;

/**
 * Created by Paul-HP on 10/30/2017.
 */

public class CrimeListActivity extends SingleFragmentActivity {
	@Override
	protected Fragment getFragment() {
		return CrimeListFragment.NewInstance();
	}
}
