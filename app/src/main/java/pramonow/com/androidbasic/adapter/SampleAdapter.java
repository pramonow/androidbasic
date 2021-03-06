package pramonow.com.androidbasic.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pramonow.com.androidbasic.R;
import pramonow.com.androidbasic.model.Person;
import pramonow.com.androidbasic.util.AdapterClickCallback;

/*
    Sample adapter to be used
    Need person and callback
 */
public class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.SampleVH> {

    List<Person> personList = new ArrayList<>();
    AdapterClickCallback adapterClickCallback;

    //Callback is obtained from activity that uses this
    public void setAdapterClickCallback(AdapterClickCallback adapterClickCallback)
    {
        this.adapterClickCallback = adapterClickCallback;
    }

    @NonNull
    @Override
    public SampleVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_person,viewGroup,false);
        return new SampleVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SampleVH sampleVH, int i) {
        sampleVH.setViewHolder(personList.get(i), adapterClickCallback);
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public void setPersonList(List<Person> personList)
    {
        this.personList = personList;
    }

    public class SampleVH extends RecyclerView.ViewHolder{

        TextView number,name,role;

        public SampleVH(@NonNull View itemView) {
            super(itemView);

            number = itemView.findViewById(R.id.number);
            name = itemView.findViewById(R.id.name);
            role = itemView.findViewById(R.id.role);
        }

        public void setViewHolder(final Person person, final AdapterClickCallback adapterClickCallback)
        {
            number.setText(person.getId().toString());
            name.setText(person.getName());

            //Set callback here to pass person data to our activity
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    adapterClickCallback.onAdapterClick(person);
                }
            });
        }
    }
}
