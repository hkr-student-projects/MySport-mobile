package com.mysport.mysport_mobile.profile;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
<<<<<<< Updated upstream
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

=======
>>>>>>> Stashed changes
import com.mysport.mysport_mobile.R;

public class UserProfile extends Fragment {



    @Override
<<<<<<< Updated upstream
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        return view;
=======
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);


>>>>>>> Stashed changes
    }
}