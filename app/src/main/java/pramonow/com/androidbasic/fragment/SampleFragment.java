package pramonow.com.androidbasic.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pramonow.com.androidbasic.R;

public class SampleFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sample, container, false);

        TextView textView = view.findViewById(R.id.any_text);
        textView.setText("Curr time " + System.currentTimeMillis());

        return view;
    }
}
