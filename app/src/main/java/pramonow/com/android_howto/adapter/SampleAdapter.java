package pramonow.com.android_howto.adapter;

import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pramonow.com.android_howto.R;

public class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.SampleVH> {

    @NonNull
    @Override
    public SampleVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_person,viewGroup,false);

        return new SampleVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SampleVH sampleVH, int i) {

        //do something with VH
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class SampleVH extends RecyclerView.ViewHolder{

        public SampleVH(@NonNull View itemView) {
            super(itemView);
        }
    }
}
