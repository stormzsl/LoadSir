package sample.kingja.loadsir.rtl;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.BidiFormatter;
import sample.kingja.loadsir.R;

/**
 * 作者:created by storm
 */

public class RtlActivity extends BaseRawActivity {

    private TextView mStringPlaceTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rtl_switch);
        mTitleBar.setTitleHasBack("",
                arg01 -> finish());
//        mStringPlaceTv = findViewById(R.id.tv_string_place);
//        processStringPlace();
    }

    private void processStringPlace() {
        String mySuggestion = "15 Bay Street, Laurel, CA";
        BidiFormatter bidiFormatter = BidiFormatter.getInstance();

// The "did_you_mean" localized string resource includes
// a "%s" placeholder for the suggestion.
        mStringPlaceTv.setText(String.format(getString(R.string.test_string_place), bidiFormatter.unicodeWrap(mySuggestion)));
//        mStringPlaceTv.setText(String.format(getString(R.string.test_string_place), mySuggestion));
    }
}
