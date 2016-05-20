package esbromania.practica.bv.alzheimer.client.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import esbromania.practica.bv.alzheimer.client.R;
import esbromania.practica.bv.alzheimer.client.api.model.Greeting;

/**
 * @author Sebastian Niciu
 */
public class PlaceholderFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}
