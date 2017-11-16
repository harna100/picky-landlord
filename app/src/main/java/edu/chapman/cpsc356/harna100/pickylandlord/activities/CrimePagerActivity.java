package edu.chapman.cpsc356.harna100.pickylandlord.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.chapman.cpsc356.harna100.pickylandlord.R;
import edu.chapman.cpsc356.harna100.pickylandlord.adapters.CrimePagerAdapter;

public class CrimePagerActivity extends AppCompatActivity {
	public static final String EXTRA_CRIME_POSITION = "crime_position";
	private ViewPager vp_crimes;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_crime_pager);
		getReferences();
		CrimePagerAdapter adapter = new CrimePagerAdapter(getSupportFragmentManager());
		vp_crimes.setAdapter(adapter);
		vp_crimes.setCurrentItem(getIntent().getExtras().getInt(EXTRA_CRIME_POSITION));
	}

	private void getReferences(){
		vp_crimes = findViewById(R.id.vp_crimes);
	}

	public static Intent BuildIntent(Context context, int position) {
		Intent intent = new Intent(context, CrimePagerActivity.class);
		intent.putExtra(CrimePagerActivity.EXTRA_CRIME_POSITION, position);
		return intent;
	}
}
