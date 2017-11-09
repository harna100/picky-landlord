package edu.chapman.cpsc356.harna100.pickylandlord.activities;

import android.support.v4.app.Fragment;

import edu.chapman.cpsc356.harna100.pickylandlord.fragments.CrimeFragment;

public class CrimeActivity extends SingleFragmentActivity {

	@Override
	protected Fragment getFragment() {
		/*String title = getIntent().getExtras().getString("crime_title");
		boolean solved = getIntent().getExtras().getBoolean("crime_solved");
		String date = getIntent().getExtras().getString("crime_date");

		return CrimeFragment.NewInstance(title, solved, date);*/
		return CrimeFragment.NewInstance(getIntent().getExtras().getInt("crime_position"));
	}
}
