package guru.diederik.scrollviewsanitycheck.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import guru.diederik.scrollviewsanitycheck.R;
import guru.diederik.scrollviewsanitycheck.databinding.FragmentDashboardBinding;
import io.flutter.embedding.android.FlutterFragment;
import io.flutter.embedding.android.TransparencyMode;

public class DashboardFragment extends Fragment {

    private static final String TAG_REP_GOALS_FLUTTER_FRAGMENT_1 = "FLUTTER_FRAGMENT_TAG_1";
    private static final String TAG_REP_GOALS_FLUTTER_FRAGMENT_2 = "FLUTTER_FRAGMENT_TAG_2";

    private FragmentDashboardBinding binding;
    private FlutterFragment mRepGoalsFlutterFragment1;
    private FlutterFragment mRepGoalsFlutterFragment2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDashboard;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        setupFlutterFragment();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setupFlutterFragment(){
        FragmentManager fragmentManager = getChildFragmentManager();

        if (mRepGoalsFlutterFragment1 == null) {
            mRepGoalsFlutterFragment1 = FlutterFragment.withNewEngine()
//                    .transparencyMode(TransparencyMode.opaque)
                    .build();
            fragmentManager
                    .beginTransaction()
                    .add(R.id.cardview7,
                            mRepGoalsFlutterFragment1,
                            TAG_REP_GOALS_FLUTTER_FRAGMENT_1)
                    .commit();
        }

        if (mRepGoalsFlutterFragment2 == null) {
            mRepGoalsFlutterFragment2 = FlutterFragment.withNewEngine()
//                    .transparencyMode(TransparencyMode.opaque)
                    .build();
            fragmentManager
                    .beginTransaction()
                    .add(R.id.cardView,
                            mRepGoalsFlutterFragment2,
                            TAG_REP_GOALS_FLUTTER_FRAGMENT_2)
                    .commit();
        }

    }

}