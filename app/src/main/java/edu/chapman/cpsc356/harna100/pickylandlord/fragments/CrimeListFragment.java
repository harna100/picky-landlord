package edu.chapman.cpsc356.harna100.pickylandlord.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import edu.chapman.cpsc356.harna100.pickylandlord.R;
import edu.chapman.cpsc356.harna100.pickylandlord.models.CrimeCollection;
import edu.chapman.cpsc356.harna100.pickylandlord.models.CrimeModel;

public class CrimeListFragment extends Fragment {
	private List<CrimeModel> crimes;
	private ListView lv_listOfCrimes;

	public static CrimeListFragment NewInstance(){
		CrimeListFragment cfl = new CrimeListFragment();
		cfl.crimes = CrimeCollection.getInstance().getCrimes();

		return cfl;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_crime_list, container, false);
		getReferences(v);
		setList();
		return v;
	}

	private void setList() {
		lv_listOfCrimes.setAdapter(new ArrayAdapter(getContext() ,android.R.layout.simple_list_item_1, crimes));
	}

	public void getReferences(View v){
		lv_listOfCrimes = v.findViewById(R.id.lv_listOfCrimes);
	}
}
