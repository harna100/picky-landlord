package edu.chapman.cpsc356.harna100.pickylandlord.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import edu.chapman.cpsc356.harna100.pickylandlord.fragments.CrimeFragment;
import edu.chapman.cpsc356.harna100.pickylandlord.models.CrimeCollection;

/**
 * Created by Paul-HP on 11/15/2017.
 */

public class CrimePagerAdapter extends FragmentStatePagerAdapter {
	public CrimePagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		CrimeFragment cf = CrimeFragment.NewInstance(position);
		return cf;
	}

	@Override
	public int getCount() {
		return CrimeCollection.getInstance().getCrimes().size();
	}
}
