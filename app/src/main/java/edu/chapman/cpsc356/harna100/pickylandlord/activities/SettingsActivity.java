package edu.chapman.cpsc356.harna100.pickylandlord.activities;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.chapman.cpsc356.harna100.pickylandlord.R;

public class SettingsActivity extends AppCompatActivity {
	public static final String KEY_SHARED_TEXT = "share_text";


	private EditText et_sharedText;
	private Button btn_save;
	private SharedPreferences sharedPrefs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		getReferences();
		setListeners();
		setupPrefs();
		setETSharedText(sharedPrefs.getString(KEY_SHARED_TEXT, ""));
	}

	private void setETSharedText(String string) {
		et_sharedText.setText(string);
	}

	private void setupPrefs() {
		sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
	}

	private void setListeners() {
		et_sharedText = findViewById(R.id.et_settingsShareText);
		btn_save = findViewById(R.id.btn_sharedSave);
	}

	private void getReferences() {

	}

	public void onClickSave(View view) {
		String shareText = et_sharedText.getText().toString();
		if(! shareText.isEmpty()){
			sharedPrefs.edit().putString(KEY_SHARED_TEXT, shareText).apply();
			Toast.makeText(this, "Settings saved successfully", Toast.LENGTH_SHORT).show();
			finish();
		}
	}
}
