package edu.chapman.cpsc356.harna100.pickylandlord.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.DatePicker;

import org.joda.time.DateTime;

/**
 * Created by Paul-HP on 11/27/2017.
 */

public class DatePickerDialogFragment extends android.support.v4.app.DialogFragment {
	public static final int REQUEST_CODE = 1;
	public static final String EXTRA_DATE = "extra_date";
	private DateTime originalDate;
	private DatePicker picker;

	public static DatePickerDialogFragment NewInstance(DateTime originalDate) {
		DatePickerDialogFragment newFrag = new DatePickerDialogFragment();
		newFrag.setOriginalDate(originalDate);
//		newFrag.createViews();
//		newFrag.updateDate();
		return newFrag;
	}

	private void updateDate() {
		this.picker.init(originalDate.getYear(), originalDate.getMonthOfYear()-1, originalDate.getDayOfMonth(), null);
	}

	private void createViews() {
		this.picker = new DatePicker(getActivity());
	}

	public void setOriginalDate(DateTime originalDate) {
		this.originalDate = originalDate;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		createViews();
		updateDate();
		AlertDialog dialog = new AlertDialog.Builder(getActivity())
				.setTitle("Pick a  date")
				.setView(picker)
				.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Intent intent = new Intent();
						intent.putExtra(EXTRA_DATE, new DateTime(picker.getYear(), picker.getMonth() + 1, picker.getDayOfMonth(), originalDate.getHourOfDay(), originalDate.getMinuteOfHour()));
						getTargetFragment().onActivityResult(REQUEST_CODE, Activity.RESULT_OK, intent);
					}
				})
				.setNegativeButton(android.R.string.cancel, null)
				.create();

		return dialog;
	}
}
