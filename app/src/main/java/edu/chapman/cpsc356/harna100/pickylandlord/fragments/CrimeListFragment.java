package edu.chapman.cpsc356.harna100.pickylandlord.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import edu.chapman.cpsc356.harna100.pickylandlord.R;
import edu.chapman.cpsc356.harna100.pickylandlord.adapters.CrimeListAdapter;
import edu.chapman.cpsc356.harna100.pickylandlord.models.CrimeCollection;
import edu.chapman.cpsc356.harna100.pickylandlord.models.CrimeModel;
import android.support.v7.widget.RecyclerView;

public class CrimeListFragment extends Fragment {
	private List<CrimeModel> crimes;
	private RecyclerView rv_listOfCrimes;

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
		rv_listOfCrimes.setAdapter(new CrimeListAdapter(crimes));
		rv_listOfCrimes.setLayoutManager(new LinearLayoutManager(getContext()));
	}

	public void getReferences(View v){
		rv_listOfCrimes = v.findViewById(R.id.rv_listOfCrimes);
	}
}
