package edu.chapman.cpsc356.harna100.pickylandlord.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import org.joda.time.format.DateTimeFormat;

import edu.chapman.cpsc356.harna100.pickylandlord.R;
import edu.chapman.cpsc356.harna100.pickylandlord.models.CrimeCollection;
import edu.chapman.cpsc356.harna100.pickylandlord.models.CrimeModel;


public class CrimeFragment extends Fragment {
	public static final String ARG_CRIME_ID = "crime_id";
	public static final String ARG_CRIME_POSITION = "crime_position";

	private final String TAG = "CrimeFragment";
	private EditText et_title;
	private CheckBox cb_solved;
	private CrimeModel crimeModel;
	private Button btn_date;

	public static CrimeFragment NewInstance(String title, boolean solved){
		CrimeFragment cf = new CrimeFragment();

		CrimeModel cm = new CrimeModel();
		cm.setTitle(title);
		cm.setSolved(solved);


		cf.setCrimeModel(cm);
		return cf;
	}

	public static CrimeFragment NewInstance(String title, boolean solved, String date){
		CrimeFragment cf = new CrimeFragment();

		CrimeModel cm = new CrimeModel();
		cm.setTitle(title);
		cm.setSolved(solved);
		cm.setDate(date);


		cf.setCrimeModel(cm);
		return cf;
	}

	public static CrimeFragment NewInstance(int position){
		CrimeFragment cf = new CrimeFragment();

		CrimeModel cm = CrimeCollection.getInstance().getCrimes().get(position);

		cf.setCrimeModel(cm);
		return cf;
	}

	public static CrimeFragment NewInstance(String crimeId){
		CrimeFragment cf = new CrimeFragment();

		CrimeModel cm = CrimeCollection.getInstance().getCrime(crimeId);

		cf.setCrimeModel(cm);
		return cf;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_crime, container, false);
		this.setHasOptionsMenu(true);
		getReferences(v);
		setListeners();
		return v;
	}

	@Override
	public void onStart() {
		super.onStart();
		setViews();
	}

	private void setViews() {
		et_title.setText(crimeModel.getTitle());
		cb_solved.setChecked(crimeModel.isSolved());
		btn_date.setText(crimeModel.getCreationDate().toString(DateTimeFormat.longDateTime()));
	}

	private void setCrimeModel(CrimeModel cm){
		crimeModel = cm;
	}

	private void getReferences(View v) {
		et_title = v.findViewById(R.id.et_title);
		cb_solved = v.findViewById(R.id.cb_solved);
		btn_date = v.findViewById(R.id.btn_date);
	}

	private void setListeners(){
		setTitleChanged();
		setCheckBoxChanged();
	}

	private void setTitleChanged(){
		et_title.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {

			}

			@Override
			public void afterTextChanged(Editable s) {
				Log.d(TAG, "afterTextChanged: Text Changed to: " + s.toString());
				crimeModel.setTitle(s.toString());
			}
		});
	}

	private void setCheckBoxChanged(){
		cb_solved.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				Log.d(TAG, "onCheckedChanged: Checkbox is checked:" + isChecked);
				crimeModel.setSolved(isChecked);
			}
		});
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.fragment_crime_detail, menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
			case R.id.menu_delete_crime:
				CrimeCollection.getInstance().getCrimes().remove(this.crimeModel);
				getActivity().finish();

				return true;
			default:
				return false;
		}
	}
}
