package edu.chapman.cpsc356.harna100.pickylandlord.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import edu.chapman.cpsc356.harna100.pickylandlord.models.CrimeModel;


public class CrimeListAdapter extends RecyclerView.Adapter<CrimeListAdapter.CrimeViewHolder> {
	private List<CrimeModel> crimeModelList;

	public CrimeListAdapter(List<CrimeModel> crimeModelList) {
		this.crimeModelList = crimeModelList;
	}

	@Override
	public CrimeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
		View v = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);

		return new CrimeViewHolder(v);
	}

	@Override
	public void onBindViewHolder(CrimeViewHolder holder, int position) {
		CrimeModel cm = crimeModelList.get(position);
		holder.setCrimeModel(cm);
	}

	@Override
	public int getItemCount() {
		// TODO: figure out if need to be calling the singleton instead of passing its list in the constructor
		return crimeModelList.size();
	}

 	class CrimeViewHolder extends RecyclerView.ViewHolder{

		private CrimeModel cm;
		private TextView tv_title;

		public CrimeViewHolder(View itemView) {
			super(itemView);
			tv_title = (TextView) itemView;
		}

		public void setCrimeModel(CrimeModel toSet){
			cm = toSet;
			setLayout();
		}

		private void setLayout(){
			tv_title.setText(cm.toString());
		}


	}
}
