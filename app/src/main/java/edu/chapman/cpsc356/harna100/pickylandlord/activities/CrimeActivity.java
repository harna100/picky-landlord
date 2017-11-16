package edu.chapman.cpsc356.harna100.pickylandlord.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import edu.chapman.cpsc356.harna100.pickylandlord.fragments.CrimeFragment;
import edu.chapman.cpsc356.harna100.pickylandlord.models.CrimeModel;

public class CrimeActivity extends SingleFragmentActivity {

	public static final String EXTRA_CRIME_ID = "crime_id";
	public static final String EXTRA_CRIME_TITLE = "crime_title";
	public static final String EXTRA_CRIME_SOLVED = "crime_solved";
	public static final String EXTRA_CRIME_DATE = "crime_date";
	@Override
	protected Fragment getFragment() {
		return CrimeFragment.NewInstance(getIntent().getExtras().getString(CrimeActivity.EXTRA_CRIME_ID));
	}

	@Override
	public void onBackPressed() {
		// fragment handles the keyboard being open
		finish();
	}

	public static Intent BuildIntent(Context context, CrimeModel crimeModel) {
		Intent intent = new Intent(context, CrimeActivity.class);
		intent.putExtra(CrimeActivity.EXTRA_CRIME_ID, crimeModel.getId());
		return intent;
	}
}
