package edu.chapman.cpsc356.harna100.pickylandlord.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import edu.chapman.cpsc356.harna100.pickylandlord.R;
import edu.chapman.cpsc356.harna100.pickylandlord.fragments.CrimeListFragment;
import edu.chapman.cpsc356.harna100.pickylandlord.models.CrimeCollection;
import edu.chapman.cpsc356.harna100.pickylandlord.models.CrimeModel;

/**
 * Created by Paul-HP on 10/30/2017.
 */

public class CrimeListActivity extends SingleFragmentActivity {
	private CrimeListFragment crimeListFragment;
	@Override
	protected Fragment getFragment() {
		crimeListFragment = CrimeListFragment.NewInstance();
		return crimeListFragment;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.crime_list, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.menu_add_crime:
				CrimeCollection.getInstance().getCrimes().add(0, new CrimeModel());
				startActivity(CrimeActivity.BuildIntent(this,CrimeCollection.getInstance().getCrimes().get(0)));
				return true;
			case R.id.menu_solve_all:
				for (CrimeModel crimeModel : CrimeCollection.getInstance().getCrimes()) {
					crimeModel.setSolved(true);
				}
				crimeListFragment.notifyDataChanged();
				return true;
			case R.id.menu_settings:
				startActivity(new Intent(this, SettingsActivity.class));
				return true;
			default:
				return false;
		}
	}
}
